package com.example.internapp.comp

import androidx.compose.runtime.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.example.internapp.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun ServiceContent(){
    Column(modifier = Modifier.fillMaxSize()) {
        CompanyProfileCard(
            companyName = "Highering Talent India Hire With...",
            location = "New Delhi",
            distance = "within 15.4 KM",
            profileScore = "50%",
            role = "Entrepreneur",
            experience = "10",
            message = "Hi community! I am available at your service!"
        )
    }
}

@Composable
fun CompanyProfileCard(
    modifier: Modifier = Modifier,
    companyName: String,
    location: String,
    distance: String,
    profileScore: String,
    role: String,
    experience: String,
    message: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),

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

                Column(modifier.weight(10f)) {
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

                Spacer(modifier = Modifier.weight(1f))

                Button(
//                    modifier=modifier.weight(5f),
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
                Icon(
                    Icons.Filled.Call,
                    contentDescription = "Call Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Icon(
                     Icons.Filled.Person,
                    contentDescription = "Message Icon",
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = "$role | $experience years of experience",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

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
fun PreviewCompanyProfileCard() {
    CompanyProfileCard(
        companyName = "Highering Talent India Hire With...",
        location = "New Delhi",
        distance = "within 15.4 KM",
        profileScore = "50%",
        role = "Entrepreneur",
        experience = "10",
        message = "Hi community! I am available at your service!"
    )
}
