package io.github.feelfree.osteemt.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.feelfree.osteemt.R


class RecyclerViewItemSeparator(val context: Context) : RecyclerView.ItemDecoration() {
    private val paint by lazy { Paint() }

    private val normalHeight by lazy {
        context.resources.getDimension(R.dimen.separator_normal).toInt()
    }

    init {
        paint.style = Paint.Style.FILL
        paint.color = ContextCompat.getColor(context, R.color.lineColor)

    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) =
            try {
            outRect.set(0, 0, 0, normalHeight)
        } catch (e: Exception) {
        }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) = try {
        super.onDraw(c, parent, state)
        (0 until parent.childCount)
                .map { parent.getChildAt(it) }
                .forEach { c.drawRect(it.left.toFloat(), it.bottom.toFloat(), it.right.toFloat(), (it.bottom + normalHeight).toFloat(), paint) }
    } catch (e: Exception) {
    }

}