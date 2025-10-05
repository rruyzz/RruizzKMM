package com.rodolforuiz.ruiz.rrmovieskmm.auth.token.data.repository

import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.domain.repository.TokenStorage

class TokenStorageImpl : TokenStorage {
    private val TOKEN_KEY = "auth_token"

    override fun saveToken(token: String) {
//        settings.putString(TOKEN_KEY, token)
    }

    override fun getToken(): String? = ""
//    override fun getToken(): String? = settings.getStringOrNull(TOKEN_KEY)

    override fun clearToken() {
//        settings.remove(TOKEN_KEY)
    }
}