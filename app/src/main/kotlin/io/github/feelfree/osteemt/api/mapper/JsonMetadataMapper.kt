package io.github.feelfree.osteemt.api.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.feelfree.osteemt.api.models.apimodels.JsonMetadata

val JsonMetadataMapper : Mapper<String, JsonMetadata?> = {
    var str = it
    if (!it.startsWith("{")) {
        str = "{$it"
    }
    try {
        ObjectMapper().readValue(str.replace("\\", ""), JsonMetadata::class.java)

    } catch (e : Exception) {
        null
    }
}