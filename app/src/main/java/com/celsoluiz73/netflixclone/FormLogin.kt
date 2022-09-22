package com.celsoluiz73.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.celsoluiz73.netflixclone.databinding.ActivityFormLoginBinding
import com.google.firebase.auth.FirebaseAuth

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.tvTelaCadastro.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }

        binding.btnCadastrar.setOnClickListener {
            val email = binding.etxEmailCadastro.text.toString()
            val senha = binding.etxSenhaCadastro.text.toString()
            val mensagemErro = binding.tvInformeEmailSenha
            if (email.isEmpty() || senha.isEmpty()) {
                mensagemErro.setText("Preencha todos os campos!")
            } else {
                autenticarUsuario()
            }
        }
    }

    private fun autenticarUsuario() {
        val email = binding.etxEmailCadastro.text.toString()
        val senha = binding.etxSenhaCadastro.text.toString()
        val mensagemErro = binding.tvInformeEmailSenha

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                irParaTelaFilmes()
            }
        }.addOnFailureListener {
            mensagemErro.setText("Erro ao logar usuário")
        }
    }

    private fun irParaTelaFilmes() {
        val intent = Intent(this, ListaFilmes::class.java)
        startActivity(intent)
        finish()
    }
}