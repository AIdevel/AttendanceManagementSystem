package com.RollCall.attendancemanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.RollCall.attendancemanagementsystem.teacherDashboard.TeacherDashboard

class TeacherActivity : AppCompatActivity() {
    //Intialiation
    lateinit var ButtonLogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)
        ButtonLogin=findViewById(R.id.btnlogin)

        ButtonLogin.setOnClickListener {
            val intent =Intent(this@TeacherActivity,TeacherDashboard::class.java)
            startActivity(intent)
        }
    }
}