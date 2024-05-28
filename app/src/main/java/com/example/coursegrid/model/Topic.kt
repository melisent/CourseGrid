package com.example.coursegrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val courseNameId: Int,
    val amountOfCourses: Int,
    @DrawableRes val courseImageId: Int
)
