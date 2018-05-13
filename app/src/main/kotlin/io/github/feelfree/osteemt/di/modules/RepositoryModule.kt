package io.github.feelfree.osteemt.di.modules

import dagger.Module
import dagger.Provides
import io.github.feelfree.osteemt.api.repository.posts.PostsRepository
import retrofit2.Retrofit

@Module
class RepositoryModule {
    @Provides
    fun providePostRepository(retrofit: Retrofit) : PostsRepository = PostsRepository(retrofit)
}