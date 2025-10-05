package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.BaseViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.login.LoginResult
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.usecase.GetLoginStatusUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val useCase: GetLoginStatusUseCase
) : BaseViewModel() {
    private val _loginState: MutableStateFlow<LoginState> =
        MutableStateFlow(LoginState(loading = true))
    val loginState: StateFlow<LoginState> get() = _loginState


    init {
        getLoginStatus()
    }

    fun signIn(password: String, confirmPassword: String) {

    }

    private fun getLoginStatus() = scope.launch {
        try {
            _loginState.emit(LoginState(loading = true))
            val loginStatus = useCase.getLoginStatus()
            _loginState.emit(
                LoginState(screen = loginStatus.toAction())
            )
        } catch (e: Exception) {
            _loginState.emit(LoginState(error = e.message))
        }
    }

    private fun LoginResult.toAction(): LoginAction = when (this) {
        is LoginResult.SignIn -> LoginAction.SignIn
        is LoginResult.SignUp -> LoginAction.SignUp
        is LoginResult.Logout -> LoginAction.Logout
    }
}

