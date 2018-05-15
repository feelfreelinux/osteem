package io.github.feelfree.osteemt.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import io.github.feelfree.osteemt.R
import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.github.feelfree.osteemt.ui.adapter.viewholders.PostViewHolder
import io.github.feelfree.osteemt.utils.inflate
import javax.inject.Inject

// We're injecting constructor here. All viewholder dependencies can get them from here.
class PostsAdapter @Inject constructor() : RecyclerView.Adapter<PostViewHolder>() {
    val posts = arrayListOf<Post>()
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.apply {
            bindView(posts[position])
        }
    }

    fun showPosts(repos : List<Post>) {
        posts.apply {
            clear()
            addAll(repos)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
            PostViewHolder(parent.inflate(R.layout.post_list_item))

    override fun getItemCount(): Int = posts.size
}
