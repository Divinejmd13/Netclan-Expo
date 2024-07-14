package com.example.internapp.comp

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internapp.R

@Composable
fun BusinessContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        BussinessProfileCard(
            companyName = "Kevin'S Auto Repair",
            location = "Mountain View",
            distance = "within 700-800 m",
            profileScore = "75%",
            message = "Hi community! We have great deals for you. Check us out!!"
        )

        BussinessProfileCard(
            companyName = "Tech Innovators",
            location = "San Francisco",
            distance = "within 5 km",
            profileScore = "85%",
            message = "Bringing the future of technology to your doorstep."
        )

        BussinessProfileCard(
            companyName = "Healthy Eats",
            location = "Los Angeles",
            distance = "within 2 km",
            profileScore = "90%",
            message = "Delicious and healthy meals delivered fast."
        )

        BussinessProfileCard(
            companyName = "Creative Designs",
            location = "New York City",
            distance = "within 3 km",
            profileScore = "70%",
            message = "Turning your ideas into stunning visuals."
        )

        BussinessProfileCard(
            companyName = "Green Earth Landscaping",
            location = "Seattle",
            distance = "within 1 km",
            profileScore = "60%",
            message = "Transforming your outdoor spaces beautifully."
        )

        BussinessProfileCard(
            companyName = "Fitness First Gym",
            location = "Boston",
            distance = "within 500 m",
            profileScore = "95%",
            message = "Join us for the ultimate fitness experience."
        )

        BussinessProfileCard(
            companyName = "Book Haven",
            location = "Chicago",
            distance = "within 1.5 km",
            profileScore = "80%",
            message = "A paradise for book lovers. Visit us today!"
        )

        BussinessProfileCard(
            companyName = "Digital Marketing Pros",
            location = "Austin",
            distance = "within 4 km",
            profileScore = "88%",
            message = "Expert marketing services to boost your business."
        )

        BussinessProfileCard(
            companyName = "Pet Paradise",
            location = "Miami",
            distance = "within 1 km",
            profileScore = "65%",
            message = "Your pet's home away from home."
        )

        BussinessProfileCard(
            companyName = "Elegant Events",
            location = "Las Vegas",
            distance = "within 3.5 km",
            profileScore = "92%",
            message = "Creating unforgettable experiences for you."
        )
    }
}

@Composable
fun BussinessProfileCard(
    modifier: Modifier = Modifier,
    companyName: String,
    location: String,
    distance: String,
    profileScore: String,
    message: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(width = 3.dp, color = Color(0xFFDFECF4), shape = RoundedCornerShape(10.dp))
        ,
        shape = RoundedCornerShape(8.dp),
//        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = companyName.take(1),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.size(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = companyName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "$location, $distance",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.size(8.dp))

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE0F7FA),
                        contentColor = Color(0xFF0E2E43)
                    ),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "+ INVITE", fontSize = 12.sp)
                }
            }

            Spacer(modifier = Modifier.size(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                LinearProgressIndicator(
                    progress = profileScore.dropLast(1).toFloat() / 100,
                    trackColor = Color.LightGray,
                    color = Color.Gray,
                    modifier = modifier
                        .weight(1f)
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = "Profile Score - $profileScore",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.size(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call Icon",
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Location Icon",
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location Icon",
                    modifier = Modifier.size(24.dp)
                )
                // Add more icons if needed
            }

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = message,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
@Preview
fun PreviewCompanyBussinessCard() {
    BussinessProfileCard(
        companyName = "Kevin'S Auto Repair",
        location = "Mountain View",
        distance = "within 700-800 m",
        profileScore = "75%",
        message = "Hi community! We have great deals for you. Check us out!!"
    )
}
