package com.example.piotr.ktproject.codelabs

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        private var INSTANCE: WordRoomDatabase? = null
        fun getInstance(context: Context): WordRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(WordRoomDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, WordRoomDatabase::class.java, "word_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(roomDataBaseCallback())
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }

        fun roomDataBaseCallback() = object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                GlobalScope.launch {
                    // launch new coroutine in background and continue
                    val wordDao: WordDao? = INSTANCE?.wordDao()
                    val words = listOf("Bąbelek", "Bąbello", "Kartka")
                    wordDao?.deleteAll()

                    for (i in words) {
                        val word = Word(i)
                        wordDao?.insert(word)
                    }
                }
            }
        }
    }
}