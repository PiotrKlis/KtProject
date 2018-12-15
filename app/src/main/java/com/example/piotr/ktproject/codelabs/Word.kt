package com.example.piotr.ktproject.codelabs

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "wordData")
data class Word(@PrimaryKey var word: String)
