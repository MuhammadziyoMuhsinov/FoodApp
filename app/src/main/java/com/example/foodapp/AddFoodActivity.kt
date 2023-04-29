package com.example.foodapp

import Cache.MySharedPreferense
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_food.*
import kotlinx.android.synthetic.main.activity_main.*
import models.Food

class AddFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)
        title = "Taom qo'shish"

        MySharedPreferense.init(this)

        btn_save.setOnClickListener {

            val name = edt_food_name.text.toString().trim()
            val product = edt_food_products.text.toString().trim()
            val preparationOrder = edt_preparation_order.text.toString().trim()

            if (name != "" && product != "" && preparationOrder != "") {
                val list = MySharedPreferense.obektString
                list.add(Food(name, product, preparationOrder))
                MySharedPreferense.obektString=list
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                finish()

            } else {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            }
        }

    }
}