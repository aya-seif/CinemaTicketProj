package com.example.cinematicketproj.composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.ui.theme.Orange

@Composable
fun RoundedOrangeButton(
    iconId: Int,
    textId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .padding(end = 16.dp, bottom = 16.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Orange),
        onClick = onClick
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = ""
        )
        Text(
            text = stringResource(id = textId),
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}