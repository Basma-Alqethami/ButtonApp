package com.example.buttonapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var text: TextView
    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById<TextView>(R.id.textView2)
        text.text = "0"
        text.setTextColor(Color.BLACK)

        var plusButt = findViewById<Button>(R.id.button4)
        var minusButt = findViewById<Button>(R.id.button3)

        plusButt.setOnClickListener { calculate("+") }
        minusButt.setOnClickListener { calculate("-") }
    }

    private fun calculate(op: String) {
        if (op == "+") {
            count++
            text.text = "$count"
            if (count == 0) {
                text.setTextColor(Color.BLACK)
            } else {
                text.setTextColor(Color.GREEN)
            }
        } else {
            count--
            text.text = "$count"
            if (count == 0) {
                text.setTextColor(Color.BLACK)
            } else {
                text.setTextColor(Color.RED)
            }
        }
    }
}
