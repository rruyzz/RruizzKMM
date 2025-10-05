package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.data

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.login.LoginResult
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.repository.LoginRepository


class LoginRepositoryImpl: LoginRepository {
    override fun getLoginStatus(): LoginResult {
        return LoginResult.SignUp
    }
}