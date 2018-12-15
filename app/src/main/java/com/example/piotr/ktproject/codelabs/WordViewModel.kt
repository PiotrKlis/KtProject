package com.example.piotr.ktproject.codelabs

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

class WordViewModel(context: Application) : AndroidViewModel(context) {
    private var wordRepository: WordRepository? = null
    private var allWords: LiveData<List<Word>>? = null

    init {
        wordRepository = WordRepository(context)
        allWords = wordRepository?.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>>? {
        return allWords
    }

    fun insert(word: Word) {
        wordRepository?.insert(word)
    }
}