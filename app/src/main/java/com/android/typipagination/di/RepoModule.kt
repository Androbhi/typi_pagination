package com.android.typipagination.di

import com.android.typipagination.repository.TypiCodeRepository
import com.android.typipagination.repository.TypiCodeRepositoryImpl
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
        imageRepoImpl: TypiCodeRepositoryImpl
    ): TypiCodeRepository

}