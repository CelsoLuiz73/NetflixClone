package com.celsoluiz73.netflixclone.Model

import com.celsoluiz73.netflixclone.R

data class Filmes (
    //Essa variável vai ser do tipo Int, porque é uma imagem, nesse caso como vamos trabalhar com dados falsos,
    //os dados vão estar dentro do Android Studio, as nossas imagens, elas vão ser do tipo inteira.
    //Se os arquivos viessem de uma API seria do tipo String.
    val capaFilme: Int
)

class FilmesBuilder {
    var capaFilmeBuilder: Int = 0
    fun build(): Filmes = Filmes(capaFilmeBuilder)
}

fun filmes(block: FilmesBuilder.() -> Unit): Filmes = FilmesBuilder().apply(block).build()

//Criar os itens da lista
fun addFilmes(): MutableList<Filmes> = mutableListOf(

    filmes {
        capaFilmeBuilder = R.drawable.filme1
    },

    filmes {
        capaFilmeBuilder = R.drawable.filme2
    },

    filmes {
        capaFilmeBuilder = R.drawable.filme3
    },

    filmes {
        capaFilmeBuilder = R.drawable.filme4
    },

    filmes {
        capaFilmeBuilder = R.drawable.filme5
    },

    filmes {
        capaFilmeBuilder = R.drawable.filme6
    },

    filmes {
        capaFilmeBuilder = R.drawable.filme7
    },

    filmes {
        capaFilmeBuilder = R.drawable.filme8
    },

    filmes {
        capaFilmeBuilder = R.drawable.filme9
    },

    filmes {
        capaFilmeBuilder = R.drawable.filme10
    },

    filmes {
        capaFilmeBuilder = R.drawable.filme11
    },

    filmes {
        capaFilmeBuilder = R.drawable.filme12
    }

)