package io.github.feelfree.osteemt.utils

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.github.feelfree.osteemt.GlideApp
import org.ocpsoft.prettytime.PrettyTime
import java.text.SimpleDateFormat
import java.util.*

const val REGEX_BIEDAMARKDOWN = "<[^>]*>|\\*|\\_|`/g"
const val REGEX_LINKMARKDOWN = "(?:!\\[(.*?)\\]\\((.*?)\\))|(\\[(.*?)\\]\\((.*?)\\))/g"



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

fun TextView.renderHtml(body : String) {
    text = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
        Html.fromHtml(body, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(body)
    }
}

fun String.removeMarkdown(): String {
    val step1 = REGEX_LINKMARKDOWN.toRegex().replace(this.replace("\n", "").replace("\r", ""), "")
    return REGEX_BIEDAMARKDOWN.toRegex().replace(step1, "")
}

fun ViewGroup.inflate(layoutId: Int): View =
        LayoutInflater.from(context).inflate(layoutId, this, false)

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

fun String.toPrettyDate(): String {
    return PrettyTime(Locale("pl")).format(parseDate(this))
}

fun parseDate(date: String): Date {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.GERMANY)
    format.timeZone = TimeZone.getTimeZone("Europe/Warsaw")
    return format.parse(date)
}

fun ImageView.loadImage(url: String) {
    GlideApp.with(context)
            .load(url)
            .into(this)
}
