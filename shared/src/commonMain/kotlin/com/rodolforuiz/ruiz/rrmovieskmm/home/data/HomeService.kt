package com.rodolforuiz.ruiz.rrmovieskmm.home.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class HomeService(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "f67ace1b27b24ce4b95c7f71fde88920"

    suspend fun getPopularMovies(): List<PopularMoviesResponse> {
        val response: List<PopularMoviesResponse> = httpClient.get("movies-bff/popular").body()
        return response
    }

    suspend fun getNowMovies(): List<PopularMoviesResponse> {
        val response: List<PopularMoviesResponse> = httpClient.get("movies-bff/now-playing").body()
        return response
    }
    suspend fun getTopRated(): List<PopularMoviesResponse> {
        val response: List<PopularMoviesResponse> = httpClient.get("movies-bff/top-rated").body()
        return response
    }
}