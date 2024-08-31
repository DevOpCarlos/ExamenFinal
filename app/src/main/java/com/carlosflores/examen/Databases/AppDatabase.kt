package com.carlosflores.examen.Databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.carlosflores.examen.DAOs.PerroDAO
import com.carlosflores.examen.Entities.Perro

@Database(entities = [Perro::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun PerroDAO() : PerroDAO

    companion object {

        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context : Context) : AppDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "AppDatabase"
                ).build()

                INSTANCE = instance
                instance

            }

        }

    }

}