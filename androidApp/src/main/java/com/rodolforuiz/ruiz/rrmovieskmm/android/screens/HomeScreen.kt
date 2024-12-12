package com.rodolforuiz.ruiz.rrmovieskmm.android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.components.Carousel
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.components.HomeHorizontalPager
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.components.TabRowHome
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.HomeViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.tabItems
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = getViewModel(),
) {

    val homeState = homeViewModel.homeState.collectAsState()

    Column {
        if (homeState.value.error != null)
            ErrorMessage(homeState.value.error ?: "dsfds")
        if (homeState.value.popularMovies.isNotEmpty())
            HomeView(homeViewModel)
        if (homeState.value.loading) {
            Loader()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: HomeViewModel) {

    val pagerState = rememberPagerState { tabItems.size }

    PullToRefreshBox(
        isRefreshing = viewModel.homeState.value.loading,
        onRefresh = {
            viewModel.refresh()
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Title()
            HomeSearch(viewModel, onQueryChange = { })
            Carousel(viewModel.homeState.value.popularMovies)
            TabRowHome(pagerState)
            HomeHorizontalPager(
                pagerState,
                viewModel.homeState.value.popularMovies,
                viewModel.homeState.value.nowPlayingList,
                viewModel.homeState.value.topRated,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSearch(
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier,
    query: String = "",
    placeholder: String = "",
    onQueryChange: (String) -> Unit
) {
    SearchBar(
        modifier = modifier
            .fillMaxWidth(),
        query = query,
        onQueryChange = {
            onQueryChange(it)
        },
        onSearch = {

        },
        active = false,
        onActiveChange = {},
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.Gray
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        onQueryChange("")
                    },
                tint = Color.Gray
            )
        },
        shape = RoundedCornerShape(16.dp),
        content = {}
    )
}

@Composable
fun Title() {
    Text(
        text = "What do you want to watch?",
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun Loader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary,
        )
    }
}

@Composable
fun ErrorMessage(message: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center)
        )
    }
}