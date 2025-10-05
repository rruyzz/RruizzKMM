package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rodolforuiz.ruiz.rrmovieskmm.login.presentation.LoginViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = getViewModel(),
) {
    val loginState = loginViewModel.loginState.collectAsState()

    Column {
        SignInScreen(
            onClick = { password, confirmPassword ->
//                loginViewModel.signIn(password, confirmPassword)
            }
        )

//        when {
//            loginState.value.screen is LoginAction.SignIn -> {
//                SignInScreen()
//            }
//
//            loginState.value.screen is LoginAction.SignUp -> {
//                SignUpScreen()
//            }
//
//            loginState.value.error != null -> {
//                ErrorMessage(loginState.value.error ?: "dsfds")
//            }
//
//            loginState.value.loading -> {
//                Loader()
//            }
//        }
    }
}

@Composable
fun SignUpScreen(
    onClick: (String, String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    var confirmText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            OutlinedTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("Enter your email") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = confirmText,
                onValueChange = { newText -> confirmText = newText },
                label = { Text("Confirm your email") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = { onClick(text, confirmText) }) {
                Text("Criar conta")
            }
        }
    }
}

@Composable
fun SignInScreen(
    onClick: (String, String) -> Unit,
) {
    var text by remember { mutableStateOf("") }
    var confirmText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            OutlinedTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("Enter your email") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = confirmText,
                onValueChange = { newText -> confirmText = newText },
                label = { Text("Confirm your password") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = { onClick(text, confirmText) }) {
                Text("Criar conta")
            }
        }
    }
}
