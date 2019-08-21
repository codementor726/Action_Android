package com.actionCartingEnvironmental.action.model

data class EventModel(
    val event : Boolean? = false,
    val recycling: Boolean? = false,
    val cardboard: Boolean? = false,
    val compost: Boolean? = false,
    val holiday: Boolean? = false
)
