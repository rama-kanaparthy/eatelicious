package com.rama.eatelicious.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RestaurantCounter(contentPadding: PaddingValues){
    Card (
        modifier = Modifier.padding(contentPadding).fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.background
        )
    ) {

        var counter = rememberSaveable {
            mutableStateOf(0)
        }
        Box(
            modifier = Modifier.padding(16.dp).fillMaxSize()
        ){
            Box(Modifier.fillMaxSize()){
                Column(modifier = Modifier.padding(8.dp)) {
                    Box(modifier = Modifier.fillMaxWidth().wrapContentHeight()){
                        Text(
                            text = counter.value.toString(),
                            modifier = Modifier.padding(8.dp).align(Alignment.Center),
                            fontSize = 96.sp,
                            style = MaterialTheme.typography.displayLarge
                        )
                    }

                    Spacer( modifier = Modifier.weight(1f))

                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly){
                        Button(
                            onClick = {counter.value--},
                            modifier = Modifier.weight(1f).fillMaxWidth()
                        )
                        {
                            Row( verticalAlignment = Alignment.CenterVertically){
                                Icon(
                                    imageVector = Icons.Filled.KeyboardArrowDown,
                                    contentDescription = null,
                                    modifier = Modifier.padding(8.dp)
                                )
                                Text(
                                    "Decrement"
                                )
                            }

                        }

                        Button(
                            onClick = {counter.value++},
                            modifier = Modifier.weight(1f).fillMaxWidth()
                        )
                        {
                            Row( verticalAlignment = Alignment.CenterVertically){
                                Icon(
                                    imageVector = Icons.Filled.KeyboardArrowUp,
                                    contentDescription = null,
                                    modifier = Modifier.padding(8.dp)
                                )
                                Text(
                                    "Increment"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}