package com.example.tacticaltimer.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tacticaltimer.R

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    var player1Time by remember { mutableStateOf(600) } // Initial time for player 1 (in seconds)
    var player2Time by remember { mutableStateOf(600) } // Initial time for player 2 (in seconds)
    var isPlayer1Running by remember { mutableStateOf(false) }
    var isPlayer2Running by remember { mutableStateOf(false) }
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "Home") {
//        composable("home") {
//            MainActivity(navController)
//        }
//        composable("settings") {
//            SettingsActivity(navController)
//        }
//    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Player 1 section
        Box(
            Modifier
                .weight(1f)
                .rotate(180f)
        ) {
            PlayerSection(time = player1Time,
                Color.LightGray,
                isRunning = isPlayer1Running,
                onStartStopClick = { isPlayer1Running = !isPlayer1Running })
        }

        // Controls section
        ControlsSection()

        // Player 2 section
        Box(Modifier.weight(1f)) {
            PlayerSection(time = player2Time,
                Color.Gray,
                isRunning = isPlayer2Running,
                onStartStopClick = { isPlayer2Running = !isPlayer2Running })
        }
    }
}

@Composable
fun PlayerSection(
    time: Int,
    background: Color,
    isRunning: Boolean,
    onStartStopClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(32.dp),
    ) {
        Text(text = "Moves: $ moves")
        Text(text = formatTime(time), fontSize = 48.sp, modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun ControlsSection(
) {
    Row(
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .padding(32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ClickableIcon(R.drawable.restore, onClick = {
            restart()
        })
        Spacer(
            modifier = Modifier
                .width(40.dp)
        )
        ClickableIcon(imageResId = R.drawable.play_arrow, onClick = {
            playPause()
        })
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        ClickableIcon(imageResId = R.drawable.settings, onClick = {
            goToSettings()
        })
    }
}

@Composable
fun ClickableIcon(imageResId: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = null, // Content description for accessibility
        modifier = Modifier
            .size(48.dp)
            .clickable(onClick = onClick) // Make the image clickable
    )
}

fun restart() {
    // TODO: implement this function
}

fun playPause() {
    // TODO: implement this function
}

fun goToSettings() {
    // TODO: implement this function
}

fun formatTime(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60
    return String.format("%02d:%02d", minutes, remainingSeconds)
}