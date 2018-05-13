package io.github.feelfree.osteemt.ui.adapter.viewholders

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import io.github.feelfree.osteemt.api.models.dataclass.GithubRepository
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.github_repository_list_item.*

// Use layoutContainer to cache views. It improves scroll performance
class GithubRepositoryViewHolder(override val containerView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bindView(repository : GithubRepository) {
        repositoryDescriptionTextView.text = repository.description
        repositoryTitleTextView.text = repository.name
    }
}