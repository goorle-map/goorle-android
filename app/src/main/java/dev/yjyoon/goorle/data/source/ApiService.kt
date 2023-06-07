package dev.yjyoon.goorle.data.source

import dev.yjyoon.goorle.data.model.CommentResponse
import dev.yjyoon.goorle.data.model.PackageResponse
import dev.yjyoon.goorle.data.model.PostResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("accommodations")
    suspend fun getAllPosts(): List<PostResponse>

    @GET("accommodations")
    suspend fun getPost(@Path("accommodationId") id: Int): PostResponse

    @GET("comments/recent")
    suspend fun getRecentComments(): List<CommentResponse>

    @GET("packages")
    suspend fun getAllPackages(): List<PackageResponse>
}
