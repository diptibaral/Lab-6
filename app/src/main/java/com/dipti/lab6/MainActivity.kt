package com.dipti.lab6

import android.content.Intent
import android.location.Address
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var etName :EditText
    private lateinit var etAddress :EditText
    private lateinit var etMobile :EditText
    private lateinit var rdogroup :RadioGroup
    private lateinit var rdomale :RadioButton
    private lateinit var rdofemale :RadioButton
    private lateinit var btnsubmit :Button
    private lateinit var lstView : ListView
    private val persons = arrayListOf<Person>()
    var gender = "";
    var c =0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etAddress = findViewById(R.id.etAddress)
        etMobile = findViewById(R.id.etMobile)
        rdogroup = findViewById(R.id.rdogroup)
//        rdomale = findViewById(R.id.rdomale)
//        rdofemale = findViewById(R.id.rdofemale)
        btnsubmit = findViewById(R.id.btnsubmit)
//        lstView = findViewById(R.id.lstView)



        rdogroup.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.rdomale->gender = "male"
                    R.id.rdofemale->gender = "female"
                }
            }
        })

        btnsubmit.setOnClickListener {
            var person = Person(etName.text.toString(), etAddress.text.toString(), etMobile.text.toString(),gender)
            persons.add(person)
            startActivity(Intent(this,ListActivity::class.java).putExtra("data",persons))
        }

    }
}