package com.example.prueba

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.prueba.parser.SimpleLexer
import com.example.prueba.parser.SimpleParser
import java.io.StringReader
import java.security.NoSuchAlgorithmException
import java.util.logging.Level
import java.util.logging.Logger


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonCompile: Button = findViewById<Button>(R.id.buttonCompilar)
        val buttonClear: Button = findViewById<Button>(R.id.buttonDell)
        val areatexto: EditText = findViewById(R.id.editTextFormula)
        val textver: TextView = findViewById(R.id.textView)


        buttonCompile.setOnClickListener {
            try{
            val input: String = areatexto.text.toString()
            val lexer = SimpleLexer(StringReader(input))
            val parser = SimpleParser(lexer)
            val resul = parser.parse().value
            textver.text = resul.toString()
            desplegarResultado(resul.toString())
        } catch (e: NoSuchAlgorithmException) { //error en onclick
            e.printStackTrace()
        } catch (ex: Exception) { //error en parser
            println("Error irrecuperable")
            Logger.getLogger(MainActivity::class.java.name).log(Level.SEVERE, null, ex)
        }

        }
        buttonClear.setOnClickListener{
            textver.setText(" ")
        }

    }
    fun desplegarResultado(input: String){
        val nuevaVentana1 = Intent(
        this,
        ActivityResultado::class.java)

        val nuevoBundlePrincipal = Bundle()

        nuevoBundlePrincipal.putSerializable("resultado",input)
        nuevaVentana1.putExtras(nuevoBundlePrincipal)
        startActivity(nuevaVentana1)
    }
}