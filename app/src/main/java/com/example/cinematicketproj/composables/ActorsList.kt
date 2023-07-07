package com.example.cinematicketproj.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.screens.film_detail.Actor


@Composable
fun ActorContent(actors: List<Actor>) {
    LazyRow(
        modifier = Modifier.wrapContentSize().padding(top=12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(actors) {
            ActorItem(actor = it)
        }
    }
}

@Composable
fun ActorItem(actor: Actor) {
    Image(
        modifier = Modifier
            .background(color = Color.Transparent, CircleShape)
            .width(64.dp)
            .clip(CircleShape)
            .height(64.dp),
        painter = painterResource(id = actor.imageRes),
        contentScale = ContentScale.Crop,
        contentDescription = "",
    )
}