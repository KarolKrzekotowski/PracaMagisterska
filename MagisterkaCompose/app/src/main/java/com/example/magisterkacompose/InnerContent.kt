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
import com.example.magisterkacompose.ui.SaleStory
import com.example.magisterkacompose.ui.theme.dark_red
import com.example.magisterkacompose.ui.theme.light_red
import com.example.magisterkacompose.ui.theme.md_theme_light_szarik
import com.example.magisterkacompose.ui.theme.otwarcie_zielony
import com.example.magisterkacompose.ui.theme.purple
import com.example.magisterkacompose.ui.theme.szarik_mocny
import com.example.magisterkacompose.ui.theme.szarik_tekst

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
        item {
            ShopSaving()
        }
    }
}

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




@Composable
fun LazyItemScope.ShopSaving() {
    Column(modifier = Modifier.fillParentMaxHeight(0.69f)) {
        Text(
            text = "Sklepowe oszczędności",
            fontWeight = FontWeight.W700,
            modifier = Modifier.padding(start = 16.dp, top = 12.dp, bottom = 22.dp)
        )
        LazyRow(
            modifier = Modifier.fillMaxHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { ShopSavingFirstPage() }
            for (offer in forYouItemList.reversed()) {
                item { ShopSavingItem(data = offer) }
            }
        }
    }
}

val gradientColors = listOf(light_red, dark_red)

@Composable
fun LazyItemScope.ShopSavingFirstPage() {
    val gradientColors = listOf(light_red, dark_red)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillParentMaxHeight()
            .fillParentMaxWidth(0.55f)
            .drawBehind {
                drawRect(
                    brush = Brush.radialGradient(
                        colors = gradientColors,
                        center = Offset(size.height / 10, size.height / 2),
                        radius = size.width
                    ),
                    size = size
                )
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .offset(10.dp, (-90).dp)
                    .size(60.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.pieczywo),
                    contentDescription = "hej",
                    tint = Color.Unspecified,
                    modifier = Modifier.fillMaxSize(),
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "TERAZ JESZCZE WIĘCEJ", fontWeight = FontWeight.ExtraBold)
                Text(
                    text = "OSZCZĘDNOŚCI",
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.headlineMedium
                )
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                ) {
                    val path = Path().apply {
                        moveTo(size.width * 0.9f, size.height * 0.2f) // Top point
                        lineTo(size.width * 0.1f, size.height * 0.3f)      // Bottom-left point
                        lineTo(size.width * 0.1f, size.height * 0.2f) // Bottom-right point
                        close()
                    }
                    drawPath(path, color = Color.Black, style = Fill)
                }
            }
        }
    }
}

