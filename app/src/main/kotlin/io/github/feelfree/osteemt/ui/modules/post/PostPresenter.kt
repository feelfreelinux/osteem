package io.github.feelfree.osteemt.ui.modules.post

import io.github.feelfree.osteemt.api.repository.posts.PostsApi
import io.github.feelfree.osteemt.base.BasePresenter
import io.github.feelfree.osteemt.base.Schedulers

class PostPresenter(val schedulers: Schedulers, postsApi: PostsApi) : BasePresenter<PostView>() {

}