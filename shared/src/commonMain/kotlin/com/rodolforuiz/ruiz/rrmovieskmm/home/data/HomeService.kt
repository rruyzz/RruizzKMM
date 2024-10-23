package com.rodolforuiz.ruiz.rrmovieskmm.home.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class HomeService(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "f67ace1b27b24ce4b95c7f71fde88920"

    suspend fun getPopularMovies(): PopularMoviesResponse {
        val response: PopularMoviesResponse = httpClient.get("movie/popular").body()
        return response
    }
}