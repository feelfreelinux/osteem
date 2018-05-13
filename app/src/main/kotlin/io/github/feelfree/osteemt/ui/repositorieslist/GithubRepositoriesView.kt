package io.github.feelfree.osteemt.ui.repositorieslist

import io.github.feelfree.osteemt.api.models.dataclass.GithubRepository
import io.github.feelfree.osteemt.base.BaseView

interface GithubRepositoriesView : BaseView {
    fun showRepositories(repositories : List<GithubRepository>)
}