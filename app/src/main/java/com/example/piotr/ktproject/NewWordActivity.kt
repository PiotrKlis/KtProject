package com.example.piotr.ktproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.EditText

class NewWordActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        var saveButton: Button = findViewById(R.id.button_save)
        var editEditText: EditText = findViewById(R.id.edit_word)

        saveButton.setOnClickListener {
            val intent = Intent()
            if (TextUtils.isEmpty(editEditText.text)) {
                setResult(RESULT_CANCELED, intent);
            } else {
                val word = editEditText.text.toString()
                intent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, intent)
            }
            finish()
        }
    }

    override fun onCreateView(name: String?, context: Context?, attrs: AttributeSet?): View? {
        return super.onCreateView(name, context, attrs)
    }

    companion object {
        fun newIntent(context: Context): Intent? {
            return Intent(context, NewWordActivity::class.java)
        }

        val EXTRA_REPLY = "com.example.android.roomwordssample.REPLY"
        val NEW_WORD_ACTIVITY_REQUEST_CODE = 1

    }
}
