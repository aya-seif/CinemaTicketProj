package com.example.cinematicketproj.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.R
import com.example.cinematicketproj.ui.theme.lightGrey
import com.example.cinematicketproj.ui.theme.White

@Composable
fun DurationView(){
    Row(
        modifier = Modifier
            .padding(top = 32.dp, end = 16.dp)
            .wrapContentWidth()
            .background(lightGrey, RoundedCornerShape(16.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { /* Do something */ },
            modifier = Modifier
                .size(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.hour),
                contentDescription = "Favorite",
                tint = White
            )
        }
        Text("2h 23m", color = White, modifier = Modifier.padding(start = 4.dp))
    }
}