@Composable
fun LazyItemScope.ShopSavingItem(
    data: ForYouItemObject,
    url: String = "Szczegóły oferty: \nwww.stronasklepu.pl"
) {
    Column(
        modifier = Modifier
            .fillParentMaxHeight()
            .fillParentMaxWidth(0.65f)
    ) {
        Column(
            modifier = Modifier
                .drawBehind {
                    drawRect(
                        brush = Brush.radialGradient(
                            colors = gradientColors,
                            center = Offset(size.height / 10, size.height / 2),
                            radius = size.width
                        ),
                        size = size
                    )
                }
                .fillMaxWidth()
                .fillMaxHeight(0.73f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${data.product}",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onError,
            )
            Image(
                painter = painterResource(id = data.image),
                contentDescription = "obrazek",
                modifier = Modifier
                    .fillMaxSize(0.7f)
                    .align(Alignment.CenterHorizontally)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth(0.33f)
                        .rotate(-5f)
                ) {
                    Text(
                        text = data.saleVariant,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier
                            .background(color = Color.Yellow)
                            .fillMaxWidth()
                            .padding(top = 6.dp, bottom = 6.dp),
                    )
                    val splittedText = data.pricePerItem.split(",")
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        dark_red, light_red, dark_red,
                                    ),
                                )
                            )
                            .fillMaxWidth(0.66f)
                    ) {
                        Text(
                            text = splittedText[0],
                            color = Color.White,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                        )
                        Column {
                            Text(
                                text = splittedText[1],
                                color = Color.White,
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .offset(y = 2.dp)
                            )
                            Text(
                                text = splittedText[2],
                                color = Color.White,
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier
                                    .offset(y = (-3).dp)
                            )
                        }
                    }
                }
                Column {
                    Text(
                        text = "Cena przed obniżką:",
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall
                    )
                    Text(
                        text = "${data.pricePerItem}",
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall
                    )
                    Text(
                        text = "${data.regularPrice}",
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = url,
                modifier = Modifier
                    .background(
                        color = szarik_mocny,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                style = MaterialTheme.typography.labelSmall,
                color = szarik_tekst,
                fontWeight = FontWeight(650),
                textAlign = TextAlign.Center,
                lineHeight = 12.sp
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "limit dzienny: ${data.limit}\n na kartę mój sklep",
                modifier = Modifier
                    .background(
                        color = szarik_mocny,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                style = MaterialTheme.typography.bodySmall,
                color = szarik_tekst,
                fontWeight = FontWeight(650),
                textAlign = TextAlign.Center,
                lineHeight = 12.sp
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "25.03-27.03 lub do wyczerpania zapasów",
                modifier = Modifier
                    .background(
                        color = szarik_mocny,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                style = MaterialTheme.typography.bodySmall,
                color = szarik_tekst,
                fontWeight = FontWeight(650),
                textAlign = TextAlign.Center,
                lineHeight = 12.sp
            )
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }
}



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


val forYouItemList: List<ForYouItemObject> =
    listOf(
        ForYouItemObject(
            image = R.drawable.pumpkin,
            requirement = "z aplikacją Mój Sklep",
            saleVariant = "2 + 1 GRATIS",
            pricePerItem = "2,32,szt.",
            theLowestPrice = "2.32 0% więcej",
            regularPrice = "3.48 33% taniej",
            product = "Dynia",
            details = "cena za 1 szt. przy zakupie 3 szt.",
            expiration = "04:00:00",
            limit = "3 szt",
        ),
        ForYouItemObject(
            R.drawable.brokul,
            requirement = "z aplikacją Mój Sklep",
            saleVariant = "DRUGI 64% TANIEJ",
            pricePerItem = "7,99,szt.",
            theLowestPrice = "11.90 32% mniej",
            regularPrice = "11.90 32% taniej",
            product = "Brokuły",
            details = "cena za 1 szt. przy zakupie 2 szt.",
            expiration = "05:50:00",
            limit = "4 szt",
        ),
        ForYouItemObject(
            image = R.drawable.mieso,
            requirement = "Kółko Krzyżyk",
            saleVariant = "59% TANIEJ",
            pricePerItem = "9,75,kg",
            theLowestPrice = "23.90 59% mniej",
            regularPrice = "23.90 59% taniej",
            product = "Świeży filet z piersi kurczaka",
            details = "/kg",
            expiration = "02:15:00",
            limit = "3 kg",
        ),
        ForYouItemObject(
            image = R.drawable.kawa,
            requirement = "Zdrapka",
            saleVariant = "53% TANIEJ",
            pricePerItem = "5,99,opak.",
            theLowestPrice = "12.99 53% mniej",
            regularPrice = "12.99 53% taniej",
            product = "Kawa, opak. 500g",
            details = "/szt",
            expiration = "02:15:00",
            limit = "1 szt.",
        ),
        ForYouItemObject(
            image = R.drawable.pumpkin,
            requirement = "z aplikacją Mój Sklep",
            saleVariant = "2 + 1 GRATIS",
            pricePerItem = "2,32,szt.",
            theLowestPrice = "2.32 0% więcej",
            regularPrice = "3.48 33% taniej",
            product = "Dynia",
            details = "cena za 1 szt. przy zakupie 3 szt.",
            expiration = "04:00:00",
            limit = "3 szt",
        ),
        ForYouItemObject(
            R.drawable.brokul,
            requirement = "z aplikacją Mój Sklep",
            saleVariant = "DRUGI 64% TANIEJ",
            pricePerItem = "7,99,szt.",
            theLowestPrice = "11.90 32% mniej",
            regularPrice = "11.90 32% taniej",
            product = "Brokuły",
            details = "cena za 1 szt. przy zakupie 2 szt.",
            expiration = "05:50:00",
            limit = "4 szt",
        ),
        ForYouItemObject(
            image = R.drawable.mieso,
            requirement = "Kółko Krzyżyk",
            saleVariant = "59% TANIEJ",
            pricePerItem = "9,75,kg",
            theLowestPrice = "23.90 59% mniej",
            regularPrice = "23.90 59% taniej",
            product = "Świeży filet z piersi kurczaka",
            details = "/kg",
            expiration = "02:15:00",
            limit = "3 kg",
        ),
        ForYouItemObject(
            image = R.drawable.kawa,
            requirement = "Zdrapka",
            saleVariant = "53% TANIEJ",
            pricePerItem = "5,99,opak.",
            theLowestPrice = "12.99 53% mniej",
            regularPrice = "12.99 53% taniej",
            product = "Kawa, opak. 500g",
            details = "/szt",
            expiration = "02:15:00",
            limit = "1 szt.",
        )
    )

