package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.token

sealed class TokenResult {
    data object Success: TokenResult()
    data object Error: TokenResult()
}