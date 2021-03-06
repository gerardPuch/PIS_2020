package edu.ub.pis2018.gpuchcam7.pis_sessio2

import android.content.Intent
import android.hardware.display.DisplayManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "MENSAJE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun action1(view: View) {
        val intent = Intent(this, second::class.java)
        startActivity(intent)
    }

    fun action2(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent2 = Intent(this, second::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent2)
    }

    fun action3(view: View) {
        showWebPage(view)
    }

    fun showWebPage(view: View){
        val intent3 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        startActivity(intent3)
    }

}