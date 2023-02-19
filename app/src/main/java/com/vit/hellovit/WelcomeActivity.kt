package com.vit.hellovit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class WelcomeActivity : AppCompatActivity() {

    override fun onStart() {
        Log.d("WelcomeActivity", "onStart")
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("WelcomeActivity", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val name = findViewById<AppCompatEditText>(R.id.edtName)
        val dob = findViewById<AppCompatEditText>(R.id.edtDOB)
        val phone = findViewById<AppCompatEditText>(R.id.edtPhone)
        val hobby = findViewById<AppCompatEditText>(R.id.edtHobby)

        val submitButton = findViewById<AppCompatButton>(R.id.btnSave)
        val btnFriendsList = findViewById<AppCompatButton>(R.id.btnFriendsList)

        submitButton.setOnClickListener {
            Log.d("WelcomeActivity", name.text.toString())
            val dbHelper = DBHelper(this, null)

            dbHelper.addFriendToSlabBook(
                name.text.toString(),
                dob.text.toString(),
                phone.text.toString(),
                hobby.text.toString()
            )

            Toast.makeText(this@WelcomeActivity, "Friend added successfully", Toast.LENGTH_LONG).show()

            name.text?.clear()
            dob.text?.clear()
            phone.text?.clear()
            hobby.text?.clear()

        }

        btnFriendsList.setOnClickListener {
            val intent = Intent(this,  FriendsListActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        Log.d("WelcomeActivity", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("WelcomeActivity", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("WelcomeActivity", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("WelcomeActivity", "onDestroy")
        super.onDestroy()
    }
}