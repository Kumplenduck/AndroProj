package com.example.politspectrapp.utils

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

@Entity(tableName = "main"
)
data class ListItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "title")
    @Nonnull
    val title: String,

    @ColumnInfo(name = "imageName")
    @Nonnull
    val imageName: String,

    @ColumnInfo(name = "htmlName")
    @Nonnull
    val htmlName: String,

    @ColumnInfo(name = "category")
    @Nonnull
    val category: String,

    val isFav: Boolean?
)