package com.example.sampledatetimeapp

sealed class Screen(val route :String){
    object Splash : Screen("Splash_screen")
    object Home:Screen("Date_Screen")
}
