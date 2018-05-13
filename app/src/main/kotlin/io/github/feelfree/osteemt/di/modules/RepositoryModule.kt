package io.github.feelfree.osteemt.di.modules

import dagger.Module
import dagger.Provides
import io.github.feelfree.osteemt.api.repository.users.UsersApi
import io.github.feelfree.osteemt.api.repository.users.UsersRepository
import retrofit2.Retrofit

@Module
class RepositoryModule {
    // Remember to provide repository with interface
    @Provides
    fun provide(retrofit: Retrofit) : UsersApi = UsersRepository(retrofit)
}