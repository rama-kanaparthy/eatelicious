package com.rama.eatelicious.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rama.eatelicious.MainViewModel


@Composable
fun RestaurantRating(contentPaddingValues: PaddingValues , viewModel: MainViewModel){
    val restaurantState = viewModel.restaurant.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(contentPaddingValues)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
            ) {
                restaurantState.value?.let { restaurant ->
                    Box(
                        modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    ){
                        Image(
                            painter = painterResource(restaurant.img),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.align(Alignment.Center)
                                .clip(RoundedCornerShape(10.dp))
                                .size(350.dp)
                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = restaurant.name,
                                style = MaterialTheme.typography.headlineLarge
                            )
                            Text(
                                text = restaurant.address
                            )
                        }
                    }

                    Spacer(modifier = Modifier.padding(16.dp))

                    Text(
                        text = "Rating: ${restaurant.rating}",
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Spacer(modifier = Modifier.padding(16.dp))

                    Text(
                        text = "Cuisine: ${restaurant.cuisine}"
                    )

                    restaurant.menuItems.forEach{ menuItem ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(
                                text = menuItem.name,
                                style = MaterialTheme.typography.bodySmall
                            )

                            Text(
                                text = "${menuItem.price}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }

                }

                Card(modifier = Modifier.fillMaxWidth().padding(top = 16.dp)) {
                    Column(
                        modifier = Modifier.padding(16.dp).fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        restaurantState.value?.let { restaurant ->
                            RestaurantRatingBar(
                                rating = restaurant.rating,
                                onRatingChanged = {
                                    viewModel.updateRestaurantRating(it)
                                }
                            )

                        }

                    }
                }

            }
        }
    }
}

@Composable
fun RestaurantRatingBar(rating: Float, onRatingChanged: (Float) -> Unit) {
    val currentRating = remember { mutableStateOf(rating) }

    Row {
        RatingBar(
            rating = currentRating,
            onRatingChanged = {
                currentRating.value = it
                onRatingChanged(it)
            }
        )
    }
}

@Composable
fun RatingBar(rating: MutableState<Float>, onRatingChanged: (Float) -> Unit) {
    val maxRating = 5f

    Column {
        Row {
           repeat(maxRating.toInt()) { index ->
               val currentRating = index + 1f
               val isSelected = currentRating <= rating.value
               Icon(
                   imageVector = if(isSelected) Icons.Filled.Star
                   else Icons.Outlined.Star,
                   contentDescription = null,
                   tint = if (isSelected) Color.Yellow else Color.Gray,
                   modifier = Modifier.padding(4.dp)
                       .clickable{
                           onRatingChanged(currentRating)
                       }
               )
           }
        }

        Text(
            text = "${rating.value}"
        )
    }
}