package com.example.cinematicketproj.screens

data class BottomNavItem(
    val route: String,
    val icon: Int,
    val badgeCount: Int = 0,
    val name : String,
)
