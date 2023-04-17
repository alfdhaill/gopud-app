package com.example.food_mid_kt

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), FoodAdapter.OnFoodAddedListener {

    private val addedFoods = mutableListOf<Food>()
    private lateinit var rvFood: RecyclerView
    private lateinit var tvOrder: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foods = FoodObj.getFoodList()
        val foodAdapter = FoodAdapter(foods, this)
        rvFood = findViewById(R.id.rv_food)
        val btnOrder: Button = findViewById(R.id.btn_order)
        tvOrder = findViewById(R.id.tv_oorders)

        rvFood.setHasFixedSize(true)
        rvFood.layoutManager = LinearLayoutManager(this)
        btnOrder.setOnClickListener {

            if (addedFoods.isEmpty()) {

                Toast.makeText(this, "Add an order", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, OrderActivity::class.java)
                intent.putParcelableArrayListExtra("orders", ArrayList(addedFoods))
                startActivity(intent)
            }
        }

        rvFood.adapter = foodAdapter
    }

    @SuppressLint("SetTextI18n")
    override fun onFoodAdded(food: Food) {

        addedFoods.add(food)

        if (tvOrder.text.toString() == "--") {

            tvOrder.text = food.name
        } else {

            tvOrder.text = tvOrder.text.toString() + ", " + food.name
        }
    }
}