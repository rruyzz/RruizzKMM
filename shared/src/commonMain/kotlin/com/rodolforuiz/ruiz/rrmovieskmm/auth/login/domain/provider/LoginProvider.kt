package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.provider

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.login.LoginResult
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.token.Token
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow


class LoginProvider(
    private val loginRepository: LoginRepository
) {
    fun getLoginResult(): LoginResult {
        return loginRepository.getLoginResult()
    }

    suspend fun signIn(email: String, confirmPassword: String): Flow<Token> {
        return loginRepository.signIn(email, confirmPassword)

    }

    suspend fun signUp(email: String, confirmPassword: String): Flow<Token> {
        return loginRepository.signUp(email, confirmPassword)
    }
}