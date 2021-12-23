package com.learning.compose.topics

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learning.compose.ui.theme.JetpackComposeMasterTheme
import com.learning.compose.utils.FileUtils

class TopicsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeMasterTheme() {
                TopicsScreen()
            }
        }
    }
}

@Composable
fun TopicsScreen() {
    val context = LocalContext.current
    Surface(color = MaterialTheme.colors.background) {
        val topics = getTopics(context = context)
        LazyColumn {
            for (topic in topics) {
                item {
                    BasicText(text = topic.topic)
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview2() {
    JetpackComposeMasterTheme {
        TopicsScreen()
    }
}

fun getTopics(context: Context): List<Topics> {
    val topicString = FileUtils.getJsonDataFromAsset(context = context, "topics.json")

    val gson = Gson()
    val topicsType = object : TypeToken<List<Topics>>() {}.type
    return gson.fromJson(topicString, topicsType)
}

