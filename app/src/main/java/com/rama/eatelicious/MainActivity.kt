package com.rama.eatelicious

import android.icu.number.Scale
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rama.eatelicious.Restaurant
import com.rama.eatelicious.ui.theme.EateliciousTheme
import com.rama.eatelicious.ui.theme.Pink40
import com.rama.eatelicious.ui.theme.Purple80

data class Restaurant(val name: String, val tagLine: String, val img: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EateliciousTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RestaurantList(
                        restaurantList
                    )
                }
            }
        }
    }
}

val restaurantList = listOf<Restaurant>(
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

@Composable
fun RestaurantList(restaurants: List<Restaurant>){

    Column(
        verticalArrangement = Arrangement.SpaceAround
    ) {
        for (restaurant in restaurants){
            RestaurantCard(restaurant)
        }
    }

}

@Composable
fun RestaurantCard(restaurant: Restaurant){
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 4.dp,
        color = Color.White,
        modifier = Modifier.fillMaxWidth()
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

@Preview(showBackground = true, name = "restaurantListPreview", showSystemUi = true,
    device = "id:pixel_9_pro", backgroundColor = 0xFF551CB0,
    wallpaper = androidx.compose.ui.tooling.preview.Wallpapers.RED_DOMINATED_EXAMPLE,
    fontScale = 1.0f,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO or android.content.res.Configuration.UI_MODE_TYPE_UNDEFINED
)
@Composable
fun RestaurantListPreview() {
    EateliciousTheme {
        RestaurantList(
            restaurantList
        )
    }
}

@Preview(showBackground = true, name = "restaurantPreview", showSystemUi = true,
    device = "id:pixel_9_pro"
)
@Composable
fun RestaurantPreview() {
    EateliciousTheme {
        RestaurantCard(
            Restaurant("Aaradya5","feel home", R.drawable.restaurant_05)
        )
    }
}