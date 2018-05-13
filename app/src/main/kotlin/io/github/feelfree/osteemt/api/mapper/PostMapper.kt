package io.github.feelfree.osteemt.api.mapper

import io.github.feelfree.osteemt.api.models.apimodels.JsonMetadata
import io.github.feelfree.osteemt.api.models.responsemodels.PostResponse
import io.github.feelfree.osteemt.api.models.viewmodels.Post

val PostMapper : Mapper<PostResponse, Post> = {
    Post(it.id, it.author, it.permlink, it.category, it.created, it.title, it.body, JsonMetadata(), it.pendingPayoutValue, it.children, it.netVotes)
}