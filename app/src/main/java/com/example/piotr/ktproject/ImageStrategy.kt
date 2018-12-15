package com.example.piotr.ktproject

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class ImageStrategy : Strategy {

    val context: Context
    val sharedPreferences: SharedPreferences

    constructor(context: Context) {
        this.context = context
        sharedPreferences = context.getSharedPreferences("image", MODE_PRIVATE)
    }

    override fun getData() {
        sharedPreferences.getInt("image", 0)
    }

    override fun saveData(image: String) {
        sharedPreferences.edit().putString("image", image).apply()
    }
}