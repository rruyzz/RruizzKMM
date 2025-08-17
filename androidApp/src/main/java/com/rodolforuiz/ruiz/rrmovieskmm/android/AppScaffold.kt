package com.rodolforuiz.ruiz.rrmovieskmm.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.HomeScreen
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.Screens
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description.DetailScreen
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie


@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.HOME.route,
        modifier = modifier,
    ) {
        composable(Screens.HOME.route) {
            HomeScreen(
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
