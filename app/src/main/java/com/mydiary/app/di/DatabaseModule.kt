package com.mydiary.app.di

import android.content.Context
import com.mydiary.app.database.DiaryDatabase
import com.mydiary.app.database.DiaryNoteDao
import com.mydiary.app.database.VaultMediaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DiaryDatabase {
        return DiaryDatabase.getDatabase(context)
    }

    @Provides
    fun provideNoteDao(db: DiaryDatabase): DiaryNoteDao = db.diaryNoteDao()

    @Provides
    fun provideVaultMediaDao(db: DiaryDatabase): VaultMediaDao = db.vaultMediaDao()
}
