package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.model.DetailContent

@Composable
fun Info(
    detailContent: DetailContent?
) {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = detailContent?.year ?: "Ano")
        Spacer(modifier = Modifier.width(16.dp))
        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp),
            color = Color.White
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = detailContent?.minute ?: "Minuto")
    }
}