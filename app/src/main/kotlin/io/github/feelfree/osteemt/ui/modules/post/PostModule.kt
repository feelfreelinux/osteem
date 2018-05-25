package io.github.feelfree.osteemt.ui.modules.post

import dagger.Module
import dagger.Provides
import io.github.feelfree.osteemt.api.repository.posts.PostsApi
import io.github.feelfree.osteemt.base.Schedulers

@Module
class PostModule {
    @Provides
    fun providePresenter(schedulers : Schedulers, postsApi: PostsApi) = PostPresenter(schedulers, postsApi)
}