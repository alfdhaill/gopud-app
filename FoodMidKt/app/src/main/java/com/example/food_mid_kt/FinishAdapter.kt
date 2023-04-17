package com.example.food_mid_kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FinishAdapter(val orders: ArrayList<Food>) : RecyclerView.Adapter<FinishAdapter.FinishVH>() {

    class FinishVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinishVH {

        return FinishVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_payment, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: FinishVH, position: Int) {
        val food: Food = orders[position]

        holder.tvName.text = food.name
        holder.tvPrice.text = "Rp " + food.price.toString()
    }

}