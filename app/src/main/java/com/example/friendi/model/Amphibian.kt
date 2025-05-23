package com.example.friendi.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Amphibian(
    val name: String,
    val type: String,
    val description: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)