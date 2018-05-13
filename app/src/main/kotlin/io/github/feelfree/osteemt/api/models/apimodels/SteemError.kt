package io.github.feelfree.osteemt.api.models.apimodels

import com.squareup.moshi.Json
import java.io.IOException

/**
 * SteemError holds error data returned from api
 * @param code Int error code
 * @param message String error message
 */
class SteemError(
        @Json(name = "code")
        val code : Int,

        @Json(name = "message")
        override val message : String
) : IOException()