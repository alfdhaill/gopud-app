package com.example.food_mid_kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FinishActivity : AppCompatActivity() {

    private lateinit var rvPay: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        rvPay = findViewById(R.id.rv_payment)
        val orders = intent.getParcelableArrayListExtra<Food>("orders") ?: arrayListOf()
        val coupon = intent.getStringExtra("coupon")
        val total = intent.getStringExtra("total")

        val tvTotal: TextView = findViewById(R.id.tv_total)
        val tvCoupon: TextView = findViewById(R.id.tv_coupon)
        val btnNew: Button = findViewById(R.id.btn_new)

        tvTotal.text = "Rp " + total
        tvCoupon.text = coupon

        rvPay.setHasFixedSize(true)
        rvPay.layoutManager = LinearLayoutManager(this)
        rvPay.adapter = FinishAdapter(orders)

        btnNew.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finishAffinity()
        }
    }
}