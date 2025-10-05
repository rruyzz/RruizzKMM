package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.repository

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.login.LoginResult

interface LoginRepository {
    fun getLoginStatus() : LoginResult
}