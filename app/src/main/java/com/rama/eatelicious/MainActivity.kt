package com.rama.eatelicious

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rama.eatelicious.ui.theme.EateliciousTheme
import com.rama.eatelicious.ui.theme.Pink40
import com.rama.eatelicious.ui.theme.Purple80

data class Restaurant(val name: String, val tagLine: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EateliciousTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RestaurantCard(
                        Restaurant("Aaradya","feel home")
                    )
                }
            }
        }
    }
}

@Composable
fun RestaurantCard(restaurant: Restaurant){
    Column {
        Text(
            restaurant.name,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 32.dp, start =32.dp, bottom = 2.dp , end = 32.dp)
        )
        Text(
            restaurant.tagLine,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 2.dp, start =32.dp, bottom = 32.dp , end = 32.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EateliciousTheme {
        RestaurantCard(
            Restaurant("Aaradya","feel home")
        )
    }
}