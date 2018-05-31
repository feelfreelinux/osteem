package io.github.feelfree.osteemt.api.models.viewmodels

import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import io.github.feelfree.osteemt.api.models.apimodels.JsonMetadata

class Post(
        val id: Int,
        val author: String,
        val permlink: String,
        val category: String,
        val createdAt: String,
        val title: String,
        val body: String,
        val jsonMetadata: JsonMetadata?,
        val pendingPayoutValue: String,
        val children: Int,
        val netVotes: Int
) {
    val avatarUrl = "https://steemitimages.com/u/$author/avatar"
    val thumbnail: String?
        get() =
            if (jsonMetadata?.image != null && jsonMetadata.image.isNotEmpty()) {
                jsonMetadata.image.first()
            } else null

    val description: CharSequence? by lazy {
        when {
            isHtml -> body
            else -> {
                val parser = Parser.builder().build()
                val renderer = HtmlRenderer.builder().build()
                val document = parser.parse(body)
                renderer.render(document)
            }
        }
    }

    val isHtml: Boolean = jsonMetadata?.format == JsonMetadata.TYPE_HTML
}