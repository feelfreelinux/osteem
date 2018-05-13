package io.github.feelfree.osteemt.api.repository.users

import io.github.feelfree.osteemt.api.models.dataclass.GithubRepository
import io.reactivex.Single

// This interface is directly exposed to presenters. Can be replaced by mocks for testing
interface UsersApi {
    fun getRepositories(username : String) : Single<List<GithubRepository>>
}