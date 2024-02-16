package com.RollCall.attendancemanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    lateinit var studentlogin: Button
    lateinit var teacherlogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        studentlogin = findViewById(R.id.btnstudent)
        teacherlogin = findViewById(R.id.btnteacher)

        studentlogin.setOnClickListener {

            //Firebase Authentication
            val intent = Intent(this@LoginActivity , StudentActivity::class.java)
            startActivity(intent)
        }

        teacherlogin.setOnClickListener {
            val intent = Intent(this@LoginActivity , TeacherActivity::class.java)
            startActivity(intent)
        }

    }

}