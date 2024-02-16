package com.RollCall.attendancemanagementsystem.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.RollCall.attendancemanagementsystem.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class DashboardFragment : Fragment() {
    lateinit var uName : TextView
    lateinit var uRoll:TextView
    lateinit var uDept:TextView

    val db= Firebase.firestore


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view:View=inflater.inflate(R.layout.fragment_dashboard, container, false)
          uName=view.findViewById(R.id.fragementDashboardStudentName)
          uRoll=view.findViewById(R.id.fragmentDashboardStudentRollno)
          uDept=view.findViewById(R.id.fragmentDashboardStudentDepartment)





        val fetch=db.collection("Student_Details").document(uRoll.text.toString())
        fetch.get().addOnSuccessListener {document->
            if(document!=null){
                uName.text="${document.data?.get("Name")}"
                uRoll.text="${document.data?.get("Roll_No")}"
                uDept.text="${document.data?.get("Department")}"
            }

        }


        return view
    }
}
