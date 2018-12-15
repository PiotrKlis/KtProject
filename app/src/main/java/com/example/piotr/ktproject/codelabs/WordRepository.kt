package com.example.piotr.ktproject.codelabs

import android.app.Application
import android.arch.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WordRepository(application: Application) {
    private var wordDao: WordDao? = null
    private var allWord: LiveData<List<Word>>? = null

    init {
        val wordRoomDatabase = WordRoomDatabase.getInstance(application)
        wordDao = wordRoomDatabase?.wordDao()
        allWord = wordDao?.getAll()
    }

    fun getAllWords(): LiveData<List<Word>>? {
        return allWord
    }

    fun insert(word: Word) {
        GlobalScope.launch {
            // launch new coroutine in background and continue
            wordDao?.insert(word)
        }
    }
}