package com.example.toystore.telas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toystore.R
import com.example.toystore.model.Brinquedo
import com.example.toystore.model.BrinquedoAdapter
import com.example.toystore.repository.DAO_Brinquedo

class Mostrar : AppCompatActivity()
{
    private lateinit var rv_Brinquedos : RecyclerView
    lateinit var daoBrinquedo : DAO_Brinquedo

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar)
        rv_Brinquedos = findViewById(R.id.rv_Brinquedos)
        rv_Brinquedos.layoutManager = LinearLayoutManager(this)

        daoBrinquedo = DAO_Brinquedo(this)
        daoBrinquedo.lerBrinquedos(rv_Brinquedos)

    }

    fun atualizarBrinquedo(View: View){  }



    fun voltarInicio(View : View){ this.finish()}
}