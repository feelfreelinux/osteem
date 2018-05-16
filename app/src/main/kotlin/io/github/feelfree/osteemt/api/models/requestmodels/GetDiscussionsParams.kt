package io.github.feelfree.osteemt.api.models.requestmodels

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * GetDiscussionsParams holds parameters for getting list of posts
 * @param tag If empty downloads mainpage
 * @param truncateBody index at which truncate body. 0 by default (won't truncate)
 */
class GetDiscussionsParams(
        @JsonProperty("tag")
        val tag : String,

        @JsonProperty("truncate_body")
        val truncateBody : Int = 0,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("start_author")
        val startAuthor : String? = null,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("start_permlink")
        val startPermlink : String? = null
) {
    @JsonProperty("limit")
    val limit = 20
}
