package com.example.leserge.listviewkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lista: ListView? = null
    var estados = arrayOf("Aguascalientes", "Estado de México", "Guerrero", "Oaxaca", "Zacatecas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Example of a call to a native method
        sample_text.text = stringFromJNI()

        lista = findViewById(R.id.lista)
        var adaptador = Adaptador(this, generateData())
        lista?.adapter = adaptador

        adaptador.notifyDataSetChanged()

        lista?.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(applicationContext, "¡Viva " + estados[position] + "!",Toast.LENGTH_SHORT).show()
        }

    }

    private fun generateData(): ArrayList<Estados> {
        var result = ArrayList<Estados>()
        var estado1 = Estados("Aguascalientes", "Aguascalientes")
        var estado2 = Estados("Estado de México", "Toluca")
        var estado3 = Estados("Guerrero", "Chilpancingo")
        var estado4 = Estados("Oaxaca", "Oaxaca")
        var estado5 = Estados("Zacatecas", "Zacatecas")

        result.add(estado1)
        result.add(estado2)
        result.add(estado3)
        result.add(estado4)
        result.add(estado5)

        return result
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
