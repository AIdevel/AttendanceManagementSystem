package com.RollCall.attendancemanagementsystem

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

       startSplash()
    }

    private fun startSplash() {
        LongOperation().execute()
    }
    private open inner class LongOperation: AsyncTask<String?,Void?,String?>(){
        override fun doInBackground(vararg params: String?): String? {
            for(i in 0..2){
                try{
                    Thread.sleep(1000)
                }catch (e:Exception){
                    Thread.interrupted()
                }
            }
            return "Result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val intent =Intent(this@Splash_Screen,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}