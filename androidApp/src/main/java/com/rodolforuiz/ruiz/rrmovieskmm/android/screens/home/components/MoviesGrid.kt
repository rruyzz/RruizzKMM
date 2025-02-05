package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie


@Composable
fun MoviesGrid(
    movieList: List<Movie>,
    onAboutButtonClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        CardRow(movieList.subList(0, 3), onAboutButtonClick = { onAboutButtonClick() })
        CardRow(movieList.subList(3, 6), onAboutButtonClick = { onAboutButtonClick() })
        CardRow(movieList.subList(6, 9), onAboutButtonClick = { onAboutButtonClick() })
        CardRow(movieList.subList(9, 12), onAboutButtonClick = { onAboutButtonClick() })
        CardRow(movieList.subList(12, 15), onAboutButtonClick = { onAboutButtonClick() })
        CardRow(movieList.subList(15, 18), onAboutButtonClick = { onAboutButtonClick() })
    }
}

@Composable
fun CardRow(rowList: List<Movie>, onAboutButtonClick: () -> Unit) {
    Row(
        modifier = Modifier.wrapContentWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (i in 0..2) {
            CardMovie(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 5.dp),
                movie = rowList[i],
                onAboutButtonClick = { onAboutButtonClick() })
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
                .wrapContentWidth()
                .height(190.dp)
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