package io.github.feelfree.osteemt.api

import com.squareup.moshi.Json

/**
 * SteemResponse is class which holds successful or failed response
 */
data class SteemResponse<out V : Any>(
        @Json(name = "jsonrpc")
        val jsonrpc : String,

        @Json(name = "result")
        val result : V?,

        @Json(name = "error")
        val error : SteemError?
)