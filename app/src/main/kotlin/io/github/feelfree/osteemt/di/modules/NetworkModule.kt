package io.github.feelfree.osteemt.di.modules

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import dagger.Module
import dagger.Provides
import io.github.feelfree.osteemt.OSteemtApplication
import io.github.feelfree.osteemt.base.ApplicationSchedulers
import io.github.feelfree.osteemt.base.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
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
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()
    }

    @Provides
    @Singleton
    fun providesObjectPammer(): ObjectMapper {
        val objMapper = ObjectMapper()
        objMapper.propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
        return objMapper
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, objectMapper: ObjectMapper) : Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(OSteemtApplication.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}