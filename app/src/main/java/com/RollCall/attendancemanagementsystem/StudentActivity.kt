package com.RollCall.attendancemanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.RollCall.attendancemanagementsystem.fragment.DashboardFragment
import com.RollCall.attendancemanagementsystem.studentDashboard.StudentDashboard
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class StudentActivity : AppCompatActivity() {
    // Intialization
    lateinit var LoginButton:Button
    lateinit var userEmail:EditText
    lateinit var userPassword:EditText
    lateinit var userRoll:EditText
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        LoginButton=findViewById(R.id.btnlogin)
        userEmail = findViewById(R.id.etemail)
        userPassword = findViewById(R.id.etpassword)
        userRoll = findViewById(R.id.etrollno)



        auth = Firebase.auth
        LoginButton.setOnClickListener {
            val email = userEmail.text.toString()
            val password = userPassword.text.toString()
            val rollNo = userRoll.text.toString()







            if(email.isNotEmpty() && password.isNotEmpty()){
                auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener{
                        if(it.isSuccessful){
                            Toast.makeText(this@StudentActivity,"Successfully Login",Toast.LENGTH_SHORT).show()
                            val intent =Intent(this@StudentActivity,StudentDashboard::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }.addOnFailureListener {
                        Toast.makeText(this@StudentActivity,"Please Sign Up!",Toast.LENGTH_SHORT).show()

                    }

            }else{
                Toast.makeText(this@StudentActivity,"Please Fill Required Details!",Toast.LENGTH_SHORT).show()
            }

        }


    }
}