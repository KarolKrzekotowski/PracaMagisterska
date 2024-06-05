package com.example.magisterkacompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.magisterkacompose.ForYouItemObject
import com.example.magisterkacompose.ui.theme.md_theme_light_szarik
import com.example.magisterkacompose.ui.theme.purple
import com.example.magisterkacompose.ui.theme.szarik_mocny
import com.example.magisterkacompose.ui.theme.szarik_tekst

/**
 * Lista Tylko dla Ciebie
 *
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ForYou() {
    Column {
        Text(
            text = "Tylko dla Ciebie",
            fontWeight = FontWeight.W700,
            modifier = Modifier.padding(start = 16.dp, top = 12.dp, bottom = 22.dp)
        )
        LazyRow(
            modifier = Modifier
                .semantics {
                    testTagsAsResourceId = true
                }
                .testTag("ForYouRv")
        ) {
            for (offer in forYouItemList)
                item {
                    ForYouItem(offer)
                    Spacer(modifier = Modifier.width(8.dp))
                }
        }
    }
}

@Composable
fun LazyItemScope.ForYouItem(offer: ForYouItemObject) {
    Column(
        modifier = Modifier
            .background(md_theme_light_szarik)
            .fillParentMaxHeight()
            .fillParentMaxWidth(0.65f)
            .padding(start = 8.dp)
    ) {
        Text(
            text = offer.requirement,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .background(
                    color =
                    MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(16.dp)
                )
                .padding(start = 8.dp, end = 8.dp, bottom = 4.dp, top = 4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Image(
                painterResource(id = offer.image),
                contentDescription = "opis",
                modifier = Modifier
                    .aspectRatio(1.75f)
            )
        }
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
        ) {
            Text(
                text = offer.saleVariant,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .fillMaxWidth(0.66f)
                    .padding(top = 6.dp, bottom = 6.dp),
            )
            val splittedText = offer.pricePerItem.split(",")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.Red, MaterialTheme.colorScheme.primary),
                        )
                    )
                    .fillMaxWidth(0.66f)
            ) {
                Text(
                    text = splittedText[0],
//                    textAlign = TextAlign.Center,
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
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                Icons.Rounded.Info,
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .offset(y = 6.dp),
                tint = Color.Gray
            )
            Text(
                text = "najniższa cena: ${offer.theLowestPrice}\n" +
                        " cena regularna: ${offer.regularPrice}",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.W400
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = offer.product,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.height(32.dp))
        Column {
            Text(
                text = offer.details,
                modifier = Modifier
                    .background(
                        color = szarik_mocny,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(start = 6.dp, end = 6.dp),
                style = MaterialTheme.typography.bodySmall,
                color = szarik_tekst,
                fontWeight = FontWeight(650)
            )
            Row(
                modifier = Modifier
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = offer.expiration,
                    modifier = Modifier
                        .background(
                            color = szarik_mocny,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(start = 12.dp, end = 12.dp),
                    style = MaterialTheme.typography.bodySmall,
                    color = szarik_tekst,
                    fontWeight = FontWeight(650)
                )
                Text(
                    text = "Limit ${offer.limit}",
                    modifier = Modifier
                        .background(
                            color = szarik_mocny,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(start = 12.dp, end = 12.dp),
                    style = MaterialTheme.typography.bodySmall,
                    color = szarik_tekst,
                    fontWeight = FontWeight(650)
                )
            }
        }
    }
}
