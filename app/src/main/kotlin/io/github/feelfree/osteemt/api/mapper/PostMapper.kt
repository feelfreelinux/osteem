package io.github.feelfree.osteemt.api.mapper

import io.github.feelfree.osteemt.api.models.apimodels.JsonMetadata
import io.github.feelfree.osteemt.api.models.responsemodels.PostResponse
import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.github.feelfree.osteemt.utils.toPrettyDate

val PostMapper : Mapper<PostResponse, Post> = {
    Post(it.id, it.author, it.permlink, it.category, it.created.toPrettyDate(), it.title, it.body, JsonMetadata(), it.pendingPayoutValue, it.children, it.netVotes)
}