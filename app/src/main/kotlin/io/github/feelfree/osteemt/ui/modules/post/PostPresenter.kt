package io.github.feelfree.osteemt.ui.modules.post

import io.github.feelfree.osteemt.api.repository.posts.PostsApi
import io.github.feelfree.osteemt.base.BasePresenter
import io.github.feelfree.osteemt.base.Schedulers

class PostPresenter(val schedulers: Schedulers, private val postsApi: PostsApi) : BasePresenter<PostView>() {
    fun loadDiscussion(author : String, permlink : String) {
        /*compositeObservable.add(
                postsApi.getDiscussion(author, permlink)
                        .subscribeOn(schedulers.backgroundThread())
                        .observeOn(schedulers.mainThread())
                        .subscribe({ view?.showPost(it) }, { view?.showError(it) })
        )*/
    }
}