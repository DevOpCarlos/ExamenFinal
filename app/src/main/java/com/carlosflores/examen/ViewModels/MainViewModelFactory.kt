package com.carlosflores.examen.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carlosflores.examen.Repositories.MainRepository

class MainViewModelFactory(private val repo : MainRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {

            return MainViewModel(repo) as T

        }

        throw IllegalArgumentException("Clase de ViewModel desconocida")

    }

}