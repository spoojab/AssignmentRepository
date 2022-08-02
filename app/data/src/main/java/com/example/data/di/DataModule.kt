package com.example.data.di

import com.example.data.repositoryimpl.PullRequestRepositoryImpl
import com.example.domain.repository.PullRequestRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
abstract class DataModule {

    @Binds
    internal abstract fun bindWebRepository(
        pullRequestRepo: PullRequestRepositoryImpl,
    ): PullRequestRepository
}