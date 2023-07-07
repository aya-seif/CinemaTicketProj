package com.example.cinematicketproj

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.cinematicketproj.screens.BottomNavItem
import com.example.cinematicketproj.screens.BottomNavigationBar
import com.example.cinematicketproj.screens.Navigation
import com.example.cinematicketproj.screens.booking.BookingScreen
import com.example.cinematicketproj.screens.film_detail.FilmScreen
import com.example.cinematicketproj.screens.home.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            HomeScreen()
//            FilmScreen()
//            BookingScreen()


            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        items = listOf(
                            BottomNavItem(
                                route = "home",
                                icon = R.drawable.hour,
                                name = "Home"
                            ),
                            BottomNavItem(
                                route = "search",
                                icon = R.drawable.hour,
                                name = "Search"
                            ),
                            BottomNavItem(
                                route = "booking",
                                icon = R.drawable.hour,
                                name = "Booking",
                                badgeCount = 5
                            ), BottomNavItem(
                                route = "profile",
                                icon = R.drawable.hour,
                                name = "Profile"
                            )
                        ),
                        navController = navController,
                        modifier = Modifier.height(56.dp).background(Color.White),
                        onItemClick = {
                            navController.navigate(it.route)
                        }
                    )
                }
            ) {
                Navigation(navController = navController)
            }
        }
    }
}

