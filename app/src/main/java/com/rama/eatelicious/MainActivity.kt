package com.rama.eatelicious

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rama.eatelicious.ui.theme.EateliciousTheme
import com.rama.eatelicious.ui.theme.Purple80

data class Restaurant(val name: String, val tagLine: String, val img: Int)

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
fun RestaurantCounter(contentPadding: PaddingValues){
    Card (
        modifier = Modifier.padding(contentPadding).fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.background
        )
    ) {

        var counter = remember {
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
        RestaurantCounter(
            innerPadding
        )
    }
}

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantApp(){
    val restaurants = remember {
        mutableStateListOf(
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
    }
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
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    restaurants.add(restaurants.random())
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    ) { innerPadding ->
        RestaurantList(
            innerPadding, restaurants
        )
    }
}

@Composable
fun RestaurantList(contentPadding: PaddingValues, restaurants: List<Restaurant>){

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.padding(contentPadding)
            .verticalScroll(rememberScrollState())
    ) {
        for (restaurant in restaurants){
            RestaurantCard(restaurant)
        }
    }

}

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
/*

@Preview(showBackground = true, name = "restaurantListPreview", showSystemUi = true,
    device = "id:pixel_9_pro", backgroundColor = 0xFF551CB0,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    fontScale = 1.0f,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_UNDEFINED
)

@Composable
fun RestaurantListPreview() {
    EateliciousTheme {
        Scaffold { innerPadding ->
            RestaurantList(
                innerPadding, restaurantList
            )
        }
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
}*/
