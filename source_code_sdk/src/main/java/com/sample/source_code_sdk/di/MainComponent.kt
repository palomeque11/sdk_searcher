package com.sample.source_code_sdk.di

import com.sample.source_code_sdk.views.SourceActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class,
    RepositoryModule::class]
)
interface MainComponent {
    fun inject(activity: SourceActivity)
}