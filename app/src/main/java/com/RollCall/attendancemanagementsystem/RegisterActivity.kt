package com.RollCall.attendancemanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    lateinit var buttonStudent:Button
    lateinit var buttonRegister:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)






        buttonStudent=findViewById(R.id.btnstudent)
        buttonRegister=findViewById(R.id.btnteacher)

        buttonStudent.setOnClickListener {
            val intent= Intent(this@RegisterActivity,StudentRegisterActivity::class.java)
            startActivity(intent)

        }
        buttonRegister.setOnClickListener{
            val intent =Intent(this@RegisterActivity,TeacherRegisterActivity::class.java)
            startActivity(intent)
        }



    }
}