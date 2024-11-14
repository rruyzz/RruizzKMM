package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
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


@Composable
fun MoviesGrid(movieList: List<Movie>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.background(Color.Transparent, RoundedCornerShape(50))
    ) {
        items(movieList.size, key = { it }) { movie ->
            CardMovie(movieList[movie])
        }
    }
}


@Composable
fun CardMovie(movie: Movie) {
    Box(
        Modifier
            .background(Color.Red)
            .wrapContentSize()) {
        Image(
            painter = rememberAsyncImagePainter(model = movie.posterPath),
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .wrapContentWidth()
                .height(190.dp)
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