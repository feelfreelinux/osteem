package io.github.feelfree.osteemt.ui.modules.feed

import io.github.feelfree.osteemt.api.repository.posts.PostsApi
import io.github.feelfree.osteemt.base.BasePresenter
import io.github.feelfree.osteemt.base.Schedulers

class FeedFragmentPresenter(val schedulers: Schedulers, val postsApi: PostsApi) : BasePresenter<FeedFragmentView>() {
    var page = 1
    fun loadTrendingPosts(shouldRefresh : Boolean) {
        compositeObservable.add(
                postsApi.getDiscussionsByTrending("", 60)
                        .subscribeOn(schedulers.backgroundThread())
                        .observeOn(schedulers.mainThread())
                        .subscribe({ view?.showPosts(it, shouldRefresh) }, { view?.showErrorDialog(it) })
        )
    }
}