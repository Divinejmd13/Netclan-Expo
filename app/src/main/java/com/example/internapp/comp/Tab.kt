package com.example.internapp.comp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryTabRow(
    pagerState: PagerState,
    categories: List<String>,
    onTabSelected: (Int) -> Unit
) {
    TabRow(
        modifier = Modifier.fillMaxWidth(),
        selectedTabIndex = pagerState.currentPage,
        containerColor = Color(0xFF133D59),
//        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                color = Color.White
            )
        }
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { onTabSelected(index) },
                content = {
                    Text(
                        color = if(pagerState.currentPage == index){ Color.White }else{
                            Color.Gray},
                        text = category,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp)
                    )
                }
            )
        }
    }
}
