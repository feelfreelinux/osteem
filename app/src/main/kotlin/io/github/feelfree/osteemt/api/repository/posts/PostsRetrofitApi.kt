package io.github.feelfree.osteemt.api.repository.posts

import io.github.feelfree.osteemt.api.models.apimodels.SteemRequest
import io.github.feelfree.osteemt.api.models.apimodels.SteemResponse
import io.github.feelfree.osteemt.api.models.responsemodels.PostResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PostsRetrofitApi {
    @POST("/")
    fun getDiscussionsByTrending(@Body params : SteemRequest) : Single<SteemResponse<List<PostResponse>>>

    @GET("/v1/articles/trending")
    fun getDiscussionsByTrending(
            @Query("tag")
            tag : String?,
            @Query("startAuthor")
            startAuthor : String?,
            @Query("startPermlink")
            startPermlink : String?
    ) : Single<SteemResponse<List<PostResponse>>>

    @POST("/")
    fun getDiscussion(@Body params : SteemRequest) : Single<SteemResponse<PostResponse>>
}