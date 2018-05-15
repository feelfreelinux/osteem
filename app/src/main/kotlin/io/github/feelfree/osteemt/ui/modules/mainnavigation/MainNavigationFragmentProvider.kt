package io.github.feelfree.osteemt.ui.modules.mainnavigation

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.feelfree.osteemt.ui.modules.feed.FeedFragment
import io.github.feelfree.osteemt.ui.modules.feed.FeedFragmentModule

@Module
abstract class MainNavigationFragmentProvider {
    @ContributesAndroidInjector(modules = [FeedFragmentModule::class])
    abstract fun bindFeedFragment() : FeedFragment
}