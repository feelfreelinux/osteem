package io.github.feelfree.osteemt.api.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.feelfree.osteemt.api.models.apimodels.JsonMetadata

val JsonMetadataMapper : Mapper<String, JsonMetadata> = {
    ObjectMapper().readValue(it, JsonMetadata::class.java)
}