package io.github.feelfree.osteemt.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import io.github.feelfree.osteemt.R
import io.github.feelfree.osteemt.api.models.dataclass.GithubRepository
import io.github.feelfree.osteemt.ui.adapter.viewholders.GithubRepositoryViewHolder
import io.github.feelfree.osteemt.utils.inflate
import javax.inject.Inject

// We're injecting constructor here. All viewholder dependencies can get them from here.
class GithubRepositoriesAdapter @Inject constructor() : androidx.recyclerview.widget.RecyclerView.Adapter<GithubRepositoryViewHolder>() {

    val repositories = arrayListOf<GithubRepository>()

    override fun onBindViewHolder(holder: GithubRepositoryViewHolder, position: Int) {
        holder.apply {
            bindView(repositories[position])
        }
    }

    fun showRepositories(repos : List<GithubRepository>) {
        repositories.apply {
            clear()
            addAll(repos)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepositoryViewHolder =
            GithubRepositoryViewHolder(parent.inflate(R.layout.github_repository_list_item))
    override fun getItemCount(): Int = repositories.size
}