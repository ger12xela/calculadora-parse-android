package com.example.prueba.parser

import android.util.Log

class Token (val value: String?,val type: Int, val linea: Int, val column: Int){
    private val TAG: String = "token.class"

    fun printInfo(){
        Log.println(Log.INFO, TAG, "value: &{this.value} type: &{this.type.name}, Line: &{this.linea}, columna: &{this.column}")


    }

    fun getInfo(): String {
        return "value: &{this.value} type: &{this.type.name}, Line: &{this.linea}, columna: &{this.column} "
    }
    fun getLexema(): String? {
        return value
    }
}