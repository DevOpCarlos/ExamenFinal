package com.carlosflores.examen.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlosflores.examen.Adapters.PerrosAdapter
import com.carlosflores.examen.Databases.AppDatabase
import com.carlosflores.examen.R
import com.carlosflores.examen.Repositories.MainRepository
import com.carlosflores.examen.ViewModels.MainViewModel
import com.carlosflores.examen.ViewModels.MainViewModelFactory
import com.carlosflores.examen.databinding.FragmentPerrosBinding


class PerrosFragment : Fragment() {

    private var _binding : FragmentPerrosBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPerrosBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel : MainViewModel by activityViewModels {
            MainViewModelFactory(MainRepository(AppDatabase.getDatabase(requireContext())))
        }

        val adapter = PerrosAdapter(ArrayList())

        binding.recyclerViewPerros.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPerros.adapter = adapter

        viewModel.getAllPerros().observe(viewLifecycleOwner, { perros ->

            adapter.updatePerros(ArrayList(perros))

        })

        binding.buttonCerrar.setOnClickListener {

            parentFragmentManager.commit {
                remove(this@PerrosFragment)
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null

    }

    companion object {

        @JvmStatic
        fun newInstance() = PerrosFragment()

    }
}