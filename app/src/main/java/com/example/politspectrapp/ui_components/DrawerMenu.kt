package com.example.politspectrapp.ui_components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.politspectrapp.R
import com.example.politspectrapp.ui.theme.BgColor
import com.example.politspectrapp.ui.theme.MainColor
import com.example.politspectrapp.utils.DrawerEvents

@Composable
fun DrawerMenu(onEvent: (DrawerEvents) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fon),
            contentDescription = "Bg image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.2f
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Header()
            Body() { drawerEvents ->
                onEvent(drawerEvents)
            }
        }
    }
}

@Composable
fun Header() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, MainColor)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.politic_view),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.75f
            )
            Text(
                text = "Политическая сфера",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MainColor)
                    .padding(10.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun Body(onEvent: (DrawerEvents) -> Unit) {
    val list = stringArrayResource(id = R.array.drawer_list)
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(list) { index, title ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                backgroundColor = BgColor
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onEvent(DrawerEvents.OnItemClick(title, index))
                        }
                        .padding(7.dp)
                        .wrapContentWidth(),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}