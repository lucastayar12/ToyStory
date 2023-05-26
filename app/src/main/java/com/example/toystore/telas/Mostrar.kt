package com.example.toystore.telas

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toystore.R
import com.example.toystore.repository.DAO_Brinquedo

class Mostrar : AppCompatActivity()
{
    private lateinit var rvBrinquedos : RecyclerView
    lateinit var daoBrinquedo : DAO_Brinquedo

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar)
        rvBrinquedos = findViewById(R.id.rv_Brinquedos)
        rvBrinquedos.layoutManager = LinearLayoutManager(this)

        daoBrinquedo = DAO_Brinquedo(this)
        daoBrinquedo.lerBrinquedos(rvBrinquedos)
    }

    fun voltarInicio(View : View){ this.finish()}
}