package com.example.politspectrapp.ui_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.politspectrapp.R
import com.example.politspectrapp.ui.theme.BgColor
import com.example.politspectrapp.ui.theme.MainColor
import com.example.politspectrapp.utils.ListItem
import com.example.politspectrapp.utils.Routes
import java.time.format.TextStyle

@Composable
fun PreviewScreen(navController: NavController) {
    val offset = Offset(2.0f, 4.0f)
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.policy),
            contentDescription = "Bg image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.4f
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(200.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Политический справочник",
                    fontSize = 50.sp,
                    color = MainColor,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 24.sp,
                        shadow = Shadow(
                            color = MainColor, offset = offset, blurRadius = 1f
                        )
                    )
                )
            }
            Spacer(Modifier.height(300.dp))
            Button(
                onClick = { navController.navigate(Routes.MAIN_SCREEN) },
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Приступить к изучению",
                    fontSize = 26.sp
                )
            }
        }
    }
}