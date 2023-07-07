package com.example.cinematicketproj.composables


import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.R
import com.example.cinematicketproj.ui.theme.White

@Composable
fun PlayButtonView(
    modifier: Modifier
) {
    IconButton(
        onClick = { /* Do something */ },
        modifier = modifier,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.play),
            modifier = Modifier.size(16.dp),
            contentDescription = "",
            tint = White
        )
    }
}
