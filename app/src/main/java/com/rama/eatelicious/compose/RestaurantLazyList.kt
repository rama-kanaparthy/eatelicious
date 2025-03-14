package com.rama.eatelicious.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RestaurantLazyList(contentPaddingValues: PaddingValues){

    LazyColumn(
        modifier = Modifier.padding(contentPaddingValues)
    ) {

        // First Item
        item{
            Box(modifier = Modifier.padding(35.dp).fillMaxWidth()){
                Text(
                    text = "First Restaurant"
                )
            }
        }

        // Add 5 times
        items(5){ index ->
            Box(modifier = Modifier.padding(35.dp).fillMaxWidth()){
                Text(
                    text = "Restaurant $index"
                )
            }
        }

        // First Item
        item{
            Box(modifier = Modifier.padding(35.dp).fillMaxWidth()){
                Text(
                    text = "Last Restaurant"
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