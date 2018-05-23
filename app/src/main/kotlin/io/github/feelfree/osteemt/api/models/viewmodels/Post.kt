package io.github.feelfree.osteemt.api.models.viewmodels

import io.github.feelfree.osteemt.api.models.apimodels.JsonMetadata

class Post(
        val id : Int,
        val author : String,
        val permlink : String,
        val category : String,
        val createdAt : String,
        val title : String,
        val body : String,
        jsonMetadata : JsonMetadata,
        val pendingPayoutValue : String,
        val children : Int,
        val netVotes : Int
) {
    val avatarUrl = "https://steemitimages.com/u/$author/avatar"
    val thumbnail : String? =
            if (jsonMetadata.image.isNotEmpty()) {
                jsonMetadata.image.first()
            } else null
}