package io.github.feelfree.osteemt.api.repository.posts

import io.github.feelfree.osteemt.api.mapper.PostMapper
import io.github.feelfree.osteemt.api.models.apimodels.SteemRequest
import io.github.feelfree.osteemt.api.models.requestmodels.GetDiscussionsParams
import io.github.feelfree.osteemt.api.models.responsemodels.PostResponse
import io.github.feelfree.osteemt.api.rx.SteemReponseWrapper
import retrofit2.Retrofit

class PostsRepository(val retrofit : Retrofit) : PostsApi {
    override fun getDiscussionsByTrending(tag: String, truncateAt: Int) =
        postsApi.getDiscussionsByTrending(SteemRequest("condenser_api.get_discussions_by_trending", GetDiscussionsParams(tag, truncateAt)))
                .compose(SteemReponseWrapper<List<PostResponse>>())
                .map { it.map(PostMapper) }

    private val postsApi by lazy { retrofit.create(PostsRetrofitApi::class.java) }

}