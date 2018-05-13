package io.github.feelfree.osteemt.ui.repositorieslist

import io.github.feelfree.osteemt.api.repository.posts.PostsApi
import io.github.feelfree.osteemt.base.BasePresenter
import io.github.feelfree.osteemt.base.Schedulers

class GithubRepositoriesPresenter(val schedulers: Schedulers, val postsApi: PostsApi) : BasePresenter<GithubRepositoriesView>() {
    var username = "feelfreelinux" // can be provided by view, but its just a simple example.
    fun loadRepository() {

    }
}