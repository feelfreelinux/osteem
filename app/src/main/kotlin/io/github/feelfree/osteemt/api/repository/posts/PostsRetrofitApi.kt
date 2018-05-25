package io.github.feelfree.osteemt.api.repository.posts

import io.github.feelfree.osteemt.api.models.apimodels.SteemRequest
import io.github.feelfree.osteemt.api.models.apimodels.SteemResponse
import io.github.feelfree.osteemt.api.models.responsemodels.PostResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface PostsRetrofitApi {
    @POST("/")
    fun getDiscussionsByTrending(@Body params : SteemRequest) : Single<SteemResponse<List<PostResponse>>>

    @POST("/")
    fun getDiscussion(@Body params : SteemRequest) : Single<SteemResponse<PostResponse>>
}