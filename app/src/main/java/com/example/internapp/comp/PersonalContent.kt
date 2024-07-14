package com.example.internapp.comp

import android.widget.ProgressBar
import androidx.compose.runtime.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.Dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UserProfileCard(
    modifier: Modifier = Modifier,
    name: String,
    location: String,
    jobTitle: String,
    distance: String,
    profileScore: String,
    interests: List<String>,
    message: String,
    status: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp).border(width = 3.dp, color = Color(0xFFDFECF4), shape = RoundedCornerShape(10.dp)),
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
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFB7C4CC)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = name.split(" ").map { it.first() }.joinToString(""),
                        color = Color(0xFF133D59),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.size(8.dp))

                Column {
                    Text(
                        text = name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "$location | $jobTitle",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = distance,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.weight(2f))

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFFFFF),
                        contentColor = Color(0xFF0E2E43)
                    ),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 3.dp),
                    shape = RoundedCornerShape(20.dp),
                    modifier = modifier.offset(y=(-15).dp)
                ) {
                    Text(text = "+ INVITE", fontSize = 12.sp)
                }
            }

            Spacer(modifier = Modifier.size(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                LinearProgressIndicator(progress = profileScore.dropLast(1).toFloat() / 100,
                    trackColor = Color.LightGray,
                    color = Color.Gray,
                    modifier=modifier.clip(RoundedCornerShape(5.dp)))

                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = "Profile Score - $profileScore",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.size(8.dp))

            Row {
                interests.forEach { interest ->
                    Text(
                        text = interest,
                        color = Color(0xFF301C04),
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .background(
                                color = Color(0xFFE0F7FA),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = message,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = status,
                fontSize = 12.sp,
                color = Color(0xFF42647A)
            )
        }
    }
}
@Composable
fun PersonalContent(){
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        UserProfileCard(
            name = "Gokul Raj",
            location = "Bengaluru",
            jobTitle = "Software Test Engineer",
            distance = "Within 100 m",
            profileScore = "58%",
            interests = listOf("Coffee", "Business", "Friendship"),
            message = "Hi community! I am open to new connections 😊",
            status = "Active"
        )

        UserProfileCard(
            name = "Aarav Mehta",
            location = "Mumbai",
            jobTitle = "Data Scientist",
            distance = "Within 200 m",
            profileScore = "72%",
            interests = listOf("AI", "Machine Learning", "Networking"),
            message = "Excited to meet like-minded professionals!",
            status = "Online"
        )

        UserProfileCard(
            name = "Priya Singh",
            location = "Delhi",
            jobTitle = "Graphic Designer",
            distance = "Within 500 m",
            profileScore = "64%",
            interests = listOf("Design", "Art", "Creativity"),
            message = "Let's collaborate on creative projects!",
            status = "Active"
        )

        UserProfileCard(
            name = "Rahul Sharma",
            location = "Hyderabad",
            jobTitle = "DevOps Engineer",
            distance = "Within 300 m",
            profileScore = "81%",
            interests = listOf("Cloud", "DevOps", "Automation"),
            message = "Looking forward to sharing DevOps tips!",
            status = "Busy"
        )

        UserProfileCard(
            name = "Ananya Patel",
            location = "Pune",
            jobTitle = "Content Writer",
            distance = "Within 400 m",
            profileScore = "69%",
            interests = listOf("Writing", "Blogging", "Travel"),
            message = "Always up for a good conversation!",
            status = "Available"
        )

        UserProfileCard(
            name = "Vikram Joshi",
            location = "Chennai",
            jobTitle = "Product Manager",
            distance = "Within 150 m",
            profileScore = "77%",
            interests = listOf("Product Management", "Startups", "Leadership"),
            message = "Let's discuss product strategies!",
            status = "Online"
        )
    }
}
@Composable
@Preview
fun PreviewUserProfileCard() {
    UserProfileCard(
        name = "Gokul Raj",
        location = "Bengaluru",
        jobTitle = "Software Test Engineer",
        distance = "Within 100 m",
        profileScore = "58%",
        interests = listOf("Coffee", "Business", "Friendship"),
        message = "Hi community! I am open to new connections 😊",
        status = "Active"
    )
}
