package com.rama.eatelicious.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rama.eatelicious.data.Restaurant


@Composable
fun RestaurantList(contentPadding: PaddingValues, restaurants: List<Restaurant>){

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.padding(contentPadding)
            .verticalScroll(rememberScrollState())
    ) {
        for (restaurant in restaurants){
            RestaurantCard(restaurant)
        }
    }

}