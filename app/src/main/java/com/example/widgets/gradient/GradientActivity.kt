package com.example.widgets.gradient

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.widgets.R

class GradientActivity : AppCompatActivity() {
    private lateinit var gradient: GradientImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gradient)

        gradient = findViewById(R.id.gradient)
        val animateButton = findViewById<Button>(R.id.animate)
        animateButton.setOnClickListener {
            gradient.startAnimation()
        }
    }

    override fun onPause() {
        super.onPause()
        gradient.stopAnimation()
    }
}