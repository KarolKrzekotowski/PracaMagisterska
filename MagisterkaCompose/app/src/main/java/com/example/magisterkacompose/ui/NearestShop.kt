package com.example.magisterkacompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.magisterkacompose.ui.theme.md_theme_light_szarik
import com.example.magisterkacompose.ui.theme.otwarcie_zielony

@Composable
fun NearestShop() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(bottom = 12.dp)
            .background(md_theme_light_szarik),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.width(1.dp))
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.White)
                .size(50.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Filled.ShoppingCart,
                contentDescription = "Shop",
                tint = MaterialTheme.colorScheme.secondary,
            )
        }
        Column {
            Text(
                text = "Twój sklep: ul. Poniatowskiego 34",
                style = MaterialTheme.typography.bodySmall,
            )
            Row {
                Text(
                    text = "Otwarte",
                    color = otwarcie_zielony,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "·",
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp)
                )
                Text(text = "Zamknięcie o 23:00", fontWeight = FontWeight.Bold)
            }
        }
        Icon(
            Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "hej",
            modifier = Modifier.padding(end = 12.dp)
        )
    }
}