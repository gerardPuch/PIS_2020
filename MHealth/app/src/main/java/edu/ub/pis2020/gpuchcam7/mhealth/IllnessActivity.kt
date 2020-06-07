package edu.ub.pis2020.gpuchcam7.mhealth

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.AdapterStringList
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.Sintomas
import kotlinx.android.synthetic.main.activity_illness.*


class IllnessActivity : AppCompatActivity() {

    lateinit private var recievedCauses : ArrayList<String>
    lateinit private var recievedSintomas : ArrayList<Int>
    lateinit private var recievedRemedies : ArrayList<String>

    lateinit private var listCauses: ListView
    lateinit private var listSintomas: ListView
    lateinit private var listRemedies: ListView

    private val sintomasReference = Sintomas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_illness)

        recievedCauses = intent.getStringArrayListExtra("causes")
        recievedSintomas = intent.getIntegerArrayListExtra("sintomas")
        recievedRemedies = intent.getStringArrayListExtra("remedies")

        val allIllness = intent.getBooleanExtra("allIllness", true)
        if(allIllness == true){
            call_button_frame.visibility = View.GONE
        }
        listCauses = findViewById(R.id.illness_causes)
        listSintomas = findViewById(R.id.illness_sintomas)
        listRemedies = findViewById(R.id.illness_remedies)

        val causesAdapter = AdapterStringList(this, 0, recievedCauses)
        val sintomasAdapter = AdapterStringList(this, 0, getSintomasNames(recievedSintomas))
        val remediesAdapter = AdapterStringList(this, 0, recievedRemedies)

        listCauses.adapter = causesAdapter
        listSintomas.adapter = sintomasAdapter
        listRemedies.adapter = remediesAdapter

        call_button.setOnClickListener {
            val number = "112"
            try {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    private fun getSintomasNames(sintomasIDs: ArrayList<Int>): ArrayList<String>{
        var result = arrayListOf<String>()
        for (id in sintomasIDs){
            result.add(sintomasReference.getNameSintoma(id))
        }
        return result
    }
}
