package com.example.politspectrapp.ui_components

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ScaffoldState
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.politspectrapp.ui.theme.BgColor
import kotlinx.coroutines.launch

@Composable
fun MainTopBar(title: String, scaffoldState: ScaffoldState) {
    val coroutine = rememberCoroutineScope()

    TopAppBar(title = {
        Text(text = title)
    },
        backgroundColor = BgColor,
        navigationIcon = {
            IconButton(onClick = {
                coroutine.launch {
                    scaffoldState.drawerState.open()
                }
            }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            }
        }
    )
}