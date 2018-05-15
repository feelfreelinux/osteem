package io.github.feelfree.osteemt.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.github.feelfree.osteemt.api.models.viewmodels.Post
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.post_list_item.*

class PostViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bindView(post : Post) {
        // @TODO write some real code here
        titleTextView.text = post.title
        authorTextView.text = post.author
        body.text = post.body
        votes.text = " • ${post.netVotes} votes • ${post.children} comments"
        payout.text = post.pendingPayoutValue
        tagDataTextView.text = "in ${post.category} • ${post.createdAt}"
    }
}