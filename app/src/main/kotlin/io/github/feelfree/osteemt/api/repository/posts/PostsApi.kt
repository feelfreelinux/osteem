package io.github.feelfree.osteemt.api.repository.posts

import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.reactivex.Single

interface PostsApi {
    fun getDiscussionsByTrending(tag : String, truncateAt : Int) : Single<List<Post>>
}