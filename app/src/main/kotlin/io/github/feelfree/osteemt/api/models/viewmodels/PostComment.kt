package io.github.feelfree.osteemt.api.models.viewmodels


class PostComment(
        val author: String,
        val date: String,
        val body: String
) {
    val avatarUrl = "https://steemitimages.com/u/$author/avatar"

}