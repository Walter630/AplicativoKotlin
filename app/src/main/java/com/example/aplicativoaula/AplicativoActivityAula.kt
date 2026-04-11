package com.example.aplicativoaula

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicativoaula.databinding.ActivityAplicativoAulaBinding

class AplicativoActivityAula : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityAplicativoAulaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAplicativoAulaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //chamo as funcoes
        configNameUser()
        gerarObjetoRandom()
        masmorras()

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListeners()
    }

    private fun configNameUser() {
        val sharedPrefs = getSharedPreferences("jogo_prefs", MODE_PRIVATE)
        // nome da main
        val nomeSalvo = sharedPrefs.getString("NOME_USUARIO", "Jogador")

        binding.textExibirNome.text = "Voce Entrou parabens, nao tem mais saida jogador , $nomeSalvo!"

    }

    private fun masmorras() {
        val tiposMasmorras = listOf("Caverna de Cristal da Nanobanana",
            "Masmorra dos Slimes Pixelados",
            "Tumba do Rei Banana-Lote",
            "Castelo Flutuante de Bits",
            "Labirinto do Código Infinito",
            "Santuário da GPU Queimada"
        )
        val masmorraAleatoria = tiposMasmorras.random()

        binding.textMasmorraRandom.text = "Voce entrou na masmorra: $masmorraAleatoria Agora vou ta lascado"
    }
    private fun gerarObjetoRandom() {
        val estiloJogo = listOf("Mago", "morcego", "Lutador", "Guerreiro", "Bruxo")
        val itemAleatorio = estiloJogo.random()
        if (itemAleatorio == "Mago") {
            binding.textObjetoRandom.text = "Jogador sera morte porque se tornou: $itemAleatorio"
        }else{
            binding.textObjetoRandom.text = "Voce se tornou um: $itemAleatorio"
        }

    }

    private fun recuarMasmorra() {
        val text = binding.buttonVoltar.text.toString()

        Toast.makeText(this, "Ta recuando tao cedo??", Toast.LENGTH_LONG).show()
        val intent = Intent(this, RecuadoActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.button_voltar) {
            recuarMasmorra()
        }
    }

    private fun setListeners(){
        binding.buttonVoltar.setOnClickListener(this)
    }
}