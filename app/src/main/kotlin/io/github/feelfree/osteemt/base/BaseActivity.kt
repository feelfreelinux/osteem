package io.github.feelfree.osteemt.base

import android.support.v7.app.AlertDialog
import dagger.android.support.DaggerAppCompatActivity

// This class should be extended in all activities in this app. Place global-activity settings here
// Every activity that extends this class should be defined in ActivityBuilder
abstract class BaseActivity : DaggerAppCompatActivity() {
    var isRunning = false
    open fun showError(e: Throwable) {
        AlertDialog.Builder(this)
                .setTitle("Error occured")
                .setMessage(e.message)
                .setPositiveButton(android.R.string.ok, null)
                .create()
                .show()
        throw e
    }


    override fun onResume() {
        isRunning = true
        super.onResume()
    }

    override fun onPause() {
        isRunning = false
        super.onPause()
    }


}