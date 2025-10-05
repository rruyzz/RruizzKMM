package com.rodolforuiz.ruiz.rrmovieskmm.login.domain.repository.token

import com.rodolforuiz.ruiz.rrmovieskmm.login.domain.model.token.Token
import com.rodolforuiz.ruiz.rrmovieskmm.login.domain.model.token.TokenResult

interface TokenRepository {
    fun getToken(): Token?
    fun updateToken(token: Token): TokenResult
}