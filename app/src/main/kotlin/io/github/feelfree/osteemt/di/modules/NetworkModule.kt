package io.github.feelfree.osteemt.di.modules

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.github.feelfree.osteemt.OSteemtApplication
import io.github.feelfree.osteemt.base.ApplicationSchedulers
import io.github.feelfree.osteemt.base.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

// Provides network-related classes
@Module
class NetworkModule {
    @Provides
    fun provideApplicationSchedulers() : Schedulers = ApplicationSchedulers()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi) : Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(OSteemtApplication.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}