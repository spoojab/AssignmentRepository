package com.example.naviproject.di

import com.example.data.di.ApiModule
import com.example.data.di.DataModule
import com.example.domain.di.DomainModule
import com.example.remote.di.RemoteModule
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module(
    includes = [
        ApiModule::class,
        RemoteModule::class
    ]
)
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    companion object {
        @Provides
        @Singleton
        fun provideMoshi(): Moshi = Moshi.Builder().build()
    }
}

@Module(
    includes = [
        DataModule::class,
        DomainModule::class
    ]
)
@InstallIn(ViewModelComponent::class)
object ViewModelDataDependencies


