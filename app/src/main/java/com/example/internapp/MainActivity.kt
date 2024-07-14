package com.example.internapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.internapp.comp.BusinessContent
import com.example.internapp.comp.CategoryTabRow
import com.example.internapp.comp.DrawerMenu
import com.example.internapp.comp.PersonalContent
import com.example.internapp.comp.ServiceContent
import com.example.internapp.ui.theme.InternAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InternAppTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "Home"
                    ) {
                        composable("Home") { HomeScreen(modifier = Modifier,navController) }
                        composable("Refine") {
                            Refine().refinepage(
                                modifier = Modifier,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(modifier: Modifier,navController:NavController) {
    var search by remember { mutableStateOf("") }


    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val coroutineScope = rememberCoroutineScope()

    val categories = listOf(
        "Personal", "Service", "Business"
    )
    val pagerState = rememberPagerState(pageCount = { categories.size })
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        modifier = modifier.background(White),

        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerShape = RectangleShape) {
                DrawerMenu(modifier = modifier)
            }
        },
    ) {
        Scaffold(
            bottomBar =
            {
                BottomAppBar(
                    containerColor = Color.White,
                    modifier = Modifier.requiredHeight(60.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        BottomNavigationItem(
                            iconId = R.drawable.view,
                            label = "Explore",
                            onClick = { /*TODO*/ }
                        )
                        BottomNavigationItem(
                            iconId = R.drawable.management,
                            label = "Connection",
                            onClick = { /*TODO*/ }
                        )

                        BottomNavigationItem(
                            iconId = R.drawable.chat,
                            label = "Chat",
                            onClick = { /*TODO*/ }
                        )
                        BottomNavigationItem(
                            iconId = R.drawable.contact,
                            label = "Contacts",
                            onClick = { /*TODO*/ }
                        )
                        BottomNavigationItem(
                            iconId = R.drawable.hashtag,
                            label = "Group",
                            onClick = { /*TODO*/ }
                        )
                        // Add more navigation items as needed
                    }
                }
            },
            modifier = modifier,
            topBar = {
                TopAppBar(
                    title = {
                        Column(modifier.padding(5.dp)) {
                            Text(
                                text = "Howdy ADARSH KUMAR !!",
                                fontSize = 15.sp
                            )
                            Row(modifier.padding(3.dp)) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "Location",
                                    modifier.size(18.dp)
                                )
                                Text(text = "Delhi", fontSize = 13.sp)
                            }
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }, modifier.padding(5.dp)) {
                            Icon(
                                painterResource(id = R.drawable.menu),
                                "Menu",
                                tint = Color.White,
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {navController.navigate("Refine") }) {
                            Icon(
                                painterResource(id = R.drawable.refine),
                                "Refine",
                                tint = Color.White,
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF0E2E43),
                        titleContentColor = Color.White
                    )

                )

            }


        ) {
            Column(modifier = modifier.padding(it)) {
                CategoryTabRow(
                    pagerState = pagerState,
                    categories = categories,
                    onTabSelected = { index ->
                        coroutineScope.launch { pagerState.animateScrollToPage(index) }
                    }
                )
                Row(modifier = modifier.padding(10.dp)) {
                    OutlinedTextField(
                        shape = RoundedCornerShape(15.dp),
                        trailingIcon = {
                            if (search.isNotEmpty()) {
                                IconButton(onClick = { search = "" }) {
                                    Icon(Icons.Default.Clear, contentDescription = "clear")
                                }
                            }
                        },
                        leadingIcon = {
                            Icon(Icons.Filled.Search, contentDescription = "search")
                        },
                        value = search,
                        onValueChange = {
                            search = it

                        },
                        label = { Text("Search") },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF0E2E43),
                            cursorColor = Color(0xFF0E2E43),
                            focusedLabelColor = Color(0xFF0E2E43),
                            focusedTextColor = Color(0xFF0E2E43),
                        ),
                        modifier = Modifier
                            .weight(8.5f)
                            .padding(bottom = 8.dp, start = 5.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {

                                keyboardController?.hide()
                                focusManager.clearFocus(force = true)
                            },
                        ),
                    )
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier
                            .weight(1.5f)
                            .padding(top = 8.dp, start = 5.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.sliders),
                            contentDescription = "filter",
                            tint = Color(0xFF0E2E43)
                        )
                    }
                }

                HorizontalPager(state = pagerState) { page ->
                    when (page) {
                        0 -> PersonalContent()
                        1 -> ServiceContent()
                        2 -> BusinessContent()
                    }
                }

            }
        }
    }
}

@Composable
fun BottomNavigationItem(
    iconId: Int,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(8.dp)
            .requiredHeight(60.dp)
    ) {
        IconButton(onClick = onClick, modifier = Modifier.size(40.dp)) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = label,
            color = Color(0xFF0E2E43),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

