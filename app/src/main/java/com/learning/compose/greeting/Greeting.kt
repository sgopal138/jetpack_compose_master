package com.learning.compose.greeting

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.learning.compose.R
import com.learning.compose.topics.TopicsActivity
import com.learning.compose.utils.filledTextField

@Composable
fun GreetingScreen() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(id = R.string.app_name)) })
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { launchActivity(context) },
                backgroundColor = Color.Magenta,
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = stringResource(R.string.content_desc)
                )
            }
        },

        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {

                val input = filledTextField(
                    "Enter name",
                    modifier = Modifier
                        .padding(16.dp)
                )

                Spacer(modifier = Modifier.padding(top = 16.dp))

                Text(
                    text = stringResource(id = R.string.lets_start, input),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    )
}

fun launchActivity(context: Context) {
    context.startActivity(Intent(context, TopicsActivity::class.java))
}