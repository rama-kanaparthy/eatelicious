package com.rama.eatelicious.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
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
fun RestaurantDropDown(contentPadding: PaddingValues, restaurants: List<Restaurant>){

    var selectedIndex by remember { mutableStateOf(0) }
    var expanded by remember { mutableStateOf(false) }

    Card (
        modifier = Modifier.padding(contentPadding).fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.background
        )
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
            ){
                Image(
                    painter = painterResource(restaurants[selectedIndex].img),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center).size(350.dp).clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.BottomCenter)
            ){
                Text(
                    restaurants[selectedIndex].name,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.fillMaxWidth()
                        .clickable(onClick = {expanded = true})
                        .padding(top = 8.dp, bottom = 16.dp)
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {expanded = false},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    restaurants.forEachIndexed { index, s ->
                        DropdownMenuItem(
                            onClick = {
                                selectedIndex = index
                                expanded = false
                            },
                            text = {
                                Card (
                                    modifier = Modifier.padding(4.dp).fillMaxWidth(),
                                    colors = CardDefaults.cardColors(
                                        MaterialTheme.colorScheme.background
                                    )
                                ){
                                    Text( text = s.name)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
