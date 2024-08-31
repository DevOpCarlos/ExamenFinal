package com.carlosflores.examen.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Perro(

    @PrimaryKey
    var id : Int?,

    @ColumnInfo(name = "nombre")
    var nombre : String,

    @ColumnInfo(name = "raza")
    var raza : String,

    @ColumnInfo(name = "edad")
    var edad : Int,

    @ColumnInfo(name = "sexo")
    var sexo : Boolean

)
