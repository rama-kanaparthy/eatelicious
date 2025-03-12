package com.rama.eatelicious.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp


@Composable
fun RestaurantProfile(contentPadding: PaddingValues){

    Card (
        modifier = Modifier.padding(contentPadding).fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.background
        )
    ) {

        var name by remember {
            mutableStateOf("")
        }
        Box(
            modifier = Modifier.padding(16.dp).fillMaxSize()
        ){
            Box(Modifier.fillMaxSize()){
                Column {
                    Box(modifier = Modifier.fillMaxWidth()){
                        if(name.isNotEmpty()){
                            Text(
                                text = name
                            )
                        }
                    }
                    OutlinedTextField(
                        value = name,
                        onValueChange = {
                            name = it
                        },
                        label = {
                            Text("Enter Text")
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }

}