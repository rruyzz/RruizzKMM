package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.data

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.login.LoginResult
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.repository.LoginRepository
import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.data.repository.TokenStorageImpl
import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.domain.repository.TokenStorage


class LoginRepositoryImpl(
    private val tokenStorage: TokenStorage
): LoginRepository {

    override fun getLoginResult(): LoginResult {
        return LoginResult.SignUp
    }
}