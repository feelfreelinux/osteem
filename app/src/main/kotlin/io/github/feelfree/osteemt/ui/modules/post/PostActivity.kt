package io.github.feelfree.osteemt.ui.modules.post

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.github.feelfree.osteemt.R
import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.github.feelfree.osteemt.base.BaseActivity
import io.github.feelfree.osteemt.utils.isVisible
import kotlinx.android.synthetic.main.activity_post.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class PostActivity : BaseActivity(), PostView {
    companion object {
        const val EXTRA_PERMLINK = "EXTRA_PERMLINK"
        const val EXTRA_AUTHOR = "EXTRA_AUTHOR"

        fun createIntent(permlink: String, author: String, context: Context): Intent {
            val intent = Intent(context, PostActivity::class.java)
            intent.putExtra(EXTRA_AUTHOR, author)
            intent.putExtra(EXTRA_PERMLINK, permlink)
            return intent
        }
    }

    val permlink: String by lazy { intent.getStringExtra(EXTRA_PERMLINK) }
    val author: String by lazy { intent.getStringExtra(EXTRA_AUTHOR) }

    @Inject
    lateinit var presenter: PostPresenter

    override fun onSupportNavigateUp(): Boolean {
        super.onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        loadingView.isVisible = true
        presenter.subscribe(this)
        presenter.loadDiscussion(author, permlink)
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

    override fun showPost(post: Post) {
        loadingView.isVisible = false
        markdownView.markdown = post.body
    }
}