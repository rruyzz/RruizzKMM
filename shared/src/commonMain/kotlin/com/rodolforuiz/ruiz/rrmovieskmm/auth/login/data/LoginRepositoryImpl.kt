package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.data

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.login.LoginResult
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.repository.LoginRepository
import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.data.repository.TokenStorageImpl
import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.domain.repository.TokenStorage


class LoginRepositoryImpl(
    private val repository: TokenStorage
): LoginRepository {

    override fun getLoginStatus(): LoginResult {
        return LoginResult.SignUp
    }
}