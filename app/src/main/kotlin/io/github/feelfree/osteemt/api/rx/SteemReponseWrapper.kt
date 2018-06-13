package io.github.feelfree.osteemt.api.rx

import io.github.feelfree.osteemt.api.models.apimodels.SteemResponse
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer

class SteemReponseWrapper<T : Any> : SingleTransformer<SteemResponse<T>, T> {
    override fun apply(upstream: Single<SteemResponse<T>>): SingleSource<T> = upstream.flatMap {
        when {
            it.error != null -> Single.error(it.error)
            else -> Single.just(it.data!!)
        }
    }
}