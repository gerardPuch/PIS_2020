package edu.ub.pis2018.gpuchcam7.pis_sessio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.textView2).apply {
            text = message
        }
    }
}
