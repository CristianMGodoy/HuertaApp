package com.example.huertaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        getData()
        val BtnRegion = findViewById<ImageButton>(R.id.BtnRegion)
        val BtnTemporada = findViewById<ImageButton>(R.id.BtnTemporada)

        BtnRegion.setOnClickListener {
            region()
        }

        BtnTemporada.setOnClickListener {
                    temporada()
        }

    }
    fun getData() {
        var cuenta2: Cuenta? = intent.getParcelableExtra<Cuenta>("cuenta1")

        val txtNombre: TextView = findViewById<TextView>(R.id.txtNombre)
        val txtNum: TextView = findViewById<TextView>(R.id.txtNum)
        txtNombre.text = cuenta2!!.nombre
        txtNum.text = cuenta2!!.numCuenta.toString()
    }
    fun region(){
        val regionIntent = Intent(this,RegionDeCultivo::class.java)
        startActivity(regionIntent)
    }
    fun temporada(){
        val temporadaIntent = Intent(this,TemporadaDeCultivo::class.java)
        startActivity(temporadaIntent)
    }
}