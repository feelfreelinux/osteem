package io.github.feelfree.osteemt.api.models.apimodels

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Base class for all AppBase api requests
 * @param method String name of method
 * @param paramObject Moshi annotated object that keeps parameters of method
 */
class SteemRequest(
    @JsonProperty(name = "method")
    val method : String,

    @JsonProperty("params")
    val params : Any
) {
    @JsonProperty(name = "jsonrpc")
    val jsonrpc = "2.0"


    @JsonProperty("id")
    val id = 1
}
