package com.celsoluiz73.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.celsoluiz73.netflixclone.databinding.ActivityFormCadastroBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

//        Essa acao foi feita no XML, mas tambem pode ser feita aqui
//        val toolBar = binding.toolbarCadastro
//        toolBar.setBackgroundColor(getColor(R.color.white))
//        toolBar.setNavigationIcon(getDrawable(R.drawable.ic_netflix_official_logo))


    }
}