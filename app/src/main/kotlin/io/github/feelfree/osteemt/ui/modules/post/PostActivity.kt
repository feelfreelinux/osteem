package io.github.feelfree.osteemt.ui.modules.post

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.vladsch.flexmark.Extension
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.util.options.MutableDataSet
import io.github.feelfree.osteemt.R
import io.github.feelfree.osteemt.api.models.viewmodels.Post
import io.github.feelfree.osteemt.base.BaseActivity
import io.github.feelfree.osteemt.utils.isVisible
import io.github.feelfree.osteemt.utils.renderHtml
import kotlinx.android.synthetic.main.activity_post.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject
import com.vladsch.flexmark.ext.autolink.AutolinkExtension
import java.util.Arrays.asList



class PostActivity : BaseActivity(), PostView {
    companion object {
        const val EXTRA_PERMLINK = "EXTRA_PERMLINK"
        const val EXTRA_AUTHOR = "EXTRA_AUTHOR"
        const val EXTRA_TITLE = "EXTRA_TITLE"

        fun createIntent(permlink: String, author: String, title: String, context: Context): Intent {
            val intent = Intent(context, PostActivity::class.java)
            intent.putExtra(EXTRA_AUTHOR, author)
            intent.putExtra(EXTRA_PERMLINK, permlink)
            intent.putExtra(EXTRA_TITLE, title)
            return intent
        }
    }

    val permlink: String by lazy { intent.getStringExtra(EXTRA_PERMLINK) }
    val author: String by lazy { intent.getStringExtra(EXTRA_AUTHOR) }
    val title: String by lazy { intent.getStringExtra(EXTRA_TITLE) }

    @Inject
    lateinit var presenter: PostPresenter

    override fun onSupportNavigateUp(): Boolean {
        super.onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        toolbar?.title = title
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
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
        val options = MutableDataSet()
        options.set(Parser.PARSE_MULTI_LINE_IMAGE_URLS, true)
        options.set(Parser.SPACE_IN_LINK_ELEMENTS, true)
        options.set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, true)
        val parser = Parser.builder(options)
                .extensions(listOf(AutolinkExtension.create())).build()
        val renderer = HtmlRenderer.builder(options).build()
        val document = parser.parse(post.body)
        val html = renderer.render(document)
        contentTextView.renderHtml(html)
    }
}