package com.sample.source_code_sdk.rest

import com.sample.source_code_sdk.utils.JSON_FORMAT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET(".")
    suspend fun getCharacters(
        @Query("q") type: String,
        @Query("format") format: String = JSON_FORMAT
    ): Response<com.sample.source_code_sdk.model.Character>
}