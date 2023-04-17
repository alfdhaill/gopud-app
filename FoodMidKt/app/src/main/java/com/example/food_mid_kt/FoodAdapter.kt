package com.example.food_mid_kt

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foods: ArrayList<Food>, private val listener: OnFoodAddedListener) :
    RecyclerView.Adapter<FoodAdapter.FoodVH>() {

    class FoodVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvDesc: TextView = itemView.findViewById(R.id.tv_desc)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_price)
        val ivPic: ImageView = itemView.findViewById(R.id.iv_food)
        val btnAdd: Button = itemView.findViewById(R.id.btn_add)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodVH {

        return FoodVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FoodVH, position: Int) {

        val food: Food = foods[position]

        holder.tvName.text = food.name
        holder.tvDesc.text = food.desc
        holder.tvPrice.text = "Rp " + food.price.toString()
        holder.ivPic.setImageResource(food.pic)

        if (!food.isAdded) {
            holder.btnAdd.isEnabled = true
            holder.btnAdd.text = "add"
        } else {
            holder.btnAdd.isEnabled = false
            holder.btnAdd.text = "added"
        }

        holder.btnAdd.setOnClickListener {

            Toast.makeText(
                holder.itemView.context, food.name + " added to your orders",
                Toast.LENGTH_SHORT
            ).show()

            listener.onFoodAdded(food)

            holder.btnAdd.isEnabled = false
            holder.btnAdd.text = "added"
            food.isAdded = true
        }
    }

    interface OnFoodAddedListener {
        fun onFoodAdded(food: Food)
    }
}