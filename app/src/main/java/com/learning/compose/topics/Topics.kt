package com.learning.compose.topics

import kotlinx.serialization.Serializable

@Serializable
data class Topics(val id: Int, val topic: String, val description: String)


