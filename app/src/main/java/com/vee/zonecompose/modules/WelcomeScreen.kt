package com.vee.zonecompose.modules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vee.zonecompose.modules.home.HomeViewModel

@Composable
fun HomeScreen(name: String, modifier: Modifier = Modifier, homeViewModel: HomeViewModel?) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column {
            toolbar("${homeViewModel?.user?.value}")
            Button(
                onClick = { /*TODO*/ }) {
//                homeViewModel?.encryption()
            }
        }
    }
}

@Composable
fun toolbar(name: String) {
    return Box(modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 12.dp)) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Filled.Menu, "menu",
                modifier = Modifier
                    .size(32.dp),
                tint = Color.White,

                )
            Spacer(modifier = Modifier)
            Text(
                "HI, $name!",
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.weight(1f),
            )
            Icon(
                Icons.Default.AccountCircle, "user",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
            )

        }

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    HomeScreen("Vikesh", homeViewModel = null)
}