package io.github.feelfree.osteemt.base
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {
    fun showErrorDialog(e : Throwable) {
        val baseActivity = activity as? BaseActivity
        if (activity != null && activity is BaseActivity && baseActivity!!.isRunning) {
            (activity as BaseActivity).showErrorDialog(e)
        }
    }
}