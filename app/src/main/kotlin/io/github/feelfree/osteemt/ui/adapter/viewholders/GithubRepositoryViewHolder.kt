package io.github.feelfree.osteemt.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.github.feelfree.osteemt.api.models.viewmodels.Post

// Use layoutContainer to cache views. It improves scroll performance
class GithubRepositoryViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView) {
    fun bindView(post : Post) {
    }
}