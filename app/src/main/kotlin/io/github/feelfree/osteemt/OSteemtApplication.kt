package io.github.feelfree.osteemt

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.github.feelfree.osteemt.di.DaggerAppComponent

class OSteemtApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    companion object {
        const val BASE_URL = "http://api.grzywok.eu:5000"
    }
}