package com.sample.source_code_sdk.rest

import com.sample.source_code_sdk.model.domain.DomainChar
import com.sample.source_code_sdk.model.domain.mapToDomain
import com.sample.source_code_sdk.utils.AppType
import com.sample.source_code_sdk.utils.ResultState
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface CharacterRepository {
    fun getCharacters(type: AppType): Flow<ResultState<List<DomainChar>>>
}

class CharacterRepositoryImpl @Inject constructor(
    private val serviceApi: ServiceApi,
    private val ioDispatcher: CoroutineDispatcher
) : CharacterRepository {

    override fun getCharacters(type: AppType): Flow<ResultState<List<DomainChar>>> = flow {
        emit(ResultState.Loading)

        try {
            val response = serviceApi.getCharacters(type.endPoint)
           response
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(ResultState.Success(it.relatedTopics.mapToDomain()))
                }
            }
        } catch (e: Exception) {
            emit(ResultState.Error(e))
        }
    }.flowOn(ioDispatcher)


}