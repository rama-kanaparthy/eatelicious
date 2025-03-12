package com.rama.eatelicious

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rama.eatelicious.data.MenuItem
import com.rama.eatelicious.data.Restaurant

class MainViewModel : ViewModel() {
    private val _restaurants = MutableLiveData<Restaurant>()
    val restaurant: LiveData<Restaurant> = _restaurants

    init {
        _restaurants.value =  Restaurant(
            name = "Aaradya Pizza Delight",
            tagLine = "Best Pizza in Town",
            img = R.drawable.restaurant_01, // Replace with actual drawable resource
            address = "123 Pizza Street",
            rating = 4.5f,
            cuisine = "Italian",
            menuItems = listOf(MenuItem("Margherita", 9.99f), MenuItem("Pepperoni", 10.99f))
        )
    }

    fun updateRestaurantRating(rating: Float){
        _restaurants.value = _restaurants.value?.copy(rating= rating)
    }
}