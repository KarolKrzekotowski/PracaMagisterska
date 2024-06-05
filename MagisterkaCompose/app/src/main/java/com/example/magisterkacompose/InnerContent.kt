package com.example.magisterkacompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.magisterkacompose.ui.ForYou
import com.example.magisterkacompose.ui.NearestShop
import com.example.magisterkacompose.ui.SaleStory
import com.example.magisterkacompose.ui.theme.dark_red
import com.example.magisterkacompose.ui.theme.light_red
import com.example.magisterkacompose.ui.theme.md_theme_light_szarik
import com.example.magisterkacompose.ui.theme.otwarcie_zielony
import com.example.magisterkacompose.ui.theme.purple
import com.example.magisterkacompose.ui.theme.szarik_mocny
import com.example.magisterkacompose.ui.theme.szarik_tekst

/**
 *
 * Wewnętrzna zawartość ekranu
 *
 */
@Composable
fun InnerContent(modifier: Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        item {
            NearestShop()
        }
        item {
            SaleStory()
        }
        item {
            ForYou()
        }
    }
}




val gradientColors = listOf(light_red, dark_red)

val storyMap: Map<Int, String> =
    mapOf(
        R.drawable.panda to "Panda",
        R.drawable.pumpkin to "Dynie",
        R.drawable.brokul to "Brokuły",
        R.drawable.frytki to "Frytki",
        R.drawable.jajko to "Jajka",
        R.drawable.kawa to "Kawa",
        R.drawable.mieso to "Mięso",
        R.drawable.pieczywo to "Pieczywo",
        R.drawable.pizza to "Pizza",
        R.drawable.ramen to "Ramen",
        R.drawable.taco to "Taco",
        R.drawable.tost to "Tost"
    )




