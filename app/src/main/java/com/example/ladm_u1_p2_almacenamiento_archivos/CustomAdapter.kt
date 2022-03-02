package com.example.ladm_u1_p2_almacenamiento_archivos

import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.datos1
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.datos2
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.datos3
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.datos4


class CustomAdapter(): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        var v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = datos1[i]
        viewHolder.itemDetail.text = datos2[i]
        viewHolder.itemID.text = datos3[i]
        viewHolder.itemCosto.text = datos4[i]

    }

    override fun getItemCount(): Int {
        return datos1.size
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemTitle: TextView
        var itemDetail: TextView
        var itemCosto: TextView
        var itemID: TextView

        init {
            itemID = itemView.findViewById(R.id.idpedidos)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detal)
            itemCosto = itemView.findViewById(R.id.costo)
        }
    }
}