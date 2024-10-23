package com.rodolforuiz.ruiz.rrmovieskmm.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {

    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            defaultRequest {
                url {
                    url("https://api.themoviedb.org/3/")
                    parameters.append("api_key", "e591023d8d396231d3045ea6341a6fd2")
                    parameters.append("language", "pt-BR")
                }
            }
        }
    }
}