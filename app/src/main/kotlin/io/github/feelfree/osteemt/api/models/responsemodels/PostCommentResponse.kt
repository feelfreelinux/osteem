package io.github.feelfree.osteemt.api.models.responsemodels

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class PostCommentResponse(
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

        @JsonProperty("body")
        val body : String,

        @JsonProperty("json_metadata")
        val jsonMetadata : String,

        @JsonProperty("root_title")
        val rootTitle : String,

        @JsonProperty("root_author")
        val rootAuthor : String,

        @JsonProperty("root_permlink")
        val rootPermlink : String,

        @JsonProperty("depth")
        val depth : Int,

        @JsonProperty("pending_payout_value")
        val pendingPayoutValue : String,

        @JsonProperty("children")
        val children : Int,

        @JsonProperty("net_votes")
        val netVotes : Int
)