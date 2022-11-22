package com.example.huertaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variables para optener los datos de los componentes

        val EditexNombre = findViewById<EditText>(R.id.EditexNombre)
        val EdiTexPassword = findViewById<EditText>(R.id.EditexPassword)
        val EditexDni = findViewById<EditText>(R.id.EditexDni)
        val EditexApellido = findViewById<EditText>(R.id.EditexApellido)

        val BtnEnviar = findViewById<Button>(R.id.BtnEnviar)


        BtnEnviar.setOnClickListener {
            ValidarIngreso(EditexNombre, EdiTexPassword, EditexDni, EditexApellido)
        }
    }

    fun ValidarIngreso(nombre: EditText, password: EditText, dni : EditText, apellido : EditText) {
        var validarNombre = nombre.text.toString()
        var validarPassword = password.text.toString()
        var validarDni = dni.text.toString()
        var validarApellido = apellido.text.toString()

        //se crea un usuario

        val usuario = Usuario(validarDni,validarNombre,validarApellido,validarPassword)
        usuario.Nombre = "Cristian"
        usuario.Password = "1234"
        usuario.Dni = "12345678"
        usuario.Apellido="Godoy"


        if (validarNombre.equals(usuario.Nombre) && validarPassword.equals(usuario.Password)
            && validarDni.equals(usuario.Dni) && validarApellido.equals(usuario.Apellido)
        ) {

            Toast.makeText(this, " acceso correcto ", Toast.LENGTH_SHORT).show()

            //creo un objeto
            val cnta1 = Cuenta (1,validarNombre,validarDni.toInt())

            //objeto intent
            val IntenteMenu = Intent(this, Menu::class.java)
            IntenteMenu.putExtra("cuenta1",cnta1)
            startActivity(IntenteMenu)

        } else {
            Toast.makeText(this, "acceso denegado verifique los datos ingresados", Toast.LENGTH_SHORT).show()
        }




    }

}