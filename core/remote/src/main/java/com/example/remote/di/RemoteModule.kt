package com.example.remote.di

import com.example.remote.creator.ApiServiceCreator
import com.example.remote.creator.RetrofitServiceCreator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    @Singleton
    internal abstract fun bindServiceCreator(retrofitServiceCreator: RetrofitServiceCreator): ApiServiceCreator
}