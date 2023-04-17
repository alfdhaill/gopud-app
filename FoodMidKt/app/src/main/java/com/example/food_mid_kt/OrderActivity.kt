package com.example.food_mid_kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrderActivity : AppCompatActivity() {

    private lateinit var rvOrder: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        rvOrder = findViewById(R.id.rv_order)
        val orders = intent.getParcelableArrayListExtra<Food>("orders") ?: arrayListOf()
        val btnDisc20: Button = findViewById(R.id.btn_disc20)
        val btnDisc50: Button = findViewById(R.id.btn_disc50)
        val btnDisc75: Button = findViewById(R.id.btn_disc75)
        val btn5k : Button = findViewById(R.id.btn_5000)
        val btn10k : Button = findViewById(R.id.btn_10000)
        val btn20k : Button = findViewById(R.id.btn_20000)
        val tvSub: TextView = findViewById(R.id.tv_subtotal)
        val tvTotal: TextView = findViewById(R.id.tv_total)
        val btnPay: Button = findViewById(R.id.btn_pay)
        val tvCoupon: TextView = findViewById(R.id.tv_coupon)

        var subtotal = orders.sumOf { it.price }
        var total = orders.sumOf { it.price }
        tvSub.text = "Rp " + subtotal.toString()

        rvOrder.setHasFixedSize(true)
        rvOrder.layoutManager = LinearLayoutManager(this)
        rvOrder.adapter = OrderAdapter(orders)

        tvTotal.text = "Rp " + total.toString()

        btnDisc20.setOnClickListener {

            subtotal = orders.sumOf { it.price }

            total = subtotal - (subtotal * 0.2).toInt()
            tvTotal.text = "Rp " + total.toString()
            tvCoupon.text = "Discount 20%"
        }

        btnDisc50.setOnClickListener {

            subtotal = orders.sumOf { it.price }

            total = subtotal - (subtotal * 0.5).toInt()
            tvTotal.text = "Rp " + total.toString()
            tvCoupon.text = "Discount 50%"
        }

        btnDisc75.setOnClickListener {

            subtotal = orders.sumOf { it.price }

            total = subtotal - (subtotal * 0.75).toInt()
            tvTotal.text = "Rp " + total.toString()
            tvCoupon.text = "Discount 75%"
        }

        btn5k.setOnClickListener {

            subtotal = orders.sumOf { it.price }

            total = subtotal - 5000

            if (total < 0) {

                total = 0
                tvTotal.text = "Rp " + total.toString()
            } else {

                tvTotal.text = "Rp " + total.toString()
            }

            tvCoupon.text = "-5000"
        }

        btn10k.setOnClickListener {

            subtotal = orders.sumOf { it.price }

            total = subtotal - 10000

            if (total < 0) {

                total = 0
                tvTotal.text = "Rp " + total.toString()
            } else {

                tvTotal.text = "Rp " + total.toString()
            }

            tvCoupon.text = "-10000"
        }

        btn20k.setOnClickListener {

            subtotal = orders.sumOf { it.price }

            total = subtotal - 20000

            if (total < 0) {

                total = 0
                tvTotal.text = "Rp " + total.toString()
            } else {

                tvTotal.text = "Rp " + total.toString()
            }

            tvCoupon.text = "-20000"
        }

        btnPay.setOnClickListener {

            val intent = Intent(this, FinishActivity::class.java)

            intent.putExtra("total", total.toString())
            intent.putExtra("orders", orders)
            intent.putExtra("coupon", tvCoupon.text.toString())

            startActivity(intent)
        }
    }
}