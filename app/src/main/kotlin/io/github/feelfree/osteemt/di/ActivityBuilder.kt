package io.github.feelfree.osteemt.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.feelfree.osteemt.ui.repositorieslist.TrendingPostsActivity
import io.github.feelfree.osteemt.ui.repositorieslist.GithubRepositoriesModule

// Every activity that extends BaseActivity should be bind there
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [GithubRepositoriesModule::class])
    abstract fun bindGithubRepositoriesActivity() : TrendingPostsActivity
}
