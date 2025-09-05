package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Grade(modifier: Modifier, grade: String) {
    Box(
        modifier = modifier
            .padding(6.dp)
            .background(Color(0x8147444B), shape = RoundedCornerShape(16.dp)) // 👈 bordas arredondadas
    ) {
        Row(
            modifier = Modifier
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = grade,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(4.dp, 0.dp)
            )
            Icon(
                imageVector = Icons.Filled.Star, // Exemplo de ícone
                contentDescription = "Ícone Esquerda",
                modifier = Modifier.size(16.dp)
            )
        }
    }
}