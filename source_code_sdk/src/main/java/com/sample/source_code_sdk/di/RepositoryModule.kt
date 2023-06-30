package com.sample.source_code_sdk.di

import com.sample.source_code_sdk.rest.CharacterRepository
import com.sample.source_code_sdk.rest.CharacterRepositoryImpl
import com.sample.source_code_sdk.rest.ServiceApi
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
//@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(service: ServiceApi,dispatcher:CoroutineDispatcher): CharacterRepository {
        return CharacterRepositoryImpl(service,dispatcher)
    }
}