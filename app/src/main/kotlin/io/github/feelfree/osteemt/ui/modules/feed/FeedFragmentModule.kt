package io.github.feelfree.osteemt.ui.modules.feed

import dagger.Module
import dagger.Provides
import io.github.feelfree.osteemt.api.repository.posts.PostsApi
import io.github.feelfree.osteemt.base.Schedulers

@Module
class FeedFragmentModule {
    @Provides
    fun providePresenter(schedulers: Schedulers, postsApi: PostsApi) = FeedFragmentPresenter(schedulers, postsApi)
}