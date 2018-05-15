package io.github.feelfree.osteemt.api.models.apimodels

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.IOException

/**
 * SteemError holds error data returned from api
 * @param code Int error code
 * @param message String error message
 */
class SteemError(
        @JsonProperty("code")
        val code : Int,

        @JsonProperty("message")
        override val message : String
) : IOException()