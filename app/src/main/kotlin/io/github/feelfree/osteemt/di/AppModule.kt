package io.github.feelfree.osteemt.di

import android.content.Context
import dagger.Binds
import dagger.Module
import io.github.feelfree.osteemt.OSteemtApplication

@Module
abstract class AppModule {
    // Binds acts like provide, but it just binds the class instance with its interface
    @Binds
    abstract fun provideContext(application: OSteemtApplication) : Context
}