package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.data

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.model.token.Token
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginDataSource {

    var _email = ""
    var _password = ""

    fun signIn(email: String, confirmPassword: String): Flow<Token> = flow {
        delay(3000)

        if (_password == confirmPassword && _email == email) {
            emit(Token("TokenSalvo"))
        } else {
            throw Throwable("Diferente Password")
        }
    }

    fun signUp(email: String, password: String)= flow {
        delay(3000)
        _email = email
        _password= password
        emit(Token("TokenSalvo de Novo"))
    }
}