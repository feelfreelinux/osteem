package io.github.feelfree.osteemt.utils

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import io.github.feelfree.osteemt.GlideApp
import org.ocpsoft.prettytime.PrettyTime
import java.text.SimpleDateFormat
import java.util.*

// Remember to do not overuse extensions,
// data-related operations should use separate utils class
// But for android views its really handy.
fun RecyclerView.prepare() {
    layoutManager = LinearLayoutManager(context)
    drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH
    isDrawingCacheEnabled = true
    setHasFixedSize(true)
    addItemDecoration(RecyclerViewItemSeparator(context))
}

fun ViewGroup.inflate(layoutId: Int): View =
    LayoutInflater.from(context).inflate(layoutId, this, false)

var View.isVisible : Boolean
    get() = visibility == View.VISIBLE
    set(value) { visibility = if (value) View.VISIBLE else View.GONE }

fun String.toPrettyDate(): String {
    return PrettyTime(Locale("pl")).format(parseDate(this))
}

fun parseDate(date: String): Date {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.GERMANY)
    format.timeZone = TimeZone.getTimeZone("Europe/Warsaw")
    return format.parse(date)
}

fun ImageView.loadImage(url : String) {
    GlideApp.with(context)
            .load(url)
            .into(this)
}

fun String.removeFormatting() : String {
    return replace("/<[^>]*>/g", "")
    // Remove setext-style headers
    .replace("^[=\\-]{2,}\\s*$/g", "")
    // Remove footnotes?
    .replace("/\\[\\^.+?\\](\\: .*?$)?/g", "")
    .replace("/\\s{0,2}\\[.*?\\]: .*?$/g", "")
    // Remove images
    .replace(Regex("[(.*?)][[(].*?[])]]/g"), "")
    // Remove inline links
    .replace("/\\[(.*?)\\][\\[\\(].*?[\\]\\)]/g", "$1")
    // Remove blockquotes
    .replace("/^\\s{0,3}>\\s?/g", "")
    // Remove reference-style links?
    .replace("/^\\s{1,2}\\[(.*?)\\]: (\\S+)( \".*?\")?\\s*$/g", "")
    // Remove atx-style headers
    .replace("/^(\n)?\\s{0,}#{1,6}\\s+| {0,}(\n)?\\s{0,}#{0,} {0,}(\n)?\\s{0,}$/gm", "$1$2$3")
    // Remove emphasis (repeat the line to remove double emphasis)
    .replace("/([\\*_]{1,3})(\\S.*?\\S{0,1})\\1/g", "$2")
    .replace("/([\\*_]{1,3})(\\S.*?\\S{0,1})\\1/g", "$2")
    // Remove code blocks
    .replace("/(`{3,})(.*?)\\1/gm", "$2")
    // Remove inline code
    .replace("/`(.+?)`/g", "$1")
    // Replace two or more newlines with exactly two? Not entirely sure this belongs here...
    .replace("/\n{2,}/g", "\n\n")
}