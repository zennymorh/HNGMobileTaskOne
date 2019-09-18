package com.zennymorh.mobiletask1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val sharedPref = getSharedPreferences("zee", Context.MODE_PRIVATE)

        val savedEmail = sharedPref.getString("userEmail",null)

        val fullName = sharedPref.getString("userFullName", null)

        nameDisplay.text = "Your full name is $fullName"
        emailDisplay.text  = "Your email is $savedEmail"


    }
}
