package io.github.feelfree.osteemt.api.models.requestmodels

import com.fasterxml.jackson.annotation.JsonProperty
/**
 * GetDiscussionsParams holds parameters for getting list of posts
 * @param tag If empty downloads mainpage
 * @param truncateBody index at which truncate body. 0 by default (won't truncate)
 */
class GetDiscussionsParams(
        @JsonProperty("tag")
        val tag : String,

        @JsonProperty("trucate_body")
        val truncateBody : Int = 0
) {
    @JsonProperty("limit")
    val limit = 20
}