package com.example.friendi.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Amphibian(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)