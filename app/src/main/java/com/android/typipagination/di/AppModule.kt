package com.android.typipagination.di

import com.android.typipagination.BuildConfig
import com.android.typipagination.data.remote.apiservice.ApiService
import com.android.typipagination.data.remote.interceptors.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesApiService(
        headerInformationInterceptor: HeaderInterceptor
    ): ApiService {
        return with(Retrofit.Builder()) {
            client(
                OkHttpClient
                    .Builder().apply {
                        if (BuildConfig.DEBUG) {
                            addInterceptor(
                                HttpLoggingInterceptor().apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                })
                        }
                        addInterceptor(headerInformationInterceptor)
                    }.build()
            )
            addConverterFactory(GsonConverterFactory.create())
            baseUrl(BuildConfig.BASE_URL)
        }.build().create(ApiService::class.java)
    }
}