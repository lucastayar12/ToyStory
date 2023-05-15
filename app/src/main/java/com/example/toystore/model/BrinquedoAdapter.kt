package com.example.toystore.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.toystore.R
import androidx.recyclerview.widget.RecyclerView

class BrinquedoAdapter(private val brinquedos : List<Brinquedo> ,val context: Context) : RecyclerView.Adapter<BrinquedoAdapter.ViewHolder>()
{
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val modeloBrinquedo : TextView = itemView.findViewById(R.id.tv_Modelo)
        val idadeBrinquedo : TextView = itemView.findViewById(R.id.tv_Idade)
        val pesoBrinquedo : TextView = itemView.findViewById(R.id.tv_Peso)
        val volumeBrinquedo : TextView = itemView.findViewById(R.id.tv_Volume)
        val custoBrinquedo : TextView = itemView.findViewById(R.id.tv_Custo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val item = brinquedos[position]
        holder.modeloBrinquedo.text = "Modelo: " + item.modelo
        holder.idadeBrinquedo.text = "Idade: " + item.idade.toString()
        holder.pesoBrinquedo.text = "Peso: " + item.peso.toString()
        holder.volumeBrinquedo.text = "Volume: " + item.volume.toString()
        holder.custoBrinquedo.text = "Custo: R$ " + item.custo.toString()

    }

    override fun getItemCount(): Int
    {
        return brinquedos.size
    }

}