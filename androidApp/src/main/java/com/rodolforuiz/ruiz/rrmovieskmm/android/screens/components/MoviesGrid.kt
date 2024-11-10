package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.HomeViewModel


@Composable
fun MoviesGrid(viewModel: HomeViewModel) {

    Text("Rodolfo")
    println("RodolfoLogksfna sdafsdf")

    val nowPlayingList = viewModel.homeState.value.movies
    println("RodolfoLogksfna ${nowPlayingList.toString()}")
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize().background(Color.Red),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(nowPlayingList.size, key = { it }) { movie ->
            Card(nowPlayingList[movie])
        }
    }
}


@Composable
fun Card(movie: Movie) {
    Box() {
        Image(
            painter = rememberAsyncImagePainter(model = movie.posterPath),
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(16.dp)
                .height(150.dp)
                .fillMaxWidth()
        )
        Text(
            text = movie.title,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )
    }
}