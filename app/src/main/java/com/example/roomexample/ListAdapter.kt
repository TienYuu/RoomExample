package com.example.roomexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var list = emptyList<Sinh_vien>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))

    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val current = list[position]
        holder.itemView.findViewById<TextView>(R.id.ten_text).text = current.Name.toString()
        holder.itemView.findViewById<TextView>(R.id.mssv_text).text = current.mssv.toString()
        holder.itemView.findViewById<TextView>(R.id.email_text).text = current.Email.toString()
        holder.itemView.findViewById<LinearLayout>(R.id.row_layout).setOnClickListener {

        }
    }
    fun setData(sinhVien: List<Sinh_vien>) {
        this.list = sinhVien
        notifyDataSetChanged()
    }
}