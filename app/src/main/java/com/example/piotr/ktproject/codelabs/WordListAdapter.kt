package com.example.piotr.ktproject.codelabs

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.piotr.ktproject.R


class WordListAdapter(context: Context) : RecyclerView.Adapter<WordViewHolder>() {

    private var layoutInflater: LayoutInflater? = null
    private var wordList: List<Word>? = listOf()
    private var context: Context? = null

    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        layoutInflater = LayoutInflater.from(context)
        val itemView = layoutInflater?.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView!!)
    }

    override fun getItemCount(): Int {
        return wordList?.size!!
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = wordList?.get(position)?.word
        holder.wordItemView?.text = word
    }

    fun setWords(list: List<Word>?) {
        wordList = list
        notifyDataSetChanged()
    }
}


class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var wordItemView: TextView? = null

    init {
        wordItemView = view.findViewById(R.id.word_textView)
    }
}
