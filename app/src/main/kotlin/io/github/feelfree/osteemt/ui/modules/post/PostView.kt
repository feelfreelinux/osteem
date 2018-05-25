package io.github.feelfree.osteemt.ui.modules.post

import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.github.feelfree.osteemt.base.BaseView

interface PostView : BaseView {
    fun showPost(post : Post)
}