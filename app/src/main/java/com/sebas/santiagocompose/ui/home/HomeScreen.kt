@file:OptIn(ExperimentalMaterial3Api::class)

package com.sebas.santiagocompose.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.VerticalChainReference
import androidx.hilt.navigation.compose.hiltViewModel
import com.sebas.santiagocompose.repository.network.response.Posts
import com.sebas.santiagocompose.ui.components.buttons.PrimaryButton
import com.sebas.santiagocompose.ui.theme.SantiagoComposeTheme
import java.time.format.TextStyle


@Composable
fun HomeScreen(
    nameUser: String,
    viewmodel: HomeViewmodel = hiltViewModel()
) {
    val uiState  by viewmodel.uiState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(title = {
               Text(text = "Home Screen")
            })
        }
    ) { paddingValues ->
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val (buttonLogOut, lazyColumnPost) = createRefs()

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(lazyColumnPost) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                items(uiState.postList) {
                    PostItem(modifier = Modifier, postItem = it) {
                        viewmodel.getPostDetail(it)
                    }
                }
            }

            
            PrimaryButton(
                textButton = "Cerrar sesiion",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .constrainAs(buttonLogOut) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                
            }
        }
    }
}

@Composable
fun PostItem(
    modifier: Modifier,
    postItem: Posts,
    onClickItem: (String) -> Unit
) {
    Column(
        modifier = modifier.clickable {
            onClickItem(postItem.postId.toString())
        }.fillMaxWidth().height(80.dp).padding(10.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = postItem.title,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = postItem.body,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    SantiagoComposeTheme {
        HomeScreen(nameUser = "Santiago")
    }
}

