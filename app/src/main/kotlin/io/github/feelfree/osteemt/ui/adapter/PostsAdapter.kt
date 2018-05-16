package io.github.feelfree.osteemt.ui.adapter

import android.view.ViewGroup
import io.github.feelfree.osteemt.R
import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.github.feelfree.osteemt.base.EndlessBaseAdapter
import io.github.feelfree.osteemt.ui.adapter.viewholders.PostViewHolder
import io.github.feelfree.osteemt.utils.inflate
import javax.inject.Inject

class PostsAdapter @Inject constructor() : EndlessBaseAdapter<PostViewHolder, Post>() {
    // Author, Permlink -> Unit
    var loadNewData : (String, String) -> Unit = {_, _ ->}

    companion object {
        const val TYPE_POST = 1
    }

    override fun loadNewData() {
        // Required for pagination
        loadNewData(data.last().author, data.last().permlink)
    }

    override fun getViewType(position: Int) = TYPE_POST

    override fun constructViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(parent.inflate(R.layout.post_list_item))
    }

    override fun bindHolder(holder: PostViewHolder, position: Int) {
        holder.bindView(data[position])
    }
}
