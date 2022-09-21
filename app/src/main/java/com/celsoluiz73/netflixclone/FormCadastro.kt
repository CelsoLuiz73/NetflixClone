package com.celsoluiz73.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.celsoluiz73.netflixclone.databinding.ActivityFormCadastroBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        //toolbar()

        binding.btnCadastrar.setOnClickListener {

            val email = binding.etxEmailCadastro.text.toString()
            val senha = binding.etxSenhaCadastro.text.toString()
            val mensagemErro = binding.mensagemErro

            if (email.isEmpty() || senha.isEmpty()) {
                mensagemErro.setText("Preencha todos os campos!")
             } else {
                 cadastrarUsuario()
            }
        }
    }

    private fun cadastrarUsuario() {

        val email = binding.etxEmailCadastro.text.toString()
        val senha = binding.etxSenhaCadastro.text.toString()
        val mensagemErro = binding.mensagemErro

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                binding.etxEmailCadastro.setText("")
                binding.etxSenhaCadastro.setText("")
                mensagemErro.setText("")
            }
        }.addOnFailureListener {
            val erro =it
            when {
                erro is FirebaseAuthWeakPasswordException -> mensagemErro.setText("Digite uma senha com no mínimo de 6 caracteres")
                erro is FirebaseAuthUserCollisionException -> mensagemErro.setText("Esta conta já foi cadastrada")
                erro is FirebaseNetworkException -> mensagemErro.setText("Sem conexão com a internet")
                else -> mensagemErro.setText("Erro ao cadastrar usuário")
            }
        }
    }

//    Essa acao foi feita no XML, mas tambem pode ser feita aqui
//    private fun toolbar() {
//        val toolBar = binding.toolbarCadastro
//        toolBar.setBackgroundColor(getColor(R.color.white))
//        toolBar.setNavigationIcon(getDrawable(R.drawable.ic_netflix_official_logo))
//    }
}