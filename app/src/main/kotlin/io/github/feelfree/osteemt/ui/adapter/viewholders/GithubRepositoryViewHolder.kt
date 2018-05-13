package io.github.feelfree.osteemt.ui.adapter.viewholders

import android.view.View
import io.github.feelfree.osteemt.api.models.viewmodels.Post

// Use layoutContainer to cache views. It improves scroll performance
class GithubRepositoryViewHolder(val containerView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(containerView) {
    fun bindView(post : Post) {
    }
}