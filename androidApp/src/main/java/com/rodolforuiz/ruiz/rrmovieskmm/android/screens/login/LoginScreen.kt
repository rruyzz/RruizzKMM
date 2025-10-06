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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.Screens
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.ErrorMessage
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.Loader
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.presentation.LoginAction
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.presentation.LoginViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
    success: (Unit) -> Unit,
    loginViewModel: LoginViewModel = getViewModel(),
) {
    val loginState = loginViewModel.loginState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        loginViewModel.getLoginStatus()
    }

    Column {
        when {
            loginState.value.screen is LoginAction.SignUp -> {
                SignUpScreen(
                    onClick = { email, password ->
                        loginViewModel.signUp(email, password)
                    })
            }

            loginState.value.screen is LoginAction.SignIn -> {
                SignInScreen(
                    onClick = { email, password ->
                        loginViewModel.signIn(
                            email,
                            password,
                            onSuccess = { unit ->
                                success(unit)
                            })
                    }
                )
            }

            loginState.value.screen is LoginAction.Home -> {
                SignInScreen(
                    onClick = { email, password ->
                        loginViewModel.signIn(
                            email,
                            password,
                            onSuccess = { unit ->
                                navController.navigate(Screens.HOME.route)
                            })
                    }
                )
            }

            loginState.value.error != null -> {
                ErrorMessage(loginState.value.error ?: "dsfds")
            }

            loginState.value.loading -> {
                println("Rodolfeira loading")

                Loader()
            }
        }
    }
}

@Composable
fun SignInScreen(
    onClick: (String, String) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column {
            OutlinedTextField(
                value = email,
                onValueChange = { newText -> email = newText },
                label = { Text("Enter your email") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = { newText -> password = newText },
                label = { Text("Confirm your password") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = { onClick(email, password) }) {
                Text("Logar")
            }
        }
    }
}

@Composable
fun SignUpScreen(
    onClick: (String, String) -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column {
            OutlinedTextField(
                value = email,
                onValueChange = { newText -> email = newText },
                label = { Text("Enter your email") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = { newText -> password = newText },
                label = { Text("Enter your password") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { newText -> confirmPassword = newText },
                label = { Text("Enter your password") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = { onClick(email, confirmPassword) },
                enabled = password == confirmPassword && password != ""
            ) {
                Text("Criar Conta")
            }
        }
    }
}
