package io.github.feelfree.osteemt.ui.modules.feed

import io.github.feelfree.osteemt.api.repository.posts.PostsApi
import io.github.feelfree.osteemt.base.BasePresenter
import io.github.feelfree.osteemt.base.Schedulers

class FeedFragmentPresenter(val schedulers: Schedulers, private val postsApi: PostsApi) : BasePresenter<FeedFragmentView>() {
    fun loadTrendingPosts(shouldRefresh : Boolean, startAuthor : String? = null, startPermlink : String? = null) {
        compositeObservable.add(
                postsApi.getDiscussionsByTrending(null, startAuthor, startPermlink)
                        .subscribeOn(schedulers.backgroundThread())
                        .observeOn(schedulers.mainThread())
                        .subscribe({
                            if (startAuthor != null && startPermlink != null) {
                                view?.showPosts(it.subList(1, it.size), shouldRefresh)
                            } else {
                                view?.showPosts(it, shouldRefresh)
                            }
                        }, { view?.showError(it) })
        )
    }
}