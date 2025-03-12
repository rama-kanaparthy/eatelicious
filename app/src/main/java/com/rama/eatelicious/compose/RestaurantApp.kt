package com.rama.eatelicious.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.rama.eatelicious.R
import com.rama.eatelicious.data.Restaurant


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantApp(){
    val restaurants = remember {
        mutableStateListOf(
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
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Eatelicious",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    restaurants.add(restaurants.random())
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    ) { innerPadding ->
        RestaurantList(
            innerPadding, restaurants
        )
    }
}