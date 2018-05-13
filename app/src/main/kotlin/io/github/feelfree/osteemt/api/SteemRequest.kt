package io.github.feelfree.osteemt.api

import com.squareup.moshi.Json

/**
 * Base class for all AppBase api requests
 * @param method String name of method
 * @param params Moshi annotated object that keeps parameters of method
 */
class SteemRequest(
    @Json(name = "method")
    val method : String,

    @Json(name = "params")
    val params : Any
) {
    @Json(name = "jsonrpc")
    val jsonrpc = "2.0"
}