package com.android.mvvm.di

import com.android.mvvm.repository.MainRepository
import com.android.mvvm.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    @ViewModelScoped
    internal abstract fun bindsImageListRepo(
        imageRepoImpl: MainRepositoryImpl
    ): MainRepository

}