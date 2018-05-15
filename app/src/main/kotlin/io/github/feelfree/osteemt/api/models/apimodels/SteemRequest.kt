package io.github.feelfree.osteemt.api.models.apimodels

import com.squareup.moshi.Json

/**
 * Base class for all AppBase api requests
 * @param method String name of method
 * @param paramObject Moshi annotated object that keeps parameters of method
 */
class SteemRequest(
    @Json(name = "method")
    val method : String,

    @Json(name = "params")
    val params : Any
) {
    @Json(name = "jsonrpc")
    val jsonrpc = "2.0"


    @Json(name = "id")
    val id = 1
}