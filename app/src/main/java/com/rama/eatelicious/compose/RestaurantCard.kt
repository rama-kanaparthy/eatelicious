package com.rama.eatelicious.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rama.eatelicious.R
import com.rama.eatelicious.data.Restaurant
import com.rama.eatelicious.ui.theme.EateliciousTheme
import com.rama.eatelicious.ui.theme.Purple80


@Composable
fun RestaurantCard(restaurant: Restaurant){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = CutCornerShape(
            20.dp
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            Color.White
        )
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(painter = painterResource(restaurant.img),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        shape = CircleShape,
                        color = Purple80
                    ),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.padding(8.dp))

            Column {
                Text(
                    restaurant.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 8.dp, start =8.dp, bottom = 2.dp , end = 8.dp)
                )

                Spacer(Modifier.padding(4.dp))

                Text(
                    restaurant.tagLine,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 2.dp, start =8.dp, bottom = 8.dp , end = 8.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true, name = "restaurantPreview", showSystemUi = true,
    device = "id:pixel_9_pro"
)
@Composable
fun RestaurantCardPreview() {
    EateliciousTheme {
        RestaurantCard(Restaurant("Aaradya1","feel home", R.drawable.restaurant_01))
    }
}