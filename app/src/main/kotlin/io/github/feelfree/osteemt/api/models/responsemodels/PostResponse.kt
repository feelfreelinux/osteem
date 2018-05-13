package io.github.feelfree.osteemt.api.models.responsemodels

import com.squareup.moshi.Json

data class PostResponse(
        @Json(name = "id")
        val id : Int,

        @Json(name = "author")
        val author : String,

        @Json(name = "permlink")
        val permlink : String,

        @Json(name = "category")
        val category : String,

        @Json(name = "created")
        val created : String,

        @Json(name = "title")
        val title : String,

        @Json(name = "body")
        val body : String,

        @Json(name = "json_metadata")
        val jsonMetadata : String,

        @Json(name = "pending_payout_value")
        val pendingPayoutValue : String,

        @Json(name = "children")
        val children : Int,

        @Json(name = "net_votes")
        val netVotes : Int
)