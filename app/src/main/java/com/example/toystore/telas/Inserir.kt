package com.example.toystore.telas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.toystore.R
import com.example.toystore.model.Brinquedo
import com.example.toystore.repository.DAO_Brinquedo
import com.example.toystore.repository.IndexSingleton

class Inserir : AppCompatActivity()
{
    lateinit var et_Modelo : EditText
    lateinit var et_Idade : EditText
    lateinit var et_Peso : EditText
    lateinit var et_Volume : EditText
    lateinit var et_Custo : EditText
    lateinit var daoBrinquedo : DAO_Brinquedo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserir)
        et_Modelo = findViewById(R.id.et_Modelo)
        et_Idade = findViewById(R.id.et_Idade)
        et_Peso = findViewById(R.id.et_Peso)
        et_Volume = findViewById(R.id.et_Volume)
        et_Custo = findViewById(R.id.et_Custo)
        daoBrinquedo = DAO_Brinquedo(this)
    }

    fun inserirBrinquedo(View: View)
    {
        IndexSingleton.incrementIndex()
        val toy = Brinquedo(IndexSingleton.index , et_Modelo.text.toString(), et_Idade.text.toString().toInt(), et_Peso.text.toString().toFloat(), et_Volume.text.toString().toFloat(), et_Custo.text.toString().toFloat())
        Toast.makeText(this,"$toy", Toast.LENGTH_LONG).show()
        daoBrinquedo.criarBrinquedo(toy)
    }

    fun voltarInicio(View : View){ this.finish()}

}