package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.usecase

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.login.LoginResult
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.repository.LoginRepository


class GetLoginResultUseCase(
    private val loginRepository: LoginRepository
) {
    fun getLoginResult(): LoginResult {
        return loginRepository.getLoginResult()
    }
}