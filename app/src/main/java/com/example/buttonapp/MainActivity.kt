package com.example.buttonapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var text: TextView
    var count: Int = 0
    private lateinit var clMain: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clMain = findViewById(R.id.clMain)

        text = findViewById<TextView>(R.id.textView2)
        text.text = "0"
        text.setTextColor(Color.BLACK)

        var plusButt = findViewById<Button>(R.id.button4)
        var minusButt = findViewById<Button>(R.id.button3)

        plusButt.setOnClickListener { calculate("+") }
        minusButt.setOnClickListener { calculate("-") }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> {
                Snackbar.make(clMain, "The number increases", Snackbar.LENGTH_SHORT).show()
                calculate("+")
                return true
            }
            R.id.item2 -> {
                Snackbar.make(clMain, "The number decreased", Snackbar.LENGTH_SHORT).show()
                calculate("-")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
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
