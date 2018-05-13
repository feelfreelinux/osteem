package io.github.feelfree.osteemt.ui.repositorieslist

import dagger.Module
import dagger.Provides
import io.github.feelfree.osteemt.api.repository.posts.PostsApi
import io.github.feelfree.osteemt.base.Schedulers

@Module
class GithubRepositoriesModule {
    // You could use constructor injection, but I prefer this way
    @Provides
    fun providePresenter(schedulers: Schedulers, postsApi: PostsApi)  = GithubRepositoriesPresenter(schedulers, postsApi)
}