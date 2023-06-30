package com.sample.source_code_sdk.utils

/**
 * This is the class that will drive the type of data needed
 *
 * If we require to support more items, we can simply
 * add the new ENUMS to this class
 */
enum class AppType(val endPoint: String) {
    SIMPSONS("simpsons characters"),
    THE_WIRE("the wire characters")
}