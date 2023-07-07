package com.example.cinematicketproj.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Badge
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cinematicketproj.screens.booking.BookingScreen
import com.example.cinematicketproj.screens.film_detail.FilmScreen
import com.example.cinematicketproj.screens.home.HomeScreen
import com.example.cinematicketproj.ui.theme.Orange


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier,
    onItemClick: (BottomNavItem) -> Unit,
) {

    val baskStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        items.forEach { item ->
            val selected = item.route == baskStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Orange,
                unselectedContentColor = Color.Transparent,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(
                                badge = {
                                    Badge(backgroundColor = Orange) {
                                        Text(
                                            item.badgeCount.toString(),
                                            color = Color.White
                                        )
                                    }
                                }) {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    modifier = Modifier
                                        .size(32.dp),
                                    tint = Color.White,
                                    contentDescription = item.name
                                )
                            }
                        } else {
                            Icon(
                                painter = painterResource(id = item.icon),
                                modifier = Modifier.size(32.dp),
                                tint = Color.Black,
                                contentDescription = item.name
                            )
                        }
                    }
                    if (selected) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            modifier = Modifier
                                .size(32.dp)
                                .background(Orange, CircleShape)
                                .padding(5.dp),
                            tint = Color.White,
                            contentDescription = item.name
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = item.icon),
                            modifier = Modifier.size(32.dp),
                            tint = Color.Black,
                            contentDescription = item.name
                        )
                    }
                }
            )
        }


    }

}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("search") {
            SearchScreen()
        }
        composable("booking") {
            BookingScreen()
        }
        composable("profile") {
            FilmScreen()
        }
    }
}

@Composable
fun SearchScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "SearchScreen")
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "ProfileScreen")
    }
}

@Composable
fun BookingScreen2() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "BookingScreen")
    }
}