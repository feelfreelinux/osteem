package io.github.feelfree.osteemt.ui.modules.feed

import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.github.feelfree.osteemt.base.BaseView

interface FeedFragmentView : BaseView {
    fun showPosts(posts : List<Post>, shouldRefresh : Boolean)
}