package io.github.feelfree.osteemt.ui.repositorieslist

import io.github.feelfree.osteemt.api.repository.users.UsersApi
import io.github.feelfree.osteemt.base.BasePresenter
import io.github.feelfree.osteemt.base.Schedulers

class GithubRepositoriesPresenter(val schedulers: Schedulers, val usersApi: UsersApi) : BasePresenter<GithubRepositoriesView>() {
    var username = "feelfreelinux" // can be provided by view, but its just a simple example.
    fun loadRepository() {
        compositeObservable.add(
                usersApi.getRepositories(username)
                        .subscribeOn(schedulers.backgroundThread())
                        .observeOn(schedulers.mainThread())
                        .subscribe({ view?.showRepositories(it) }, { view?.showErrorDialog(it) })
        )
    }
}