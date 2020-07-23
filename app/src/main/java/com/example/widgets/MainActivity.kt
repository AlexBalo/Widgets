package com.example.widgets

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.widgets.counter.CounterActivity
import com.example.widgets.gradient.GradientActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gradientButton = findViewById<Button>(R.id.gradient)
        gradientButton.setOnClickListener {
            val intent = Intent(this@MainActivity, GradientActivity::class.java)
            startActivity(intent)
        }

        val counterButton = findViewById<Button>(R.id.counter)
        counterButton.setOnClickListener {
            val intent = Intent(this@MainActivity, CounterActivity::class.java)
            startActivity(intent)
        }
    }
}