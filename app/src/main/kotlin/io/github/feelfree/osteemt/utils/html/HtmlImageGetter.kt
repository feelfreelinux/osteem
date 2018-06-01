package io.github.feelfree.osteemt.utils.html

import java.util.ArrayList

import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.Target

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.Html.ImageGetter
import android.widget.TextView

import com.bumptech.glide.request.transition.Transition
import io.github.feelfree.osteemt.GlideApp

class HtmlImageGetter(internal var mContext: Context, internal val mTextView: TextView) : ImageGetter {

    private var targets: ArrayList<Target<*>> = ArrayList()

    override fun getDrawable(url: String): Drawable {
        val urlDrawable = UrlDrawable()
        val load = GlideApp.with(mContext).asBitmap().load(url)
        val target = BitmapTarget(urlDrawable)
        targets.add(target)
        load.into(target)
        return urlDrawable
    }

    private inner class BitmapTarget(private val urlDrawable: UrlDrawable) : SimpleTarget<Bitmap>() {

        lateinit var drawable: Drawable

        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
            drawable = BitmapDrawable(mContext.resources, resource)

            mTextView.post {
                val w = mTextView.width
                val hh = drawable.intrinsicHeight
                val ww = drawable.intrinsicWidth
                val newHeight = hh * w / ww
                val rect = Rect(0, 0, w, newHeight)
                drawable.bounds = rect
                urlDrawable.bounds = rect
                urlDrawable.drawable = drawable
                mTextView.text = mTextView.text
                mTextView.invalidate()
            }
        }

    }

    internal inner class UrlDrawable : BitmapDrawable() {
        var drawable: Drawable? = null
        override fun draw(canvas: Canvas) {
            if (drawable != null)
                drawable!!.draw(canvas)
        }
    }

}