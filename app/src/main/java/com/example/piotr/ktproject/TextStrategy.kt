package com.example.piotr.ktproject

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class TextStrategy : Strategy {
    val context: Context
    val sharedPreferences: SharedPreferences

    constructor(context: Context) {
        this.context = context
        sharedPreferences = context.getSharedPreferences("text", MODE_PRIVATE)
    }


    override fun getData() {
        sharedPreferences.getString("text", "defaultText")
    }

    override fun saveData(text: String) {
        sharedPreferences.edit().putString("text", text).apply()
    }
}