package com.example.aplicativoaula

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java
import com.example.aplicativoaula.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListeners()
    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.button_save){
            handler_okay()
        }
    }

    private fun handler_okay() {
        val name = binding.nameText.text.toString()

        if (name.isEmpty()){
            Toast.makeText(this, "Cara faltou umas coisas ai", Toast.LENGTH_SHORT).show()
        } else {
            // guardo a referencia
            val sharedPrefs = getSharedPreferences("jogo_prefs", MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.putString("NOME_USUARIO", name)
            editor.apply() // salvo o nome

            val intent = Intent(this, AplicativoActivityAula::class.java)
            startActivity(intent)
        }
    }
    private fun setListeners(){
        binding.buttonSave.setOnClickListener(this)
    }


}