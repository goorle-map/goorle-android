package dev.yjyoon.goorle.data.repository

import dev.yjyoon.goorle.data.model.toModel
import dev.yjyoon.goorle.data.source.ApiService
import dev.yjyoon.goorle.ui.model.Comment
import dev.yjyoon.goorle.ui.model.Post
import dev.yjyoon.goorle.ui.model.Trip
import javax.inject.Inject

class ServiceRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getAllPosts(): Result<List<Post>> = runCatching {
        apiService.getAllPosts().map { it.toModel() }
    }

    suspend fun getPost(id: Int): Result<Post> = runCatching {
        apiService.getPost(id).toModel()
    }

    suspend fun getRecentComments(): Result<List<Comment>> = runCatching {
        apiService.getRecentComments().map { it.toModel() }
    }

    suspend fun getAllPackages(): Result<List<Trip>> = runCatching {
        apiService.getAllPackages().map { it.toModel() }
    }
}
