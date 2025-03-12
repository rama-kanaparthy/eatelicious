package com.rama.eatelicious.data

data class Restaurant(
    val name: String,
    val tagLine: String,
    val img: Int,
    val address: String = "",
    val rating : Float = 0f,
    val cuisine: String = "",
    val menuItems: List<MenuItem> = emptyList<MenuItem>()
)
