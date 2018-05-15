package io.github.feelfree.osteemt.base

import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<T : BaseView> {
    var compositeObservable = CompositeDisposable()
    var view: T? = null
    val isSubscribed: Boolean
        get() = view != null

    open fun subscribe(view: T) {
        this.view = view
    }

    open fun unsubscribe() {
        view = null
    }

    open fun dispose() {
        compositeObservable.dispose()
    }
}