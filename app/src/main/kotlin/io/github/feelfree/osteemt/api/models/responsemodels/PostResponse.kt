package io.github.feelfree.osteemt.api.models.responsemodels

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class PostResponse(
        @JsonProperty("id")
        val id : Int,

        @JsonProperty("author")
        val author : String,

        @JsonProperty("permlink")
        val permlink : String,

        @JsonProperty("category")
        val category : String,

        @JsonProperty("created")
        val created : String,

        @JsonProperty("title")
        val title : String,

        @JsonProperty("tags")
        val tags : List<String>,

        @JsonProperty("images")
        val images : List<String>,

        @JsonProperty("links")
        val links : List<String>,

        @JsonProperty("description")
        val description : String,

        @JsonProperty("comments")
        val children : Int,

        @JsonProperty("votes")
        val votes : Int,

        @JsonProperty("pendingPayoutValue")
        val pendingPayoutValue : String
)