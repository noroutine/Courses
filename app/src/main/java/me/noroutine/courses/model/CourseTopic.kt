package me.noroutine.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CourseTopic(
    @StringRes val topicNameId: Int,
    val numberOfCourses: Int,
    @DrawableRes val topicIconId: Int
)