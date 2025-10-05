package com.rodolforuiz.ruiz.rrmovieskmm.login.domain.repository.login

import com.rodolforuiz.ruiz.rrmovieskmm.login.domain.model.login.LoginResult

interface LoginRepository {
    fun getLoginStatus() : LoginResult
}