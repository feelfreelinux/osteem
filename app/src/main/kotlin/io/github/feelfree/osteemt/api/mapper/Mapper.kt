package io.github.feelfree.osteemt.api.mapper

interface Mapper<in T, out Y> {
    fun map(value : T) : Y
}