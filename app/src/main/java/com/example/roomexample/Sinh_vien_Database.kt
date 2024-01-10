package com.example.roomexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Sinh_vien::class], version = 1)
abstract class Sinh_vien_Database : RoomDatabase() {
    abstract fun svDao(): Sinh_vien_DAO
    companion object {
        @Volatile
        private var INSTANCE: Sinh_vien_Database? = null;
        fun getDatabase(context: Context): Sinh_vien_Database{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance;
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Sinh_vien_Database::class.java,
                    "sv_database"
                ).build()
                INSTANCE = instance;
                return instance;
            }
        }
    }
}