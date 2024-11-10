package com.rodolforuiz.ruiz.rrmovieskmm.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.components.Carousel
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.components.HomeTab
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = getViewModel(),
) {

    val homeState = homeViewModel.homeState.collectAsState()

    Column {
        if (homeState.value.error != null)
            ErrorMessage(homeState.value.error!!)
        if (homeState.value.movies.isNotEmpty())
            HomeView(homeViewModel)
        if (homeState.value.loading) {
            Loader()
        }
    }
}

@Composable
fun HomeView(viewModel: HomeViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        Title()

        Carousel(viewModel)

        HomeTab(viewModel)

    }
}


@Composable
fun Title() {
    Text(
        text = "What do you want to watch?",
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.padding(16.dp, 32.dp)
    )
}

@Composable
fun ArticleItemView(movie: Movie) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = movie.backdropPath,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = movie.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = movie.description)
        Spacer(modifier = Modifier.height(4.dp))
//        Text(
//            text = movie.date,
//            style = TextStyle(color = Color.Gray),
//            modifier = Modifier.align(Alignment.End)
//        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun Loader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary,
        )
    }
}

@Composable
fun ErrorMessage(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center)
        )
    }
}