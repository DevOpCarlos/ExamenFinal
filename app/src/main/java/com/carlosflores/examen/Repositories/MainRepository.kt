package com.carlosflores.examen.Repositories

import com.carlosflores.examen.Databases.AppDatabase
import com.carlosflores.examen.Entities.Perro
import kotlinx.coroutines.flow.Flow

class MainRepository(private val db: AppDatabase) {

    fun insertPerro(perro: Perro) {

        db.PerroDAO().insertPerro(perro)

    }

    fun getAllPerros(): Flow<List<Perro>> {

        return db.PerroDAO().getAllPerros()

    }

}