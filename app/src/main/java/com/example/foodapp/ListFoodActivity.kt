package com.example.foodapp

import Cache.MySharedPreferense
import adapter.MyAdapter
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_list_food.*

class ListFoodActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdapter
    var ochir: Int? = null
    var rang=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)
        title = "Barcha taomlar"

        MySharedPreferense.init(this)
        val list = MySharedPreferense.obektString
        myAdapter = MyAdapter(this, list)
        list_food.adapter = myAdapter

        list_food.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this, About_foodActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)

        }
        list_food.setOnItemLongClickListener { parent, view, position, id ->
            ochir = position
            if (!rang){
                list_food[position].setBackgroundColor(Color.RED)
            }
            rang=true

            true
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        MySharedPreferense.init(this)
        val list = MySharedPreferense.obektString
        myAdapter = MyAdapter(this, list)
        list_food.adapter = myAdapter

        if (ochir != null) {

            list.removeAt(ochir!!)
            MySharedPreferense.obektString = list
            ochir=null
            rang=false
        }else{
            Toast.makeText(this, "tanlanmagan", Toast.LENGTH_SHORT).show()
        }




        return super.onOptionsItemSelected(item)
    }

}

