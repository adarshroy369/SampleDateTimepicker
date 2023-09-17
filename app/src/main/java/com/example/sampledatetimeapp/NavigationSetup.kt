package com.example.sampledatetimeapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationSetup(navController:NavHostController){

    NavHost(navController = navController,
        startDestination =Screen.Splash.route ){

        composable(route=Screen.Splash.route){
            AnimatedSplashScreen(navController)
        }

        composable(route=Screen.Home.route){
            DateTimePicker()
        }
    }
}