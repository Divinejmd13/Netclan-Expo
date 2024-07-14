package com.example.internapp

import android.annotation.SuppressLint
import android.widget.MediaController
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.simulateHotReload
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import kotlinx.coroutines.launch

class Refine {
    @OptIn(
        ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class,
        ExperimentalLayoutApi::class
    )
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun refinepage(modifier: Modifier,navController: NavController) {
        Scaffold(topBar = {
            TopAppBar(
                title = {
                    Text(text = "Refine", color = Color.White)
                },
                navigationIcon = {
                    IconButton(onClick = {
                                         navController.popBackStack()
                    }, modifier.padding(5.dp)) {
                        Icon(
                            Icons.Filled.KeyboardArrowLeft,
                            "back",
                            tint = Color.White,
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0E2E43),
                    titleContentColor = Color.White
                )

            )

        }) {
            val optionlist = arrayOf(
                "Available I Hey Let Us Connect",
                " Away I Stay Discrete And Watch",
                "Busy I Do Not Disturb I Will Catch Up Later",
                "SOS I Emergency! Need Assistance! HELP"
            )
            var sliderPosition by remember { mutableFloatStateOf(0.5f) }
            val focusManager = LocalFocusManager.current
            val keyboardController = LocalSoftwareKeyboardController.current
            var expanded by remember { mutableStateOf(false) }
            var selectedText by remember { mutableStateOf(optionlist[0]) }
            var status by remember {
                mutableStateOf("Hi community! I am open to new connections😊")
            }
            var purposeList by remember {
                mutableStateOf(
                    listOf(
                        "Dating" to false,
                        "Coffee" to true,
                        "Business" to true,
                        "Hobbies" to false,
                        "Music" to false,
                        "Matrimony" to false,
                        "Dining" to false,
                        "Friendship" to true
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() } // This is mandatory
                    ) {
                        keyboardController?.hide()
                        focusManager.clearFocus(force = true)
                    }
            ) {
                Column(modifier.padding(15.dp)) {
                    Text(
                        text = "Select Your Availability",
                        color = Color(0xFF0E2E43),
                        modifier = modifier.padding(horizontal = 8.dp),
                        fontWeight = FontWeight.SemiBold
                    )
                    ExposedDropdownMenuBox(
                        modifier = modifier.align(Alignment.CenterHorizontally),
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        }
                    ) {
                        OutlinedTextField(
                            shape = RoundedCornerShape(10.dp),
                            value = selectedText,
                            onValueChange = {},
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            modifier = Modifier
                                .menuAnchor()
                                .align(Alignment.CenterHorizontally)
                                .padding(5.dp)
                                .fillMaxWidth()

                        )
                        ExposedDropdownMenu(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(horizontal = 15.dp),
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            optionlist.forEach { item ->
                                DropdownMenuItem(
                                    modifier = modifier.fillMaxWidth(),
                                    text = { Text(text = item) },
                                    onClick = {
                                        selectedText = item
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                    Text(
                        text = "Add Your Status",
                        color = Color(0xFF0E2E43),
                        modifier = modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                        fontWeight = FontWeight.SemiBold
                    )
                    OutlinedTextField(
                        shape = RoundedCornerShape(8.dp),
                        value = status,

                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {

                                keyboardController?.hide()
                                focusManager.clearFocus(force = true)
                            },
                        ),
                        modifier = modifier.padding(horizontal = 10.dp),
                        onValueChange = {
                            status = it
                        })
                    Text(
                        text = "Select Hyper local Distance",
                        color = Color(0xFF0E2E43),
                        modifier = modifier.padding(horizontal = 8.dp, vertical = 9.dp),
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(16.dp)) // 16.dp vertical space
                    Column {
                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            Slider(
                                value = sliderPosition,
                                onValueChange = { sliderPosition = it },
                                valueRange = 0f..1f,
                                colors = SliderDefaults.colors(
                                    thumbColor = Color(0xFF0E2E43),
                                    activeTrackColor = Color(0xFF0E2E43),
                                    inactiveTrackColor = Color.LightGray
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )

                            val sliderWidth =
                                380.dp // Adjust this value to the actual width of your slider
                            val sliderPositionPx = sliderPosition * sliderWidth

                            Box(
                                modifier = Modifier
                                    .offset(
                                        x = sliderPositionPx - 15.dp,
                                        y = -20.dp
                                    ) // Adjust for marker width
                                    .width(30.dp)
                                    .height(30.dp)
                                    .background(
                                        Color(0xFF0E2E43),
                                        shape = RoundedCornerShape(15.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = (sliderPosition * 100).toInt().toString(),
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                    Text(
                        text = "Select Purpose",
                        color = Color(0xFF0E2E43),
                        modifier = modifier.padding(horizontal = 8.dp, vertical = 9.dp),
                        fontWeight = FontWeight.SemiBold
                    )
                    FlowRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),

                        ) {
                        purposeList.forEachIndexed { index, (purpose, isActive) ->
                            Button(
                                border = BorderStroke(
                                    width = if (isActive) 1.dp else 0.dp,
                                    color = Color(0xFF133D58),
                                ),
                                onClick = {
                                    val updatedList = purposeList.toMutableList()
                                    updatedList[index] = updatedList[index].copy(second = !isActive)
                                    purposeList = updatedList
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isActive) Color(0xFF133D58) else Color.White
                                ),
                                modifier = Modifier
                                    .padding(horizontal = 5.dp)

                            ) {
                                Text(
                                    text = purpose,
                                    color = if (isActive) Color.White else Color(0xFF133D58),
                                    fontWeight = if (isActive) FontWeight.Bold else androidx.compose.ui.text.font.FontWeight.Normal

                                )
                            }

                        }
                    }
                    Button(
                        onClick = { navController.popBackStack() },
                        modifier = modifier.align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF133D58)
                        )
                    ) {
                        Text(
                            text = "Save & Explore"

                        )
                    }
                }
            }
        }
    }


}