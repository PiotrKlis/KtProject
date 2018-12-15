package com.example.piotr.ktproject

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.piotr.ktproject.codelabs.Word
import com.example.piotr.ktproject.codelabs.WordListAdapter
import com.example.piotr.ktproject.codelabs.WordViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var floatButton: FloatingActionButton = findViewById(R.id.floatingActionButton)

        floatButton.setOnClickListener {
            val intent = Intent(this, NewWordActivity::class.java)
            startActivityForResult(intent, NewWordActivity.NEW_WORD_ACTIVITY_REQUEST_CODE)
        }

        val listOf = mutableListOf(1, 2, 3)
        listOf.removeAt(2)

        val imageStrategy: Strategy = ImageStrategy(this)
        val image = imageStrategy.getData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val wordListAdapter = WordListAdapter(this)
        recyclerView.adapter = wordListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        wordViewModel = ViewModelProviders.of(this).get(WordViewModel(application).javaClass)

        wordViewModel.getAllWords()?.observe(this, Observer<List<Word>>
        { words -> wordListAdapter.setWords(words) })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NewWordActivity.NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val word = Word(data!!.getStringExtra(NewWordActivity.EXTRA_REPLY))
            wordViewModel.insert(word)
        } else {
            Toast.makeText(
                applicationContext,
                "Not saved :(",
                Toast.LENGTH_LONG
            ).show()
        }

    }
}
