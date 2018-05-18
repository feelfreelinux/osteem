package io.github.feelfree.osteemt.api.models.apimodels

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class JsonMetadata(
        @JsonProperty("tags")
        val tags : List<String>,

        @JsonProperty("app")
        val app : String,

        @JsonProperty("format")
        val format : String,

        @JsonProperty("language")
        val language : String,

        @JsonProperty("thumbnail")
        val thumbnail : String,

        @JsonProperty("users")
        val users : List<String>,

        @JsonProperty("links")
        val links : List<String>,

        @JsonProperty("image")
        val image : List<String>
) {
    companion object {
        val TYPE_MARKDOWN = "markdown"
        val TYPE_HTML = "html"
    }
}