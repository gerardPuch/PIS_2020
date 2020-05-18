package edu.ub.pis2020.gpuchcam7.mhealth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.AdapterStringList
import kotlinx.android.synthetic.main.activity_illness.*

class IllnessActivity : AppCompatActivity() {

    lateinit var recievedCauses : ArrayList<String>
    lateinit var recievedSintomas : ArrayList<String>
    lateinit var recievedRemedies : ArrayList<String>

    lateinit var listCauses: ListView
    lateinit var listSintomas: ListView
    lateinit var listRemedies: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_illness)

        recievedCauses = intent.getStringArrayListExtra("causes")
        recievedSintomas = intent.getStringArrayListExtra("sintomas")
        recievedRemedies = intent.getStringArrayListExtra("remedies")

        listCauses = findViewById(R.id.illness_causes)
        listSintomas = findViewById(R.id.illness_sintomas)
        listRemedies = findViewById(R.id.illness_remedies)

        val causesAdapter = AdapterStringList(this, 0, recievedCauses)
        val sintomasAdapter = AdapterStringList(this, 0, recievedSintomas)
        val remediesAdapter = AdapterStringList(this, 0, recievedRemedies)

        listCauses.adapter = causesAdapter
        listSintomas.adapter = sintomasAdapter
        listRemedies.adapter = remediesAdapter
    }
}
