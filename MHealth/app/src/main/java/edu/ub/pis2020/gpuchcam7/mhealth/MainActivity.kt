package edu.ub.pis2020.gpuchcam7.mhealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = "Aquesta App és un cercador d'enfermetats d'ús domèstic, si es troba en una emergència real, truqui al servei d'emergències\n 112 o 061\n\nMarqui els símptomes que pateixi i donali al butó de Next"
    }

    fun StartApp(view: View) {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}
