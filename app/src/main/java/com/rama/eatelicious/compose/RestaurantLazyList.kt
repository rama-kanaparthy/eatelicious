package com.rama.eatelicious.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rama.eatelicious.R
import com.rama.eatelicious.data.Restaurant
import com.rama.eatelicious.repositories.RestaurantRepository
import kotlinx.coroutines.launch


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RestaurantHeaderList(){
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

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.eatelicious),
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
                    coroutineScope.launch {
                        listState.animateScrollToItem(restaurants.size -1)
                    }
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    ) { innerPadding ->
        RestaurantLazyRestaurantList(innerPadding, restaurants,listState)
    }
}


@Composable
fun RestaurantLazyRestaurantList(
    contentPaddingValues: PaddingValues,
    restaurants: List<Restaurant>,
    listState: LazyListState
){

    LazyColumn(
        modifier = Modifier.padding(contentPaddingValues),
        state = listState
    ) {

        restaurants.forEach{ restaurant ->
            item{
                Box(modifier = Modifier.padding(35.dp).fillMaxWidth()){
                    RestaurantCard(restaurant)
                }
            }
        }

    }
}

@Composable
fun RestaurantLazyList(contentPaddingValues: PaddingValues){

    LazyColumn(
        modifier = Modifier.padding(contentPaddingValues)
    ) {

        // First Item
        item{
            Box(modifier = Modifier.padding(35.dp).fillMaxWidth()){
                Text(
                    text = "First Restaurant",
                    fontSize = 20.sp
                )
            }
        }

        // Add 5 times
        items(50){ index ->
            Box(modifier = Modifier.padding(35.dp).fillMaxWidth()){
                Text(
                    text = "Restaurant $index",
                    fontSize = 20.sp
                )
            }
        }

        // First Item
        item{
            Box(modifier = Modifier.padding(35.dp).fillMaxWidth()){
                Text(
                    text = "Last Restaurant",
                    fontSize = 20.sp
                )
            }
        }
    }
}


@Preview(showBackground = true, name = "restaurantPreview", showSystemUi = true,
    device = "id:pixel_9_pro"
)
@Composable
fun RestaurantPreview() {
    Scaffold { innerPadding ->
        RestaurantLazyList(innerPadding)
    }
}