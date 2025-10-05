package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.repository

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.login.LoginResult
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.token.Token
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun getLoginResult(): LoginResult
    suspend fun signIn(email: String, confirmPassword: String): Flow<Token>
    suspend fun signUp(email: String, confirmPassword: String): Flow<Token>
}