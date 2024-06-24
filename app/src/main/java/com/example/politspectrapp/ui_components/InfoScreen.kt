package com.example.politspectrapp.ui_components

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.politspectrapp.ui.theme.BgColor
import com.example.politspectrapp.utils.DrawerEvents
import com.example.politspectrapp.utils.ListItem

@Composable
fun InfoScreen(item:  ListItem, onClick: (ListItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Card(
                modifier = Modifier.padding(2.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(BgColor)) {
                    IconButton(modifier = Modifier,
                        onClick = {
                            onClick(item)
                        }) {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Домой"
                        )
                    }
                }

                AssetImage(
                    imageName = item.imageName,
                    contentDescription = item.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                )
            }
            HtmlLoader(htmlName = item.htmlName)
        }
    }
}

@Composable
//Функция для считывания HTML
fun HtmlLoader(htmlName: String) {
    val context = LocalContext.current  //Контекст текущего
    val assetManager = context.assets   //Достаем из папки assets
    val inputStream = assetManager.open("html/$htmlName")   //Поток для получения html
    val size = inputStream.available()  //Определение размера потока
    val buffer = ByteArray(size)    //Буферный массив для записи полученных данных
    inputStream.read(buffer)    //Запись в массив
    val htmlString = String(buffer)

    AndroidView(factory = {
        WebView(it).apply {
            webViewClient = WebViewClient()
            loadData(
                htmlString,
                "text/html",
                "utf-8"
            )
        }
    })
}