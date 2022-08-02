package com.example.data.di

import com.example.data.api.PullRequestApi
import com.example.remote.creator.ApiServiceCreator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideTabsApiServices(
        serviceCreator: ApiServiceCreator,
    ): PullRequestApi {
        return serviceCreator.create(PullRequestApi::class.java)
    }
}