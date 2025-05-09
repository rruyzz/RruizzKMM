package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.HomeViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.TabItem
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.tabItems

@Composable
fun HomeHorizontalPager(
    pagerState: PagerState,
    popularMovies: List<Movie>,
    nowPlayingList: List<Movie>,
    topRated: List<Movie>,
    onAboutButtonClick: () -> Unit,
) {
    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues()
    ) { index ->
        when (tabItems[index]) {
            is TabItem.Popular -> MoviesGrid(popularMovies, onAboutButtonClick)
            is TabItem.TopRated -> MoviesGrid(topRated, onAboutButtonClick)
            is TabItem.NowPlaying -> MoviesGrid(nowPlayingList, onAboutButtonClick)
        }
    }
}

@Composable
fun TabRowHome(pagerState: PagerState) {

    var selectedTabIndex by remember { mutableIntStateOf(0) }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }

    TabRow(

        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            if (selectedTabIndex < tabPositions.size) {
                TabRowDefaults.PrimaryIndicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    shape = RoundedCornerShape(
                        topStart = 3.dp,
                        topEnd = 3.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp,
                    ),
                )
            }
        },
    ) {
        tabItems.forEachIndexed { index, item ->
            val isSelected = index == selectedTabIndex
            val color =
                if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.inverseSurface
            Tab(
                selected = isSelected,
                onClick = {
                    selectedTabIndex = index
                },
                text = {
                    Text(text = item.title, color = color)
                },
                selectedContentColor = MaterialTheme.colorScheme.onError
            )
        }
    }
}
