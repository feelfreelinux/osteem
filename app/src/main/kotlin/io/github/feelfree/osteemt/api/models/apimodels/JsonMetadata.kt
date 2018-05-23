package io.github.feelfree.osteemt.api.models.apimodels

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class JsonMetadata(
        @JsonProperty("tags")
        val tags : List<String>? = emptyList(),

        @JsonProperty("app")
        val app : String,

        @JsonProperty("format")
        val format : String? = TYPE_MARKDOWN,

        @JsonProperty("thumbnail")
        val thumbnail : String?,

        @JsonProperty("users")
        val users : List<String>? = emptyList(),

        @JsonProperty("links")
        val links : List<String>? = emptyList(),

        @JsonProperty("image")
        val image : List<String>? = emptyList()
) {
    companion object {
        val TYPE_MARKDOWN = "markdown"
        val TYPE_HTML = "html"
    }
}