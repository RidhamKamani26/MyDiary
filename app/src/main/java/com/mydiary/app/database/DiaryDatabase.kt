package com.mydiary.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mydiary.app.models.DiaryNote
import com.mydiary.app.models.VaultMedia

@Database(
    entities = [DiaryNote::class, VaultMedia::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class DiaryDatabase : RoomDatabase() {

    abstract fun diaryNoteDao(): DiaryNoteDao
    abstract fun vaultMediaDao(): VaultMediaDao

    companion object {
        @Volatile
        private var INSTANCE: DiaryDatabase? = null

        fun getDatabase(context: Context): DiaryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DiaryDatabase::class.java,
                    "diary_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
