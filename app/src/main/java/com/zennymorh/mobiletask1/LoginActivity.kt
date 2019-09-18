package com.zennymorh.mobiletask1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.edtEmail
import kotlinx.android.synthetic.main.activity_login.password
import kotlinx.android.synthetic.main.activity_login.registerNow
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPref = getSharedPreferences("zee", Context.MODE_PRIVATE)

        //Login
        loginButton.setOnClickListener {
            //Get username
            val userEmail = edtEmail.text.toString()

            //Get password
            var password = password.text.toString()


            val savedEmail = sharedPref.getString("userEmail",null)
            val savedPassword = sharedPref.getString("userPassword",null)

            if (userEmail == savedEmail && password == savedPassword){
                val intent = Intent(this,DashboardActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email or Password incorrect", Toast.LENGTH_LONG).show()
            }

        }
        registerNow.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}
