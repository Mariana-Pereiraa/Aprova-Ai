package com.example.aprovaai.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aprovaai.ui.theme.BlueLight
import com.example.aprovaai.R

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(BlueLight)
            .fillMaxSize()
    ){
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.img1_logo),
            contentDescription = "Imagem Logo"
        )
//        Image(
//            modifier = Modifier.align(Alignment.BottomCenter),
//            painter = painterResource(id = R.drawable.bg_splash_screen),
//            contentDescription = "Imagem de fundo"
//        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen()
}