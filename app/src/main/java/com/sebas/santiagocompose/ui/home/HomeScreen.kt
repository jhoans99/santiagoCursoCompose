@file:OptIn(ExperimentalMaterial3Api::class)

package com.sebas.santiagocompose.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.VerticalChainReference
import com.sebas.santiagocompose.ui.components.buttons.PrimaryButton
import com.sebas.santiagocompose.ui.theme.SantiagoComposeTheme


@Composable
fun HomeScreen(
    nameUser: String,
    onNavigationBack: () -> Unit
) {
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
            val (textName, buttonLogOut) = createRefs()

            Text(
                text = "Bienvenido $nameUser",
                fontSize = 20.sp,
                modifier = Modifier.constrainAs(textName) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            )
             
            PrimaryButton(
                textButton = "Cerrar sesiion",
                modifier = Modifier.fillMaxWidth().padding(10.dp).constrainAs(buttonLogOut) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) {
                
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    SantiagoComposeTheme {
        HomeScreen(nameUser = "Santiago") {
        }
    }
}

