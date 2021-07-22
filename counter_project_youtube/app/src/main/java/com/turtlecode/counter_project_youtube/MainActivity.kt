package com.turtlecode.counter_project_youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import com.turtlecode.counter_project.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var number = 0
    var runnable : Runnable = Runnable {  }
    var handler = Handler(Looper.myLooper()!!)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun start_button (view: View) {
        runnable = object : Runnable {
            override fun run() {
                number = number + 1
                counter_text.text = "${number}"
                handler.postDelayed(runnable,1000)
                if (number > 15) {
                    number = 0
                }
            }
        }
        handler.post(runnable)
    }
    fun stop_button (view: View) {
        handler.removeCallbacks(runnable)
        counter_text.text = "${number}"
    }
}