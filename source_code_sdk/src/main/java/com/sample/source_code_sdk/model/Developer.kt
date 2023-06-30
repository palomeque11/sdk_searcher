package com.sample.source_code_sdk.model


import com.google.gson.annotations.SerializedName

data class Developer(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null
)