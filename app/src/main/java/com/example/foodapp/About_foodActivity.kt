package com.example.foodapp

import Cache.MySharedPreferense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about_food.*
import kotlinx.android.synthetic.main.item_rv.*
import kotlinx.android.synthetic.main.item_rv.txt_name

class About_foodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_food)
        supportActionBar?.hide()

        MySharedPreferense.init(this)

        val position=intent.getIntExtra("position", 0)
        val list=MySharedPreferense.obektString
        txt_name.text = list[position].name
        txt_food_product.text = list[position].ingredient
        txt_preparation_order.text=list[position].preparationOrder
    }
}