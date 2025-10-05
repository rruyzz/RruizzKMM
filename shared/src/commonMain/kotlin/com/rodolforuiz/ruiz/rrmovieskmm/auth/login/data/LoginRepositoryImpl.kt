package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.data

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.login.LoginResult
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.token.Token
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.repository.LoginRepository
import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.data.repository.TokenStorageImpl
import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.domain.repository.TokenStorage
import kotlinx.coroutines.flow.Flow


class LoginRepositoryImpl(
    private val tokenStorage: TokenStorage,
    private val loginDataSource: LoginDataSource
) : LoginRepository {

    override fun getLoginResult(): LoginResult {
        return LoginResult.SignUp
    }

    override suspend fun signIn(email: String, confirmPassword: String): Flow<Token> {
        return loginDataSource.signIn(email, confirmPassword)
    }

    override suspend fun signUp(email: String, confirmPassword: String):  Flow<Token> {
        return loginDataSource.signUp(email, confirmPassword)
    }
}