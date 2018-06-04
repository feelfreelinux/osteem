package io.github.feelfree.osteemt.ui.adapter.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.feelfree.osteemt.api.models.viewmodels.PostComment
import io.github.feelfree.osteemt.utils.loadImage
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.comment_list_item.*

class PostCommentViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bindView(comment: PostComment) {
        authorTextView.text = comment.author
        dateTextView.text = comment.date
        contentTextView.text = comment.body
        comment.avatarUrl.let {
            avatarImageView.loadImage(comment.avatarUrl)
        }
    }
}