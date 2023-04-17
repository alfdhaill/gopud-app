package com.example.food_mid_kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter(val orders: ArrayList<Food>) : RecyclerView.Adapter<OrderAdapter.OrderVH>() {

    class OrderVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_price)
        val ivPic: ImageView = itemView.findViewById(R.id.iv_food)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderVH {
        return OrderVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: OrderVH, position: Int) {
        val food: Food = orders[position]

        holder.tvName.text = food.name
        holder.tvPrice.text = "Rp " + food.price.toString()
        holder.ivPic.setImageResource(food.pic)
    }

}