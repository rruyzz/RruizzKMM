package com.rodolforuiz.ruiz.rrmovieskmm.auth.token.data.repository

import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.domain.repository.TokenStorage

class TokenStorageImpl : TokenStorage {
    private val TOKEN_KEY = "auth_token"

//    var token: String? = null

    override fun saveToken(token: String) {
//        settings.putString(TOKEN_KEY, token)
//        this.token = token
    }

    override fun getToken(): String? = null
//    override fun getToken(): String? = this.token
//    override fun getToken(): String? = settings.getStringOrNull(TOKEN_KEY)

    override fun clearToken() {
//        this.token = null
//        settings.remove(TOKEN_KEY)
    }
}