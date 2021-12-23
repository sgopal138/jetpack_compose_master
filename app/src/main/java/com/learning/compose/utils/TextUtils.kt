package com.learning.compose.utils

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.learning.compose.R

@Composable
fun SimpleText(text: String, modifier: Modifier) {
    Text(
        text,
        modifier = modifier
    )
}

@Composable
fun StringResourceText() {
    Text(stringResource(R.string.app_name))
}