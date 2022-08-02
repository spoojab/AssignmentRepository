package com.example.domain.di

import com.example.domain.usecase.PullRequestUseCase
import com.example.domain.usecase.PullRequestUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
abstract class DomainModule {

    @Binds
    internal abstract fun bindNotificationTabsUsecase(
        pullRequestUseCaseImpl: PullRequestUseCaseImpl,
    ): PullRequestUseCase
}