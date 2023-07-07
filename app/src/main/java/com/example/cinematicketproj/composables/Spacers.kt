package com.example.cinematicketproj.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerVertically16(){
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun SpacerVertically8(){
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun SpacerHorizontal8(){
    Spacer(modifier = Modifier.width(8.dp))
}

@Composable
fun SpacerHorizontal16(){
    Spacer(modifier = Modifier.width(16.dp))
}