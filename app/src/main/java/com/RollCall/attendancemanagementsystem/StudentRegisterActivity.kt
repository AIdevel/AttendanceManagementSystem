package com.RollCall.attendancemanagementsystem

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class StudentRegisterActivity : AppCompatActivity() {
    //Initialisation

    // Intaialization of Firebase Authentication
    lateinit var auth:FirebaseAuth

    lateinit var spinner:Spinner
    lateinit var spinner2:Spinner
    lateinit var spinner3:Spinner
    lateinit var spinner4:Spinner

    var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_register)


        auth =Firebase.auth
        val name = findViewById<EditText>(R.id.etSRname)
        val rollNumber = findViewById<EditText>(R.id.etSRrollno)
        val mobileNumber = findViewById<EditText>(R.id.etSRmobile)
        val gender = findViewById<EditText>(R.id.etSRgender)
        val email = findViewById<EditText>(R.id.etSRemail)
        val password = findViewById<EditText>(R.id.etSRpassword)
        val resButton = findViewById<Button>(R.id.button)



//        val db = Firebase.firestore
//        // Adding data to FireStone Database
//        val user_collection = db.collection("User")
//        val user4 = hashMapOf(
//            "Name" to "Sanjay",
//            "lname" to "dfg",
//            "RollNo" to "221638"
//        )
//        // creating document & passing the value to Document
//        user_collection.document("user3").set(user3)


        // Declaration

        spinner = findViewById(R.id.spSRdepartment)
        spinner2 =findViewById(R.id.spSRcourse)
        spinner3 = findViewById(R.id.spSRyear)
        spinner4 = findViewById(R.id.spSRsem)




        // Data source for items


        var arr= arrayListOf("Department","B.Tech","MCA","B.Voc","M.Tech")
        // ArrayAdapter ->help to bind the Array_items with spinner
        val arrayAdaptor = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,arr)

        spinner.adapter = arrayAdaptor // parent

        // handling the spinner department && courses
        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Parent
                val selectItem = arr[position]

                if (selectItem == arr[1]){

                    var Btech = arrayOf("CSE","ECE","CIVIL","PPT")

                    val btechAdapter = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,Btech)

                    spinner2.adapter = btechAdapter
                    spinner2.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                           // Select the year for 4th year course

                            //spinner
                            var year_ug_4 = arrayListOf("1st year","2nd year","3rd year","4th year")
                            val yearug4Adapter = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,year_ug_4)
                            spinner3.adapter = yearug4Adapter

                            spinner3.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                                override fun onItemSelected(
                                    parent: AdapterView<*>?,
                                    view: View?,
                                    position: Int,
                                    id: Long
                                ) {
                                    //val selectyrug4 = year_ug_4[position]
                                    //Semester Ug -4
                                    var sem_ug_4 = arrayListOf("1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester")
                                    val semug4Adapter = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,sem_ug_4)
                                    spinner4.adapter = semug4Adapter

                                    spinner4.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                                        override fun onItemSelected(
                                            parent: AdapterView<*>?,
                                            view: View?,
                                            position: Int,
                                            id: Long
                                        ) {
                                            var selectSem = sem_ug_4[position]
                                            Toast.makeText(this@StudentRegisterActivity,"Select Semester ${selectSem}",Toast.LENGTH_SHORT).show()
                                        }
                                        override fun onNothingSelected(parent: AdapterView<*>?) {
                                            TODO("Not yet implemented")
                                        }
                                    }

                                }

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                    TODO("Not yet implemented")
                                }

                            }
                        }


                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }
                    }

                }else if(selectItem==arr[4]){

                    var Mtech = arrayOf("CSE","ELE","CIVIL")

                    val mtechAdapter = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,Mtech)
                    spinner2.adapter = mtechAdapter
                    spinner2.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                           // Select year for 2year course
                            var year_pg_2 = arrayListOf("1st year","2nd year")
                            val yearpg2 = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,year_pg_2)
                            spinner3.adapter = yearpg2

                            spinner3.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                                override fun onItemSelected(
                                    parent: AdapterView<*>?,
                                    view: View?,
                                    position: Int,
                                    id: Long
                                ) {
                                    //var yearPG2=year_pg_2[position]
                                    //Seester PG -2
                                    var sem_pg_2 = arrayListOf("1st Semester","2nd Semester","3rd Semester","4th Semester")
                                    val sempg2Adapter = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,sem_pg_2)
                                    spinner4.adapter = sempg2Adapter

                                    spinner4.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                                        override fun onItemSelected(
                                            parent: AdapterView<*>?,
                                            view: View?,
                                            position: Int,
                                            id: Long
                                        ) {
                                            var selectSem = sem_pg_2[position]
                                            Toast.makeText(this@StudentRegisterActivity,"Select Semester ${selectSem}",Toast.LENGTH_SHORT).show()
                                        }
                                        override fun onNothingSelected(parent: AdapterView<*>?) {
                                            TODO("Not yet implemented")
                                        }
                                    }

                                }

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                    TODO("Not yet implemented")
                                }

                            }

                        }


                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }
                    }

                }else if(selectItem == arr[2]){

                    var Mca = arrayOf("Software Engineering","Cloud Computing","Cyber Security")

                    val mcaAdapter = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,Mca)

                    spinner2.adapter = mcaAdapter

                    spinner2.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            // select year for 2year course

                            var year_pg_2 = arrayListOf("1st year","2nd year")
                            val yearpg2 = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,year_pg_2)
                            spinner3.adapter = yearpg2

                            spinner3.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                                override fun onItemSelected(
                                    parent: AdapterView<*>?,
                                    view: View?,
                                    position: Int,
                                    id: Long
                                ){
                                    //var yearPG2=year_pg_2[position]
                                    // Semester PG -2
                                    var sem_pg_2 = arrayListOf("1st Semester","2nd Semester","3rd Semester","4th Semester")
                                    val sempg2Adapter = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,sem_pg_2)
                                    spinner4.adapter = sempg2Adapter

                                    spinner4.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                                        override fun onItemSelected(
                                            parent: AdapterView<*>?,
                                            view: View?,
                                            position: Int,
                                            id: Long
                                        ) {
                                            var selectSem = sem_pg_2[position]
                                            Toast.makeText(this@StudentRegisterActivity,"Select Semester ${selectSem}",Toast.LENGTH_SHORT).show()
                                        }
                                        override fun onNothingSelected(parent: AdapterView<*>?) {
                                            TODO("Not yet implemented")
                                        }
                                    }
                                }

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                    TODO("Not yet implemented")
                                }

                            }
                            }
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }
                    }
                }else if(selectItem == arr[3]){

                    var Bvoc = arrayOf("RLM","IWM","BMS")

                    val bvocAdapter = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,Bvoc)

                    spinner2.adapter = bvocAdapter

                    spinner2.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            //select year for 3year course
                            var year_ug_3 = arrayListOf("1st year","2nd year","3rd year")
                            val yearug3Adapter = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,year_ug_3)
                            spinner3.adapter = yearug3Adapter

                            spinner3.onItemSelectedListener =object:AdapterView.OnItemSelectedListener{

                                override fun onItemSelected(
                                    parent: AdapterView<*>?,
                                    view: View?,
                                    position: Int,
                                    id: Long
                                ) {
                                   // var yearUg3=year_ug_3[position]
                                    //Semester for UG -3
                                    var sem_ug_3 = arrayListOf("1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester")
                                    val semug3Adapter = ArrayAdapter(this@StudentRegisterActivity,android.R.layout.simple_spinner_item,sem_ug_3)
                                    spinner4.adapter = semug3Adapter

                                    spinner4.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                                        override fun onItemSelected(
                                            parent: AdapterView<*>?,
                                            view: View?,
                                            position: Int,
                                            id: Long
                                        ) {
                                            var selectSem = sem_ug_3[position]
                                            Toast.makeText(this@StudentRegisterActivity,"Select Semester ${selectSem}",Toast.LENGTH_SHORT).show()
                                        }
                                        override fun onNothingSelected(parent: AdapterView<*>?) {
                                            TODO("Not yet implemented")
                                        }
                                    }
                                }

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                    TODO("Not yet implemented")
                                }

                            }


                        }
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }
                    }

                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        resButton.setOnClickListener {

            val sname = name.text.toString().trim()
            val srollNumber = rollNumber.text.toString().trim()
            val smobileNumber = mobileNumber.text.toString().trim()
            val sgender = gender.text.toString().trim()
            val semail = email.text.toString().trim()
            val spassword = password.text.toString().trim()
            val sSpinner = spinner.selectedItem.toString().trim()
            val sSpinner2 = spinner2.selectedItem.toString().trim()
            val sSpinner3 = spinner3.selectedItem.toString().trim()
            val sSpinner4 = spinner4.selectedItem.toString().trim()


            val userData = hashMapOf(
                "Name" to sname,
                "Roll_No" to srollNumber,
                "Mobile Number" to smobileNumber,
                "Gender" to sgender,
                "Email Id" to semail,
                "Password" to spassword,
                "Department" to sSpinner,
                "Course" to sSpinner2,
                "Year" to sSpinner3,
                "Semester" to sSpinner4

            )
           //if(sSpinner =="B.Tech" && sSpinner2=="CSE"){
                    //if(sSpinner3=="2nd year" && sSpinner4=="4th Semester"){
                            val user_colletion= db.collection("Student_Details")
                            user_colletion.document("$srollNumber").set(userData)
                                .addOnSuccessListener {
                                    Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show()
                                    //Firebase Authentication create account code

                                    auth.createUserWithEmailAndPassword(semail,spassword)
                                        .addOnCompleteListener(this@StudentRegisterActivity){ task->
                                            if(task.isSuccessful){
                                                val user= auth.currentUser
                                                upadateUi(user)
                                            }else{
                                                Toast.makeText(baseContext,"Authentication Failed!",Toast.LENGTH_SHORT).show()
                                                upadateUi(null)
                                            }
                                        }


                                    name.text.clear()
                                    rollNumber.text.clear()
                                    mobileNumber.text.clear()
                                    gender.text.clear()
                                    email.text.clear()
                                    password.text.clear()
                                }
                                .addOnFailureListener {
                                    Toast.makeText(this, "Failed to Registered", Toast.LENGTH_SHORT).show()
                                }






        }

    }

    private fun upadateUi(user: FirebaseUser?) {

    }

    public override fun onStart() {
        super.onStart()

        val currentUser=auth.currentUser
        if(currentUser != null) reload()
    }

    private fun reload() {

    }
}