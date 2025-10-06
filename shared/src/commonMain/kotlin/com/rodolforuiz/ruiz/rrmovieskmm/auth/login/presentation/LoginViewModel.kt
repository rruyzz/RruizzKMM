package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.BaseViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.login.LoginResult
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.provider.LoginProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class LoginViewModel(
    private val useCase: LoginProvider
) : BaseViewModel() {
    private val _loginState: MutableStateFlow<LoginState> =
        MutableStateFlow(LoginState(loading = true))
    val loginState: StateFlow<LoginState> get() = _loginState


    init {
//        getLoginStatus()
    }

    fun signIn(email: String, confirmPassword: String, onSuccess: (Unit) -> (Unit)) = scope.launch {
        useCase.signIn(email, confirmPassword)
            .onStart {
                _loginState.emit(LoginState(loading = true))
            }
            .catch { e ->
                _loginState.emit(LoginState(error = e.message))
            }
            .collect {
                onSuccess(Unit)
            }
    }

    fun signUp(email: String, confirmPassword: String) = scope.launch {
        useCase.signUp(email, confirmPassword)
            .onStart {
                _loginState.emit(LoginState(loading = true))
            }
            .catch { e ->
                _loginState.emit(LoginState(error = e.message, loading = false))
            }
            .collect { token ->
                _loginState.emit( LoginState(screen = LoginAction.SignIn))
            }
    }


    fun getLoginStatus() = scope.launch {
        try {
            _loginState.emit(LoginState(loading = true))
            val loginStatus = useCase.getLoginResult()
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
        is LoginResult.Home -> LoginAction.Home
    }
}

