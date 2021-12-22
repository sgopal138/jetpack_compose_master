package com.learning.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.learning.compose.greeting.GreetingScreen
import com.learning.compose.ui.theme.JetpackComposeMasterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchApp()
        }
    }
}

@Composable
fun LaunchApp() {
    JetpackComposeMasterTheme {
        Surface(color = MaterialTheme.colors.background) {
            GreetingScreen()
        }
    }
}

@Preview(showBackground = true, name = "WelcomeActivity")
@Composable
fun DefaultPreview() {
    JetpackComposeMasterTheme {
        LaunchApp()
    }
}