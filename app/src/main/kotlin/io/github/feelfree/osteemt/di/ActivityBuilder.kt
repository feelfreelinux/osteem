package io.github.feelfree.osteemt.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.feelfree.osteemt.ui.modules.mainnavigation.MainNavigationActivity
import io.github.feelfree.osteemt.ui.modules.mainnavigation.MainNavigationFragmentProvider
import io.github.feelfree.osteemt.ui.modules.mainnavigation.MainNavigationModule
import io.github.feelfree.osteemt.ui.modules.post.PostActivity
import io.github.feelfree.osteemt.ui.modules.post.PostModule

// Every activity that extends BaseActivity should be bind there
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainNavigationModule::class, MainNavigationFragmentProvider::class])
    abstract fun bindMainActivity() : MainNavigationActivity

    @ContributesAndroidInjector(modules = [PostModule::class])
    abstract fun bindPostActivity() : PostActivity
}
