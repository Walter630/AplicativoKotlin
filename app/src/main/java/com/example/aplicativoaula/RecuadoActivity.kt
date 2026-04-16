package com.example.aplicativoaula

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicativoaula.databinding.ActivityRecuadoBinding

class RecuadoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRecuadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecuadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //chama as funcoes
        configNameUser()
        recuarLogin()

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListeners()
    }

    override fun onClick(p1: View) {
        if (p1.id == R.id.button_voltar_image){
            recuarLogin()
        }
    }
    private fun configNameUser() {
        val sharedPrefs = getSharedPreferences("jogo_prefs", MODE_PRIVATE)
        // nome da main
        val nomeSalvo = sharedPrefs.getString("NOME_USUARIO", "Jogador")

        binding.text2ExibirNome.text = "$nomeSalvo!"
    }
    private fun recuarLogin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    private fun setListeners(){
        binding.buttonVoltarImage.setOnClickListener(this)
    }

}