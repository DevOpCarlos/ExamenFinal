package com.carlosflores.examen.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.carlosflores.examen.Entities.Perro
import com.carlosflores.examen.Repositories.MainRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo: MainRepository) : ViewModel() {

    fun insertPerro(perro: Perro) {

        repo.insertPerro(perro)

    }

    fun getAllPerros(): LiveData<List<Perro>> {

        return repo.getAllPerros().asLiveData(Dispatchers.IO)

    }

}