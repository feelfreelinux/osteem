package io.github.feelfree.osteemt.api.models.apimodels

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Base class for all AppBase api requests
 * @param method String name of method
 * @param paramObject Moshi annotated object that keeps parameters of method
 */
class SteemRequest(
        @JsonProperty("method")
    val method : String,
        val paramObject: Any
) {
    @JsonProperty("jsonrpc")
    val jsonrpc = "2.0"

    @JsonProperty("params")
    val params = listOf(paramObject)

    @JsonProperty("id")
    val id = 1
}