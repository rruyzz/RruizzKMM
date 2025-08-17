package com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.ErrorMessage
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.home.Loader
import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.DetailViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.model.DetailContent
import org.koin.androidx.compose.getViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description.components.Grade
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description.components.Info
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description.components.Poster
import com.rodolforuiz.ruiz.rrmovieskmm.android.screens.description.components.Toolbar
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie
import kotlinx.coroutines.launch
import org.koin.core.parameter.parametersOf

@Composable
fun DetailScreen(
    movie: Movie
) {
    val detailViewModel: DetailViewModel = getViewModel(parameters = { parametersOf(movie) })
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
                    Column {
                        Header(detailContent = detailContent)
                        Spacer(modifier = Modifier.height(70.dp))
                        Info(detailContent = detailContent)
                        Text(
                            text = "Descrição",
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(16.dp)
                        )
                        Text(
                            text = detailContent.toString(),
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun Header(detailContent: DetailContent?) {
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
        Poster(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp)
                .offset(y = 70.dp),
            detailContent = detailContent
        )
    }
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
