package com.example.sampledatetimeapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.sampledatetimeapp.ui.theme.SampleDateTimeAppTheme
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleDateTimeAppTheme {
                // A surface container using the 'background' color from the theme
NavigationSetup(navController = rememberNavController())
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateTimePicker(){

    val context = LocalContext.current


    var pickedDate by remember{
        mutableStateOf(LocalDate.now())
    }


    var pickedTime by remember {
        mutableStateOf(LocalTime.NOON)
    }


    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MMM dd yyy")
                .format(pickedDate)
        }
    }


    val formattedTime by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("hh:mm")
                .format(pickedTime)
        }
    }


    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()




    Column(modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { dateDialogState.show() }) {
            Text(text = "pick a date")
        }


        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {timeDialogState.show() }) {
            Text(text = "pick a time")
        }
        Text(text = formattedDate)

    }

    MaterialDialog(dialogState = dateDialogState,
        buttons = {
            positiveButton(text = "ok") {

            }


        }) {


        datepicker(
            initialDate = LocalDate.now(),
            title = "Pick a date",


            ) {
            pickedDate = it
        }


    }

    MaterialDialog(dialogState = timeDialogState,

        buttons = {
            positiveButton(text = "ok") {
            }


        }) {
        timepicker(
            initialTime = LocalTime.NOON,
            title = "pick a time",
            timeRange = LocalTime.MIDNIGHT..LocalTime.NOON
        ) {
            pickedTime = it
        }




    }}
