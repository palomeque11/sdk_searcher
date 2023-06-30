package com.sample.source_code_sdk.di

class DaggerWrapper {
    companion object{
        private var mComponent: MainComponent? = null

        fun getComponent(): MainComponent? {
            if (mComponent == null) {
                initComponent()
            }
            return mComponent
        }

        private fun initComponent() {
            mComponent = DaggerMainComponent
                .builder()
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .build()
        }
    }
}