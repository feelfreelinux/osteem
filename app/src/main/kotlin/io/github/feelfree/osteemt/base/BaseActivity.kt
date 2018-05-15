package io.github.feelfree.osteemt.base

import androidx.appcompat.app.AlertDialog
import dagger.android.support.DaggerAppCompatActivity

// This class should be extended in all activities in this app. Place global-activity settings here
// Every activity that extends this class should be defined in ActivityBuilder
abstract class BaseActivity : DaggerAppCompatActivity() {
    public var isRunning = false
    fun showErrorDialog(e: Throwable) {
        AlertDialog.Builder(this)
                .setTitle("Error occured")
                .setMessage(e.message)
                .setPositiveButton(android.R.string.ok, null)
                .create()
                .show()
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