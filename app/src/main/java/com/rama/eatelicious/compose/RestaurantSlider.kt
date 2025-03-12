package com.rama.eatelicious.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rama.eatelicious.data.Restaurant


@Composable
fun RestaurantSlider(contentPadding: PaddingValues, restaurants: List<Restaurant>){

    var sliderValue by remember { mutableStateOf(0f) }

    Card (
        modifier = Modifier.padding(contentPadding).fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.background
        )
    ){
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
            ){
                Image(
                    painter = painterResource(restaurants[sliderValue.toInt()].img),
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp).align(Alignment.Center).size(350.dp).clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)
            ){
                Text(
                    restaurants[sliderValue.toInt()].name,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                )
            }

            Box(
                modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.BottomCenter)
            ){
                Slider(
                    value = sliderValue,
                    onValueChange = {
                            newValue -> sliderValue = newValue
                    },
                    valueRange = 0f..9f,
                    steps = 10
                )
            }
        }
    }
}
