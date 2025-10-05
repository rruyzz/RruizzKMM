package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.login

sealed class LoginResult {
    data object SignIn : LoginResult()
    data object SignUp : LoginResult()
    data object Logout : LoginResult()
}