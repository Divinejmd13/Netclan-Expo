package com.example.internapp.comp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internapp.R

@Composable
fun DrawerMenu(modifier: Modifier = Modifier) {
    val selectedCard = remember { mutableStateOf("My Network") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.absmenu),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RectangleShape)
            )

            Column(Modifier.fillMaxSize()) {
                Row(
                    Modifier
                        .padding(start = 25.dp, top = 25.dp)
                        .fillMaxWidth()
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clip(CircleShape)
                            .size(80.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.profile), contentDescription = "")
                    }
                }
                Text(
                    text = "Adarsh Kumar",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 25.dp, top = 10.dp)
                )
                Text(
                    text = "ADDELHifObbu",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 25.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.TopEnd)) {
                Icon(Icons.Default.Settings, contentDescription = "settings")
            }
        }

        val cardList = listOf(
            "My Profile" to R.drawable.person,
            "My Network" to R.drawable.people,
            "Switch to Services" to R.drawable.briefcase,
            "Switch to Businesses" to R.drawable.window,
            "Dating" to R.drawable.heart,
            "Matrimony" to R.drawable.mate,
            "Buy-Sell-Rent" to R.drawable.busell,
            "Business Cards" to R.drawable.briefcase,
            "Netclan Groups" to R.drawable.hashtag,
            "Notes" to R.drawable.hash,
            "Live Locations" to R.drawable.locaton
        )

        cardList.forEach { (text, id) ->
            card(
                id = id,
                onClick = { selectedCard.value = text },
                text = text,
                selected = selectedCard.value == text
            )
        }
    }
}

@Composable
fun card(modifier: Modifier = Modifier, id: Int, onClick: () -> Unit, text: String, selected: Boolean) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        Button(
            shape = RoundedCornerShape(10.dp),
            onClick = onClick,
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (selected) {
                    Color(0xFFD9DDE0)
                } else {
                    Color.White
                }
            )
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = id),
                    modifier = Modifier
                        .size(50.dp)
                        .padding(top = 6.dp),
                    contentDescription = "",
                    tint = Color(0xFF133C57)
                )
                Text(
                    text = text,
                    color = Color(0xFF0E2E43),
                    modifier = Modifier.padding(5.dp),
                    fontSize = 18.sp
                )
            }
        }
    }
}
