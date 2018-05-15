package io.github.feelfree.osteemt.ui.modules.feed

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.feelfree.osteemt.R
import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.github.feelfree.osteemt.base.BaseFragment
import io.github.feelfree.osteemt.ui.adapter.PostsAdapter
import javax.inject.Inject

class FeedFragment : BaseFragment(), FeedFragmentView {
    companion object {
        fun newInstance(): Fragment {
            return FeedFragment()
        }
    }

    @Inject
    lateinit var presenter : FeedFragmentPresenter

    @Inject
    lateinit var postsAdapter : PostsAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.subscribe(this)
        presenter.loadTrendingPosts(true)
        recyclerView?.apply {
            prepare()
            adapter = postsAdapter
        }
        loadingView.isVisible = true
    }

    override fun showPosts(posts: List<Post>, shouldRefresh: Boolean) {
        loadingView.isVisible = false
        postsAdapter.showPosts(posts)
    }

    override fun onPause() {
        super.onPause()
        presenter.unsubscribe()
    }

    override fun onResume() {
        super.onResume()
        presenter.subscribe(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()
    }
}