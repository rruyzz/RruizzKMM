package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie


@Composable
fun MoviesGrid(
    movieList: List<Movie>,
    onAboutButtonClick: (Movie) -> Unit,
) {
    val groupList = movieList.chunked(3)
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        groupList.forEach {
            CardRow(
                rowList = it,
                onAboutButtonClick = { movie ->
                    onAboutButtonClick(movie)
                }
            )
        }
    }
}

@Composable
fun CardRow(
    rowList: List<Movie>,
    onAboutButtonClick: (Movie) -> Unit,
) {
    Row(
        modifier = Modifier.wrapContentWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (movie in rowList) {
            CardMovie(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .weight(1f),
                movie = movie,
                onAboutButtonClick = { onAboutButtonClick(movie) })
        }


    }

}

@Composable
fun CardMovie(
    modifier: Modifier, movie: Movie, onAboutButtonClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable(
                enabled = true,
                onClick = {
                    onAboutButtonClick()
                }
            ),
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = movie.posterPath),
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
//                .wrapContentWidth()
//                .fillMaxHeight(0.9f)
                .height(200.dp)
        )
        Text(
            text = movie.title,
            style = MaterialTheme.typography.labelMedium,
            maxLines = 2,
            overflow = Ellipsis,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(4.dp)
        )
    }
}