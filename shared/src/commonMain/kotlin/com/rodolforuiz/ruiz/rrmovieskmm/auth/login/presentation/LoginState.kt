package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.model.HomeSuccessContent

data class LoginState(
    val screen: LoginAction? = null,
    val loading: Boolean = false,
    val error: String? = null,
)

sealed class LoginAction() {
    data object SignUp : LoginAction()
    data object SignIn : LoginAction()
    data object Logout : LoginAction()
}
