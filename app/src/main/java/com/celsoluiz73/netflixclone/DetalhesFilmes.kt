package com.celsoluiz73.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.celsoluiz73.netflixclone.Adapter.FilmesAdapter
import com.celsoluiz73.netflixclone.Model.addFilmes
import com.celsoluiz73.netflixclone.databinding.ActivityDetalhesFilmesBinding
import com.squareup.picasso.Picasso

class DetalhesFilmes : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        toolbar()

        val recyclerOutrosFilmes = binding.recyclerOutrosFilmes
        recyclerOutrosFilmes.adapter = FilmesAdapter(addFilmes())
        recyclerOutrosFilmes.layoutManager = GridLayoutManager(applicationContext, 3)

        val capaTheWitcher = "https://firebasestorage.googleapis.com/v0/b/netflix-clone-fcf03.appspot.com/o/video.jpg?alt=media&token=ad45a3ad-9fd4-405d-9560-b6db6f179f93"
        Picasso.get().load(capaTheWitcher).fit().into(binding.imgCapa)

        binding.imgPlayVideo.setOnClickListener {
            val intent = Intent(this, Video::class.java)
            startActivity(intent)
        }
    }

    private fun toolbar() {
        val toolbar_detalhes = binding.tbrToolbarDetalhes
        toolbar_detalhes.setNavigationIcon(getDrawable(R.drawable.ic_voltar))
        toolbar_detalhes.setNavigationOnClickListener {
            val intent = Intent(this, ListaFilmes::class.java)
            startActivity(intent)
            finish()
        }
    }
}