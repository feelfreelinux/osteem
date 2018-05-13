package io.github.feelfree.osteemt.api.models.requestmodels

import com.squareup.moshi.Json

/**
 * GetDiscussionsParams holds parameters for getting list of posts
 * @param tag If empty downloads mainpage
 * @param truncateBody index at which truncate body. 0 by default (won't truncate)
 */
class GetDiscussionsParams(
        @Json(name = "tag")
        val tag : String,

        @Json(name = "trucate_body")
        val truncateBody : Int = 0
) {
    @Json(name = "limit")
    val limit = 20
}