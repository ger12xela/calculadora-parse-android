package com.example.prueba

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.security.NoSuchAlgorithmException

class ActivityResultado : AppCompatActivity() {
    private var dato1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textver: TextView = findViewById(R.id.textView2result)
        try {
            recibirDatos()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        textver.text =dato1

    }
    @Throws(NoSuchAlgorithmException::class)
    private fun recibirDatos() {
        val dato = intent.extras
        if (dato != null){
            this.dato1 = dato.getSerializable("resultado").toString()
        }
    }
}