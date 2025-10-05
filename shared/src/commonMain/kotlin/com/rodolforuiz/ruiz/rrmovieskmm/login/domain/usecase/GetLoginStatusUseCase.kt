package com.rodolforuiz.ruiz.rrmovieskmm.login.domain.usecase

import com.rodolforuiz.ruiz.rrmovieskmm.login.domain.model.login.LoginResult
import com.rodolforuiz.ruiz.rrmovieskmm.login.domain.repository.login.LoginRepository

class GetLoginStatusUseCase(
    private val loginRepository: LoginRepository
) {
    fun getLoginStatus(): LoginResult {
        return loginRepository.getLoginStatus()
    }
}