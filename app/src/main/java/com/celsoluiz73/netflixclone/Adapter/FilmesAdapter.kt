package com.celsoluiz73.netflixclone.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.celsoluiz73.netflixclone.Model.Filmes
import com.celsoluiz73.netflixclone.databinding.ListaFilmesBinding

class FilmesAdapter (val filmes: MutableList<Filmes>): RecyclerView.Adapter<FilmesAdapter.FilmesViewHolder>() {

    //Aqui vou passar para meu adaptador, qual o layout que ele precisa renderizar na nossa lista.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val binding = ListaFilmesBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return FilmesViewHolder(binding)
    }
    //Posição dos itens da nossa lista
    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {
        with(holder) {
            with(filmes[position]) {
                binding.capaFilme.setImageResource(capaFilme)
            }
        }
    }

    override fun getItemCount() = filmes.size

    inner class FilmesViewHolder(val binding: ListaFilmesBinding): RecyclerView.ViewHolder(binding.root) {

    }


}