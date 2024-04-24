package com.android.mvvm.data.remote.di

import com.android.mvvm.data.remote.interceptors.HeaderInterceptor
import com.android.mvvm.data.remote.interceptors.HeaderInterceptorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    internal abstract fun bindsHeaderInformationInterceptor(
        headerInformationInterceptorImpl: HeaderInterceptorImpl
    ): HeaderInterceptor
}