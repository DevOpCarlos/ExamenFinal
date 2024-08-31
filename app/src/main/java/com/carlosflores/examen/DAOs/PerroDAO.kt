package com.carlosflores.examen.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.carlosflores.examen.Entities.Perro
import kotlinx.coroutines.flow.Flow

@Dao
interface PerroDAO {

    @Insert
    fun insertPerro(perro: Perro)

    @Update
    fun updatePerro(perro: Perro)

    @Delete
    fun deletePerro(perro: Perro)

    @Query("""
        SELECT * FROM perro
    """)
    fun getAllPerros() : Flow<List<Perro>>

}