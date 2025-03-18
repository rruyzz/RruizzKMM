package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Toolbar(isSaved: Boolean?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, // Exemplo de ícone
            contentDescription = "Ícone Esquerda",
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "Descrição",
            style = MaterialTheme.typography.bodyLarge
        )
        Icon(
            imageVector = if (isSaved == true) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
            contentDescription = "Ícone Direita",
            modifier = Modifier.size(24.dp)
        )
    }
}