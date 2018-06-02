package io.github.feelfree.osteemt.utils.html

import java.util.regex.Pattern

class MarkdownUtils {
    companion object {

        fun correctMarkdown(string : String) : String {
            val images = extractLinksFromContent(string).filter { it.matches("/(https?:\\/\\/.*\\.(?:png|jpg))/i".toRegex()) || it.endsWith(".png") || it.endsWith("jpg") }
            return correctMarkdown(string, images)
        }

        fun correctMarkdown(value: String, images: List<String>?): String {
            var value = value
            if (images != null) {
                for (i in images.indices) {
                    val check = "(" + images[i] + ")"
                    val htmlCheck = "src=\"" + images[i] + "\""
                    val spiliatzerozeroarr = images[i].split("/0x0/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                    var spiliatzerozero: String? = null
                    if (spiliatzerozeroarr.size == 2) {
                        spiliatzerozero = spiliatzerozeroarr[1]
                    }
                    if (spiliatzerozero == null && !value.contains(htmlCheck) && !value.contains(check)) {
                        val spl = images[i].split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                        val reps = "![" + spl[spl.size - 1] + "]" + check
                        value = value.replace(images[i], reps)
                    } else if (spiliatzerozero != null && !value.contains("($spiliatzerozero)")) {
                        val spl = spiliatzerozero.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                        val reps = "![" + spl[spl.size - 1] + "]" + "(" + spiliatzerozero + ")"
                        value = value.replace(spiliatzerozero, reps)
                    }
                }

                return value
            }

            return value
        }

        fun extractLinksFromContent(content: String): List<String> {
            val containedUrls = ArrayList<String>()
            val pattern = Pattern.compile(
                    "\\b((https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])",
                    Pattern.CASE_INSENSITIVE)
            val urlMatcher = pattern.matcher(content)

            while (urlMatcher.find()) {
                containedUrls.add(content.substring(urlMatcher.start(0), urlMatcher.end(0)))
            }

            return containedUrls
        }
    }
}