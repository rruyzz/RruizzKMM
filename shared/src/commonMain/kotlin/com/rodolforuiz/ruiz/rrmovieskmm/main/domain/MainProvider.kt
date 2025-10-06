package com.rodolforuiz.ruiz.rrmovieskmm.main.domain

import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.domain.repository.TokenStorage

class MainProvider(
    private val tokenStorage: TokenStorage
) {

    fun isLogged() : Boolean {
        return tokenStorage.getToken() != null
    }

}