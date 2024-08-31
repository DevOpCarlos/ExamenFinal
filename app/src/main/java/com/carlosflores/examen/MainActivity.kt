package com.carlosflores.examen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.carlosflores.examen.Adapters.PerrosAdapter
import com.carlosflores.examen.Databases.AppDatabase
import com.carlosflores.examen.Entities.Perro
import com.carlosflores.examen.Fragments.PerrosFragment
import com.carlosflores.examen.Repositories.MainRepository
import com.carlosflores.examen.ViewModels.MainViewModel
import com.carlosflores.examen.ViewModels.MainViewModelFactory
import com.carlosflores.examen.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val viewModel: MainViewModel by viewModels {
            MainViewModelFactory(MainRepository(AppDatabase.getDatabase(this)))
        }

        binding.buttonIngresarPerro.setOnClickListener {

            if (binding.editTextNombre.text.isNullOrEmpty() || binding.editTextEdad.text.isNullOrEmpty() || binding.editTextRaza.text.isNullOrEmpty() || binding.editTextSexo.text.isNullOrEmpty()) {

                Snackbar.make(binding.root, "Por favor, no deje ningun campo vacio", 1000).show()

            } else {

                lifecycleScope.launch(Dispatchers.IO) {

                    viewModel.insertPerro(
                        Perro(
                            null,
                            binding.editTextNombre.text.toString(),
                            binding.editTextRaza.text.toString(),
                            binding.editTextEdad.text.toString().toInt(),
                            binding.editTextSexo.text.toString().toBoolean()
                        )
                    )

                    withContext(Dispatchers.Main) {

                        Snackbar.make(binding.root, "Perro ingresado correctamente", 1000).show()

                    }

                }

            }

        }

        binding.buttonVerPerros.setOnClickListener {

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<PerrosFragment>(binding.fragmentContainer.id)
            }

        }

    }
}