package com.rodolforuiz.ruiz.rrmovieskmm.login.data

import com.rodolforuiz.ruiz.rrmovieskmm.login.domain.model.login.LoginResult
import com.rodolforuiz.ruiz.rrmovieskmm.login.domain.repository.login.LoginRepository

class LoginRepositoryImpl: LoginRepository {
    override fun getLoginStatus(): LoginResult {
        return LoginResult.SignUp
    }
}