package com.example.sampledatetimeapp

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay


@Composable
fun AnimatedSplashScreen(navController:NavHostController){

    var startAnimation by remember{
        mutableStateOf(false)
    }

    val alphaAnim = animateFloatAsState(targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )


    LaunchedEffect(key1 = true ){
        startAnimation=true
        delay(4000)
        navController.navigate(Screen.Home.route)
    }
Splash(alpha = alphaAnim.value)
}




@Composable
fun Splash(alpha:Float,){


    Box(modifier = Modifier
        .alpha(alpha=alpha)
        .background(Color.Blue)
        .fillMaxSize(),
        contentAlignment = Alignment.Center,){
        Icon(modifier= Modifier.size(240.dp),imageVector = Icons.Default.DateRange,
            contentDescription = null,
            tint = Color.Yellow)
    }
}