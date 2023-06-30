package com.sample.source_code_sdk.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.source_code_sdk.usecase.CharactersUseCase
import com.sample.source_code_sdk.views.viemwodel.MainBaseViewModel
import dagger.Module
import javax.inject.Inject

@Module
class GenericViewModelFactory @Inject constructor(
    private val charactersUseCase: CharactersUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainBaseViewModel(charactersUseCase) as T
    }
}