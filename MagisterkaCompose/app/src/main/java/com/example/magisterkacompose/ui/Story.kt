package com.example.magisterkacompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.magisterkacompose.storyMap

/**
 * Pierwsza lista z okrągłymi elementami.
 *
 */
@Composable
fun SaleStory() {
    LazyRow(
        modifier = Modifier
            .padding(top = 14.dp, bottom = 20.dp)
    ) {
        for (icon in storyMap) {
            item {
                Spacer(modifier = Modifier.width(12.dp))
                Story(
                    painterResource(
                        id = icon.key
                    ),
                    text = icon.value
                )
            }
        }
    }
}

@Composable
fun Story(painter: Painter, text: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .border(4.dp, MaterialTheme.colorScheme.primary, CircleShape)
        ) {
            Image(
                painter = painter,

                contentDescription = text,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(75.dp)

            )
        }
        Text(text = text)
    }
}