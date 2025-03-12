package com.rama.eatelicious

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rama.eatelicious.compose.RestaurantSlider
import com.rama.eatelicious.data.Restaurant
import com.rama.eatelicious.ui.theme.EateliciousTheme

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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EateliciousTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HeaderRender()
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HeaderRender(){
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

        ) { innerPadding ->
            RestaurantSlider(
                innerPadding, restaurantList
            )
    }
}

@Preview(showBackground = true, name = "restaurantPreview", showSystemUi = true,
    device = "id:pixel_9_pro"
)
@Composable
fun RestaurantPreview() {
    EateliciousTheme {
        HeaderRender()
    }
}
