package com.RollCall.attendancemanagementsystem

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.core.os.postDelayed
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var login: Button
    lateinit var register: Button
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        login = findViewById(R.id.btnlogin)
        register = findViewById(R.id.btnregister)


            login.setOnClickListener {
                val intent = Intent(this@MainActivity,LoginActivity::class.java)
                startActivity(intent)
               // Handler(Looper.getMainLooper()).postDelayed(3000){}

        }


        register.setOnClickListener {
            val intent = Intent(this@MainActivity,RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}