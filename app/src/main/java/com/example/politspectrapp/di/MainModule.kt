package com.example.politspectrapp.di

import android.app.Application
import androidx.room.Room
import com.example.politspectrapp.db.MainDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideMainDb(app: Application): MainDb {
        return Room.databaseBuilder(
            app,
            MainDb::class.java,
            "polit.db"
        ).createFromAsset("db/polit.db").build()
    }
}