package com.RollCall.attendancemanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.coroutines.selects.select
import java.util.ArrayList

class TeacherRegisterActivity : AppCompatActivity() {
    //Initialisation
    lateinit var spinner:Spinner
    lateinit var spinner2:Spinner
    lateinit var spinner3:Spinner
    lateinit var spinner4:Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_register)

        // Declaration
        spinner = findViewById(R.id.spTRdepartment)
        spinner2 =findViewById(R.id.spTRcourse)
        spinner3 = findViewById(R.id.spTRyear)
        spinner4 = findViewById(R.id.spTRsem)

        // Data source for items

        var arr= arrayListOf("Department","B.Tech","MCA","B.Voc","M.Tech")
        // ArrayAdapter ->help to bind the Array_items with spinner
        val arrayAdaptor = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,arr)

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

                    val btechAdapter = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,Btech)

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
                            val yearug4Adapter = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,year_ug_4)
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
                                    val semug4Adapter = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,sem_ug_4)
                                    spinner4.adapter = semug4Adapter

                                    spinner4.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                                        override fun onItemSelected(
                                            parent: AdapterView<*>?,
                                            view: View?,
                                            position: Int,
                                            id: Long
                                        ) {
                                            var selectSem = sem_ug_4[position]
                                            Toast.makeText(this@TeacherRegisterActivity,"Select Semester ${selectSem}",Toast.LENGTH_SHORT).show()
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

                    val mtechAdapter = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,Mtech)
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
                            val yearpg2 = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,year_pg_2)
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
                                    val sempg2Adapter = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,sem_pg_2)
                                    spinner4.adapter = sempg2Adapter

                                    spinner4.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                                        override fun onItemSelected(
                                            parent: AdapterView<*>?,
                                            view: View?,
                                            position: Int,
                                            id: Long
                                        ) {
                                            var selectSem = sem_pg_2[position]
                                            Toast.makeText(this@TeacherRegisterActivity,"Select Semester ${selectSem}",Toast.LENGTH_SHORT).show()
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

                    val mcaAdapter = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,Mca)

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
                            val yearpg2 = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,year_pg_2)
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
                                    val sempg2Adapter = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,sem_pg_2)
                                    spinner4.adapter = sempg2Adapter

                                    spinner4.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                                        override fun onItemSelected(
                                            parent: AdapterView<*>?,
                                            view: View?,
                                            position: Int,
                                            id: Long
                                        ) {
                                            var selectSem = sem_pg_2[position]
                                            Toast.makeText(this@TeacherRegisterActivity,"Select Semester ${selectSem}",Toast.LENGTH_SHORT).show()
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

                    val bvocAdapter = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,Bvoc)

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
                            val yearug3Adapter = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,year_ug_3)
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
                                    val semug3Adapter = ArrayAdapter(this@TeacherRegisterActivity,android.R.layout.simple_spinner_item,sem_ug_3)
                                    spinner4.adapter = semug3Adapter

                                    spinner4.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                                        override fun onItemSelected(
                                            parent: AdapterView<*>?,
                                            view: View?,
                                            position: Int,
                                            id: Long
                                        ) {
                                            var selectSem = sem_ug_3[position]
                                            Toast.makeText(this@TeacherRegisterActivity,"Select Semester ${selectSem}",Toast.LENGTH_SHORT).show()
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

    }
}