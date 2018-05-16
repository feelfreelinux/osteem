package io.github.feelfree.osteemt.api.repository.posts

import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.reactivex.Single

interface PostsApi {
    fun getDiscussionsByTrending(tag : String, truncateAt : Int, author : String? = null, permlink : String? = null) : Single<List<Post>>
}