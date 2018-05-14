package io.github.feelfree.osteemt.api.models.responsemodels

import com.fasterxml.jackson.annotation.JsonProperty

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

        @JsonProperty("body")
        val body : String,

        @JsonProperty("json_metadata")
        val jsonMetadata : String,

        @JsonProperty("pending_payout_value")
        val pendingPayoutValue : String,

        @JsonProperty("children")
        val children : Int,

        @JsonProperty("net_votes")
        val netVotes : Int
)