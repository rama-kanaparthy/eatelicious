package com.rama.eatelicious.repositories

import com.rama.eatelicious.data.Restaurant
import com.rama.eatelicious.R

class RestaurantRepository {

    val restaurantLazyList = mutableListOf<Restaurant>(
        Restaurant("Aaradya1","feel home", R.drawable.restaurant_01),
        Restaurant("Aaradya2","feel home", R.drawable.restaurant_02),
        Restaurant("Aaradya3","feel home", R.drawable.restaurant_03),
        Restaurant("Aaradya4","feel home", R.drawable.restaurant_04),
        Restaurant("Aaradya5","feel home", R.drawable.restaurant_05),
        Restaurant("Aaradya6","feel home", R.drawable.restaurant_06),
        Restaurant("Aaradya7","feel home", R.drawable.restaurant_07),
        Restaurant("Aaradya8","feel home", R.drawable.restaurant_08),
        Restaurant("Aaradya9","feel home", R.drawable.restaurant_09),
        Restaurant("Aaradya10","feel home", R.drawable.restaurant_10)
    )

    fun getRestaurant(name: String): Restaurant? {

        restaurantLazyList.forEach {
            if(name == it.name){
                return it
            }
        }
        return null
    }

    fun getRestaurantList(): MutableList<Restaurant> {
        return restaurantLazyList
    }
}