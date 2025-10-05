package com.rodolforuiz.ruiz.rrmovieskmm.main

import com.rodolforuiz.ruiz.rrmovieskmm.BaseViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.usecase.GetLoginResultUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: GetLoginResultUseCase
) : BaseViewModel() {

    private val _isLogin: MutableStateFlow<Boolean?> =
        MutableStateFlow(null)

    val success: StateFlow<Boolean?> get() = _isLogin

    init {
        scope.launch{
            getStatus()
        }
    }
    suspend fun getStatus() {
        delay(3000)
        _isLogin.emit(true)
    }
}