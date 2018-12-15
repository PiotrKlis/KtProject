package com.example.piotr.ktproject.codelabs

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface WordDao {

    @Query("SELECT * from wordData")
    fun getAll(): LiveData<List<Word>>

    @Insert(onConflict = REPLACE)
    fun insert(word: Word)

    @Query("DELETE from wordData")
    fun deleteAll()
}