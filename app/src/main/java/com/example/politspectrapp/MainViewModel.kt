package com.example.politspectrapp


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.politspectrapp.db.MainDb
import com.example.politspectrapp.utils.ListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainDb: MainDb
) : ViewModel() {
    val mainList = mutableStateOf(emptyList<ListItem>())

    fun getAllItemsByCategory(cat: String) = viewModelScope.launch {
        mainDb.dao.getAllItemsByCategory(cat).collect { list ->
            mainList.value = list
        }

        fun insertItem(item: ListItem) = viewModelScope.launch {
            mainDb.dao.insertItem(item)
        }

        fun deleteItem(item: ListItem) = viewModelScope.launch {
            mainDb.dao.deleteItem(item)
        }
    }
}