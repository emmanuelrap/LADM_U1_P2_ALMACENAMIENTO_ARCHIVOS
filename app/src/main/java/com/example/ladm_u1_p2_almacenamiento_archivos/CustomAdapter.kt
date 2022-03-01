package com.example.ladm_u1_p2_almacenamiento_archivos

import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.informacion1
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.informacion2
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.informacion3
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.informacion4


class CustomAdapter(): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    val titles = arrayOf("Carlos", "Emmanuel", "Zambrano","Cortez")

    val details = arrayOf("1","2","3","4")

    val details2 = arrayOf("1","2","3","4")

    val images = intArrayOf(R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground)


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        var v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = informacion1[i]
        viewHolder.itemDetail.text = informacion2[i]
        viewHolder.itemID.text = informacion3[i]
        viewHolder.itemMesa.text = informacion4[i]

    }

    override fun getItemCount(): Int {
        return informacion1.size
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemID: TextView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemMesa: TextView
        init {
            itemID = itemView.findViewById(R.id.et1)
            itemTitle = itemView.findViewById(R.id.et2)
            itemDetail = itemView.findViewById(R.id.et3)
            itemMesa = itemView.findViewById(R.id.et4)
        }
    }
}
