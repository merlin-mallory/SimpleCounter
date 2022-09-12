package com.example.simplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        val upgradeButton = findViewById<Button>(R.id.upgradeButton)

        button.setOnClickListener {
            counter++
            textView.text = counter.toString()
            Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()

            if (counter >= 20) {
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text = "Add 2"

                    button.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()
                    }
                    upgradeButton.visibility = View.INVISIBLE
                }
            }
        }


    }

    var counter = 0
}