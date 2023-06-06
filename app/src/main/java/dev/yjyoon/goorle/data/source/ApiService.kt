package dev.yjyoon.goorle.data.source

import dev.yjyoon.goorle.data.model.CommentResponse
import dev.yjyoon.goorle.data.model.PostResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("accommodations")
    fun getAllPosts(): List<PostResponse>

    @GET("accommodations")
    fun getPost(@Path("accommodationId") id: Int): PostResponse

    @GET("comments/recent")
    fun getRecentComments(): List<CommentResponse>

    
}
