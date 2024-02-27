package com.example.tacticaltimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tacticaltimer.ui.theme.TacticalTimerTheme


class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TacticalTimerTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}