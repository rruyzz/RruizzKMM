package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.ErrorMessage
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.HomeSearch
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.HomeView
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.Loader
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.Title
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.components.Carousel
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.components.HomeHorizontalPager
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.components.TabRowHome
import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.DetailViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.model.DetailContent
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.HomeViewModel
import org.koin.androidx.compose.getViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description.components.Grade
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description.components.Toolbar
import kotlinx.coroutines.launch

@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel = getViewModel(),
) {
    val homeState = detailViewModel.detailState.collectAsState()

    Column {
        if (homeState.value.error != null)
            ErrorMessage(homeState.value.error ?: "dsfds")
        if (homeState.value.successState != null)
            DetailView(detailViewModel, homeState.value.successState)
        if (homeState.value.loading) {
            Loader()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(viewModel: DetailViewModel, detailContent: DetailContent?) {

    var isRefreshing by remember { mutableStateOf(false) }

    val onRefresh = {
        isRefreshing = true
        // Simule uma operação de "refresh" com um delay
        kotlinx.coroutines.GlobalScope.launch {
            kotlinx.coroutines.delay(2000)
            isRefreshing = false
        }
    }

    Scaffold(
        topBar = {
            Toolbar(detailContent?.isSaved)
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                SwipeRefresh(
                    state = SwipeRefreshState(isRefreshing),
                    onRefresh = {
                        onRefresh.invoke()
                    }
                ) {
                    Box {

                        Image(
                            painter = rememberAsyncImagePainter(model = detailContent?.backgroundPoster),
                            contentDescription = detailContent?.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                        )
                        Grade(
                            grade = detailContent?.grade ?: "",
                            modifier = Modifier.align(Alignment.BottomEnd)
                        )
                        Row(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(8.dp)
                                .offset(y = 70.dp)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(model = detailContent?.poster),
                                contentDescription = detailContent?.description,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(140.dp)
                            )
                            Text(
                                text = detailContent?.title ?: "sd;lksamd",
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .offset(y = 24.dp)
                                    .padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun DetailPreview() {
    DetailView(
        viewModel = viewModel(),
        detailContent = DetailContent(
            isSaved = true,
            title = "Batman",
            poster = "https://image.tmdb.org/t/p/w500/xSnM4ahmz692msbMTBsfBWHvR3M.jpg",
            backgroundPoster = "https://image.tmdb.org/t/p/w500/zfbjgQE1uSd9wiPTX4VzsLi0rGG.jpg",
            grade = "9.8",
            year = "Batman",
            minute = "Batman",
            gender = "Batman",
            description = "Batman",
        )
    )
}
