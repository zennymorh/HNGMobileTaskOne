package com.zennymorh.mobiletask1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val sharedPref = getSharedPreferences("zee", Context.MODE_PRIVATE)

        registerButton.setOnClickListener {
            //Getting Fullname
            var fullName = editTextFullName.text.toString()

            //Getting Email
            var email = edtEmail.text.toString()

            //Getting password
            var pword = password.text.toString()

            if (fullName.isEmpty() || email.isEmpty() || pword.isEmpty()) {
                Toast.makeText(this, "Fill in the required fields", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            sharedPref.edit().putString("userFullName",fullName).apply()
            sharedPref.edit().putString("userEmail",email).apply()
            sharedPref.edit().putString("userPassword",pword).apply()


            Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()

            finish()

        }

        loginNow.setOnClickListener {
            finish()
        }
    }
}
