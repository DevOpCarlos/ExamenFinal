package com.carlosflores.examen.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlosflores.examen.Entities.Perro
import com.carlosflores.examen.databinding.ItemPerroBinding

class PerrosAdapter(private var perros : ArrayList<Perro>) : RecyclerView.Adapter<PerrosAdapter.ViewHolderPerro>() {

    inner class ViewHolderPerro(val binding : ItemPerroBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(perro: Perro) {

            binding.apply {

                txtId.text = perro.id.toString()
                txtNombrePerro.text = perro.nombre
                txtRazaPerro.text = perro.raza
                txtEdadPerro.text = perro.edad.toString()
                txtSexoPerro.text = perro.sexo.toString()

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPerro {

        val binding = ItemPerroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderPerro(binding)

    }

    override fun onBindViewHolder(holder: ViewHolderPerro, position: Int) {

        holder.bind(perros[position])

    }

    override fun getItemCount(): Int {

        return perros.size

    }

    fun updatePerros(nuevosPerros : ArrayList<Perro>) {

        perros = nuevosPerros
        this.notifyDataSetChanged()

    }

}