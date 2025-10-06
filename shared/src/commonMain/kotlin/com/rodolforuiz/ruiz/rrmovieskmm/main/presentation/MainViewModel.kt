package com.rodolforuiz.ruiz.rrmovieskmm.main.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.BaseViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.provider.LoginProvider
import com.rodolforuiz.ruiz.rrmovieskmm.main.domain.MainProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val provider: MainProvider
) : BaseViewModel() {

    private val _isLogin: MutableStateFlow<Boolean?> =
        MutableStateFlow(null)

    val success: StateFlow<Boolean?> get() = _isLogin

    init {
        scope.launch {
            delay(3000)
            _isLogin.emit(provider.isLogged())
        }
    }
    suspend fun getStatus() {
        delay(3000)
        _isLogin.emit(true)
    }
}