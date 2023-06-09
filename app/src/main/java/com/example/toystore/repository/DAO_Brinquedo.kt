package com.example.toystore.repository

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.example.toystore.model.Brinquedo
import com.example.toystore.model.BrinquedoAdapter
import com.example.toystore.telas.Atualizar
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.MutableData
import com.google.firebase.database.Transaction
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.*
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson

class DAO_Brinquedo(context: Context)
{
    var banco : DatabaseReference
    var listaBrinquedos = ArrayList<Brinquedo>()
    var context : Context
    init {
        this.banco  = Firebase.database.reference
        this.context = context
    }

    fun criarBrinquedo(brinquedo: Brinquedo)
    {
        this.banco.child(brinquedo.codigo.toString()).setValue(brinquedo)
    }

    fun lerBrinquedos(recyclerView: RecyclerView)
    {
        banco.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists())
                {
                    val gson = Gson()
                    for (i in snapshot.children)
                    {
                        val json = gson.toJson(i.value)
                        val brinquedo = gson.fromJson(json, Brinquedo::class.java)
                        listaBrinquedos.add(Brinquedo(brinquedo.codigo, brinquedo.modelo, brinquedo.idade, brinquedo.peso, brinquedo.volume, brinquedo.custo))
                        insereBrinquedosRecyclerView(recyclerView, listaBrinquedos)
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        })
    }

    fun retornaListaBrinquedo() : ArrayList<Brinquedo>{ return listaBrinquedos }

    fun atualizarBrinquedo(brinquedo: Brinquedo)
    {
        val brinquedoRef = banco.child(brinquedo.codigo.toString())
        brinquedoRef.setValue(brinquedo)
    }

    fun deletarBrinquedo(brinquedo: Brinquedo)
    {
        val brinquedoRef = banco.child(brinquedo.codigo.toString())
        brinquedoRef.removeValue()
    }

    fun insereBrinquedosRecyclerView(recyclerView: RecyclerView, listaBrinquedo: ArrayList<Brinquedo>)
    {
        recyclerView.adapter = BrinquedoAdapter(listaBrinquedo, this.context, Intent(this.context, Atualizar::class.java))
    }
}