package com.rodolforuiz.ruiz.rrmovieskmm.auth.token.domain.repository

interface TokenStorage {
    fun saveToken(token: String)
    fun getToken(): String?
    fun clearToken()
}