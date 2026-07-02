package com.mydiary.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import com.mydiary.app.models.DiaryNote
import com.mydiary.app.models.VaultMedia

import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [DiaryNote::class, VaultMedia::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class DiaryDatabase : RoomDatabase() {

    abstract fun diaryNoteDao(): DiaryNoteDao
    abstract fun vaultMediaDao(): VaultMediaDao

    companion object {
        @Volatile
        private var INSTANCE: DiaryDatabase? = null

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Add new columns to existing diary_notes table
                db.execSQL("ALTER TABLE diary_notes ADD COLUMN backgroundType TEXT NOT NULL DEFAULT 'color'")
                db.execSQL("ALTER TABLE diary_notes ADD COLUMN backgroundValue TEXT NOT NULL DEFAULT '#FFFFFF'")
                db.execSQL("ALTER TABLE diary_notes ADD COLUMN fontFileName TEXT NOT NULL DEFAULT 'default'")
                db.execSQL("ALTER TABLE diary_notes ADD COLUMN isPrivate INTEGER NOT NULL DEFAULT 0")

                // Create the new vault_media table
                db.execSQL("CREATE TABLE IF NOT EXISTS `vault_media` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `originalPath` TEXT NOT NULL, `vaultPath` TEXT NOT NULL, `mediaType` TEXT NOT NULL, `fileName` TEXT NOT NULL, `addedAt` INTEGER NOT NULL)")
            }
        }

        fun getDatabase(context: Context): DiaryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DiaryDatabase::class.java,
                    "diary_database"
                )
                    .addMigrations(MIGRATION_1_2)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
