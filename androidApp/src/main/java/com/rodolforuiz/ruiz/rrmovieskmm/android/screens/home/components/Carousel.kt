package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Carousel(
    movieList: List<Movie>,
    onAboutButtonClick: () -> Unit,
) {
    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState {
            movieList.size
        },
        preferredItemWidth = 310.dp,
        itemSpacing = 16.dp,
        contentPadding = PaddingValues(start = 12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentHeight()
            .padding(top = 12.dp, bottom = 12.dp)
    ) { index ->
        val value = movieList[index]
        Box(
            modifier = Modifier.clickable { onAboutButtonClick() }
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = value.backdropPath),
                contentDescription = value.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .maskClip(shape = MaterialTheme.shapes.extraLarge)
            )
            Text(
                text = value.title,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            )
        }
    }
}
