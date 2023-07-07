package com.example.cinematicketproj.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Badge
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cinematicketproj.R
import com.example.cinematicketproj.composables.ShowText
import com.example.cinematicketproj.composables.SpacerHorizontal8
import com.example.cinematicketproj.screens.BottomNavItem
import com.example.cinematicketproj.ui.theme.Orange
import com.example.cinematicketproj.ui.theme.lightGrey
import com.example.cinematicketproj.ui.theme.White
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cinematicketproj.composables.ChipDurationView
import com.example.cinematicketproj.composables.FilmClassificationList
import com.example.cinematicketproj.composables.FilmTitle
import com.example.cinematicketproj.ui.theme.MediumTextStyle
import com.example.cinematicketproj.ui.theme.OnBackGround


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(
    ExperimentalPagerApi::class, ExperimentalMaterial3Api::class
)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {

    val state by viewModel.state.collectAsState()
    HomeScreenContent(state = state)


//    val pagerState = rememberPagerState(3)
//    val matrix = remember {
//        ColorMatrix()
//    }
//    Column {
//        HorizontalPager(
//            modifier = Modifier
//                .padding(top = 40.dp),
//            contentPadding = PaddingValues(horizontal = 56.dp),
//            count = images.size,
//            state = pagerState,
//        ) { index ->
//            val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffset
//            val imageSize by animateFloatAsState(
//                targetValue = if (pageOffset != 0.0f) 0.75f else 1f,
//                animationSpec = tween(2000)
//            )
//            LaunchedEffect(key1 = imageSize) {
//                if (pageOffset != 0.0f) matrix.setToSaturation(0f) else matrix.setToSaturation(1f)
//            }
//            Image(
//                modifier = Modifier
//                    .width(320.dp)
//                    .height(400.dp)
//                    .graphicsLayer {
//                        scaleX = imageSize
//                        scaleY = imageSize
//                        alpha = imageSize
//                    }
//                    .clip(RoundedCornerShape(32.dp)),
//                contentScale = ContentScale.Crop,
//                painter = painterResource(id = images[index]),
//                contentDescription = "",
//                colorFilter = ColorFilter.colorMatrix(matrix)
//            )
//        }
//        Row(
//            modifier = Modifier
//                .padding(top = 32.dp, end = 16.dp)
//                .align(Alignment.CenterHorizontally)
//                .wrapContentWidth()
//                .background(lightGrey, RoundedCornerShape(16.dp))
//                .padding(8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            IconButton(
//                onClick = { /* Do something */ },
//                modifier = Modifier
//                    .size(16.dp)
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.hour),
//                    contentDescription = "Favorite",
//                    tint = White
//                )
//            }
//            Text("2h 23m", color = White, modifier = Modifier.padding(start = 4.dp))
//        }
//
//        SpacerHorizontal8()
//        ShowText("")
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
////            Chip(title = "Fantasy")
////            SpacerHorizontal8()
////            Chip(title = "Adventure")
//        }

}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreenContent(
    state: HomeUiState
) {
    val pagerState = rememberPagerState(state.filmList.size)
    val matrix = remember {
        ColorMatrix()
    }



    Column() {
        Column {
            HorizontalPager(
                modifier = Modifier
                    .padding(top = 90.dp),
                contentPadding = PaddingValues(horizontal = 56.dp),
                count = state.filmList.size,
                state = pagerState,
            ) { index ->
                val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffset
                val imageSize by animateFloatAsState(
                    targetValue = if (pageOffset != 0.0f) 0.75f else 1f,
                    animationSpec = tween(2000)
                )
                LaunchedEffect(key1 = imageSize) {
                    if (pageOffset != 0.0f) matrix.setToSaturation(0f) else matrix.setToSaturation(
                        1f
                    )
                }
                Image(
                    modifier = Modifier
                        .width(300.dp)
                        .height(360.dp)
                        .graphicsLayer {
                            scaleX = imageSize
                            scaleY = imageSize
                            alpha = imageSize
                        }
                        .clip(RoundedCornerShape(32.dp)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = state.filmList[index]),
                    contentDescription = "",
                    colorFilter = ColorFilter.colorMatrix(matrix)
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(top = 36.dp)
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* Do something */ },
                modifier = Modifier
                    .size(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.hour),
                    contentDescription = "",
                    tint = lightGrey
                )
            }
            Text(
                state.filmDuration,
                style = MediumTextStyle,
                color = OnBackGround,
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        FilmTitle(
            text = state.filmName,
        )
        FilmClassificationList(state.filmClassifications)


    }


}

//@Composable
//fun ImageWithGradient(
//    painter: Painter,
//    contentDescription: String?,
//    modifier: Modifier = Modifier,
//    gradientHeight: Dp = 100.dp
//) {
//    Box(modifier) {
//        Image(
//            painter = painter,
//            contentDescription = contentDescription,
//            modifier = Modifier.fillMaxWidth(),
//            contentScale = ContentScale.Crop,
//        )
//        Spacer(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(
//                    Brush.verticalGradient(
//                        colors = listOf(Color.Transparent, Color.White),
//                        startY = 0f,
//                        endY = 300f
//                    )
//                )
//        )
//    }
//}

