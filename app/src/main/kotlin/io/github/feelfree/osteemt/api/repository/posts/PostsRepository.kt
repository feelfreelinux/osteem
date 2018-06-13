package io.github.feelfree.osteemt.api.repository.posts

import io.github.feelfree.osteemt.api.mapper.PostMapper
import io.github.feelfree.osteemt.api.models.apimodels.SteemRequest
import io.github.feelfree.osteemt.api.models.requestmodels.GetDiscussionParams
import io.github.feelfree.osteemt.api.models.requestmodels.GetDiscussionsParams
import io.github.feelfree.osteemt.api.models.responsemodels.PostResponse
import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.github.feelfree.osteemt.api.rx.SteemReponseWrapper
import io.reactivex.Single
import retrofit2.Retrofit

class PostsRepository(val retrofit : Retrofit) : PostsApi {
    override fun getDiscussionsByTrending(tag: String?, author : String?, permlink : String?): Single<List<Post>> =
        postsApi.getDiscussionsByTrending(tag, author, permlink)
                .compose(SteemReponseWrapper<List<PostResponse>>())
                .map { it.map(PostMapper) }

    override fun getDiscussion(author: String, permlink: String): Single<Post> =
        postsApi.getDiscussion(SteemRequest("condenser_api.get_content", listOf(author, permlink)))
                .compose(SteemReponseWrapper<PostResponse>())
                .map(PostMapper)

    private val postsApi by lazy { retrofit.create(PostsRetrofitApi::class.java) }
}