package com.dipti.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListActivity : AppCompatActivity() {
    private lateinit var lstView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        lstView = findViewById(R.id.lstView)
//
        var names = intent.getSerializableExtra("data")as ArrayList<Person>

              val adapter = ArrayAdapter(
          this,
           android.R.layout.simple_list_item_1,
            names
              )
        lstView.adapter = adapter
        lstView.setOnItemClickListener{parent,view,position,id ->
            val names = parent.getItemAtPosition(position).toString()

    }
    }
}