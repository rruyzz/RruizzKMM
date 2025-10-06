package com.rodolforuiz.ruiz.rrmovieskmm.android

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.HomeScreen
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.Screens
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description.DetailScreen
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.login.LoginScreen
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie
import com.rodolforuiz.ruiz.rrmovieskmm.main.presentation.MainViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AppScaffold(mainViewModel: MainViewModel = getViewModel()) {
    val isLogged by mainViewModel.success.collectAsState()

    val navController = rememberNavController()

    when {
        isLogged == true -> {
            AppNavHost(navController = navController, startDestination = Screens.HOME)
        }
        isLogged == false -> {
            AppNavHost(navController = navController, startDestination = Screens.LOGIN)
        }
    }
}
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: Screens
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = modifier,
    ) {
        composable(Screens.LOGIN.route) {
            LoginScreen(
                navController = navController,
                success = {
                    navController.navigate(Screens.HOME.route)
                },
            )
        }
        composable(Screens.HOME.route) {
            HomeScreen(
                navController = navController,
                onAboutButtonClick = { movie ->
                    navController.navigate(movie)
                },
            )
        }
        composable<Movie>() { backStackEntry ->
            val args = backStackEntry.toRoute<Movie>()
            DetailScreen(args)
        }
    }
}
