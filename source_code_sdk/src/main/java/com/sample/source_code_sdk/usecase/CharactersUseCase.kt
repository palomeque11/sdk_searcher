package com.sample.source_code_sdk.usecase

import com.sample.source_code_sdk.model.domain.DomainChar
import com.sample.source_code_sdk.rest.CharacterRepository
import com.sample.source_code_sdk.utils.AppType
import com.sample.source_code_sdk.utils.ResultState
import dagger.Binds
import dagger.Module
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    operator fun invoke(appType: AppType): Flow<ResultState<List<DomainChar>>> =
        repository.getCharacters(appType)
}