package io.github.feelfree.osteemt.ui.modules.mainnavigation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import io.github.feelfree.osteemt.R

import io.github.feelfree.osteemt.base.BaseActivity
import io.github.feelfree.osteemt.ui.modules.feed.FeedFragment
import kotlinx.android.synthetic.main.toolbar.*

class MainNavigationActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar?.title = "Feed"
        toolbar?.setSubtitle("Trending")
        setSupportActionBar(toolbar)
        openFragment(FeedFragment.newInstance())
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_feed -> {
                openFragment(FeedFragment.newInstance())
            }
        }
        return true
    }

    fun openFragment(fragment: Fragment) {
        supportActionBar?.subtitle = null
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.containerView, fragment)
        ft.commit()
    }
}