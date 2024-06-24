package com.example.politspectrapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.politspectrapp.utils.ListItem

@Database(
    entities = [ListItem::class],
    version = 1,
    exportSchema = false
)
abstract class MainDb : RoomDatabase() {
    abstract val dao: Dao
}