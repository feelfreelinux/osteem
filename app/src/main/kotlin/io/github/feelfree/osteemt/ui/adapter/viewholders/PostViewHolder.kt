package io.github.feelfree.osteemt.ui.adapter.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.github.feelfree.osteemt.ui.modules.post.PostActivity
import io.github.feelfree.osteemt.utils.isVisible
import io.github.feelfree.osteemt.utils.loadImage
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.post_list_item.*

class PostViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bindView(post : Post) {
        // @TODO write some real code here
        titleTextView.text = post.title
        authorTextView.text = post.author
        bodyTextView.text = post.description
        votesTextView.text = " • ${post.votes} votes • ${post.children} comments"
        payoutTextView.text = post.pendingPayoutValue
        tagDataTextView.text = "in ${post.category} • ${post.createdAt}"
        previewImageView.isVisible = post.thumbnail != null
        post.thumbnail?.let {
            previewImageView.loadImage(post.thumbnail!!)
        }

        containerView.setOnClickListener {
            containerView.context.startActivity(PostActivity.createIntent(post.permlink, post.author, post.title, containerView.context))
        }
    }
}