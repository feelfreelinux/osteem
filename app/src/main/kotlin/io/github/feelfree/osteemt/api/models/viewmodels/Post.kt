package io.github.feelfree.osteemt.api.models.viewmodels

class Post(
        val id: Int,
        val author: String,
        val permlink: String,
        val category: String,
        val createdAt: String,
        val title: String,
        val pendingPayoutValue: String,
        val children: Int,
        val votes: Int,
        val description: String,
        val body: String,
        val images: List<String>,
        val links: List<String>,
        val tags: List<String>
) {
    val avatarUrl = "https://steemitimages.com/u/$author/avatar"
    val thumbnail: String?
        get() = images.firstOrNull()

    val isHtml: Boolean = false
}