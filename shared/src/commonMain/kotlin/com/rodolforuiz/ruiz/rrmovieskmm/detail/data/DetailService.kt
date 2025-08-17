package com.rodolforuiz.ruiz.rrmovieskmm.detail.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class DetailService(private val httpClient: HttpClient) {
    suspend fun getDetails(movieId: String): DetailMovieResponse {
        val response: DetailMovieResponse = httpClient.get("movie/$movieId").body()
        return response
    }
}