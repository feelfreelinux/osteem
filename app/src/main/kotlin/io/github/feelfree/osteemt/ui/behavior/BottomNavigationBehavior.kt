package io.github.feelfree.osteemt.ui.behavior

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import kotlin.math.max
import kotlin.math.min

class BottomNavigationBehavior<V : View>(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<V>(context, attrs) {

    override fun layoutDependsOn(parent: CoordinatorLayout?, child: V, dependency: View?): Boolean {
        when (dependency) {
            is Snackbar.SnackbarLayout -> updateSnackbar(child, dependency)
        }
        return super.layoutDependsOn(parent, child, dependency)
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: V, directTargetChild: View, target: View, axes: Int, type: Int): Boolean =
            axes == ViewCompat.SCROLL_AXIS_VERTICAL

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: V, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
        child.translationY = max(0f, min(child.height.toFloat(), child.translationY + dy))
    }

    private fun updateSnackbar(child: View, snackbarLayout: Snackbar.SnackbarLayout) {
        when {
            snackbarLayout.layoutParams is CoordinatorLayout.LayoutParams -> {
                val params = snackbarLayout.layoutParams as CoordinatorLayout.LayoutParams
                params.anchorId = child.id
                params.anchorGravity = Gravity.TOP
                params.gravity = Gravity.TOP
                snackbarLayout.layoutParams = params
            }
        }
    }
}