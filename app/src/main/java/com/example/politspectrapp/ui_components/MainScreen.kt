package com.example.politspectrapp.ui_components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.politspectrapp.MainViewModel
import com.example.politspectrapp.utils.DrawerEvents
import com.example.politspectrapp.utils.ListItem
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    topBarTitle: MutableState<String>,
    mainViewModel: MainViewModel = hiltViewModel(),
    onClick: (ListItem) -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val mainList = mainViewModel.mainList
    LaunchedEffect(Unit){
        mainViewModel.getAllItemsByCategory(topBarTitle.value)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MainTopBar(
                title = topBarTitle.value,
                scaffoldState
            )
        },
        drawerContent = {
            DrawerMenu() { event ->
                when (event) {
                    is DrawerEvents.OnItemClick -> {
                        topBarTitle.value = event.title
                        mainViewModel.getAllItemsByCategory(event.title)
                    }
                }
                //Закрытие DrawerMenu
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(mainList.value) { item ->
                MainListItem(item = item) { listItem ->
                    onClick(listItem)
                }
            }
        }
    }
}

//fun getListItemsByIndex(index: Int, context: Context): List<ListItem> {
//    val list = ArrayList<ListItem>()
//    val arrayList = context
//        .resources
//        .getStringArray(IdArray.listId[index])
//    arrayList.forEach { item ->
//        val itemArr = item.split("|")
//        list.add(
//            ListItem(
//                itemArr[0],
//                itemArr[1],
//                itemArr[2]
//            )
//        )
//    }
//    return list
//}