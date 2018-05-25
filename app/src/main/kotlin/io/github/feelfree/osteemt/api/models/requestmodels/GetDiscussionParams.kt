package io.github.feelfree.osteemt.api.models.requestmodels

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * GetDiscussionsParams holds parameters for getting list of posts
 * @param author Discussion's author nickname
 * @param permlink permlink of discussion
 */
class GetDiscussionParams(
        @JsonProperty("author")
        val author : String,

        @JsonProperty("permlink")
        val permlink : String
)
