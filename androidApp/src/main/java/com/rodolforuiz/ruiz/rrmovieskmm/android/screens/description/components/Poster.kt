package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.model.DetailContent

@Composable
fun Poster(modifier: Modifier, detailContent: DetailContent?) {
    Row(
        modifier = modifier
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = detailContent?.poster),
            contentDescription = detailContent?.description,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(140.dp)
        )
        Text(
            text = detailContent?.title ?: "sd;lksamd",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .offset(y = 24.dp)
                .padding(8.dp)
        )
    }
}
