package io.github.feelfree.osteemt.ui.repositorieslist

import android.os.Bundle
import io.github.feelfree.osteemt.R
import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.github.feelfree.osteemt.base.BaseActivity
import io.github.feelfree.osteemt.ui.adapter.GithubRepositoriesAdapter
import io.github.feelfree.osteemt.utils.isVisible
import io.github.feelfree.osteemt.utils.prepare
import kotlinx.android.synthetic.main.activity_github_repositories.*
import javax.inject.Inject

class GithubRepositoriesActivity : BaseActivity(), GithubRepositoriesView {
    @Inject lateinit var presenter : GithubRepositoriesPresenter
    @Inject lateinit var githubAdapter : GithubRepositoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_repositories)
        loadingView.isVisible = true

        recyclerView.apply {
            prepare()
            adapter = githubAdapter
        }

        swiperefresh.setOnRefreshListener {
            presenter.loadRepository()
        }

        presenter.subscribe(this)
        presenter.loadRepository()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    override fun showRepositories(repositories: List<Post>) {
        githubAdapter.showRepositories(repositories)
        loadingView.isVisible = false
        swiperefresh.isRefreshing = false
    }
}
