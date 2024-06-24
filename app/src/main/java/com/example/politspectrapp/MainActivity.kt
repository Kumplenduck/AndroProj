package com.example.politspectrapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.politspectrapp.ui.theme.PolitSpectrAppTheme
import com.example.politspectrapp.ui_components.InfoScreen
import com.example.politspectrapp.ui_components.MainScreen
import com.example.politspectrapp.ui_components.PreviewScreen
import com.example.politspectrapp.utils.ListItem
import com.example.politspectrapp.utils.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Для работы с навигацией
            val navController = rememberNavController()

            val topBarTitle = remember {
                mutableStateOf("Политическая сфера")
            }

            var item: ListItem? = null

            PolitSpectrAppTheme {
                NavHost(
                    navController = navController,
                    startDestination = Routes.PREVIEW_SCREEN
                ) {
                    composable(Routes.PREVIEW_SCREEN) {
                        PreviewScreen(navController = navController)
                    }
                    composable(Routes.MAIN_SCREEN) {
                        MainScreen(topBarTitle) { listItem ->
                            item = listItem
                            navController.navigate(Routes.INFO_SCREEN)
                        }
                    }
                    composable(Routes.INFO_SCREEN) {
                        InfoScreen(item = item!!){
                            navController.navigate(Routes.MAIN_SCREEN) }
                    }
                }
            }
        }
    }
}





