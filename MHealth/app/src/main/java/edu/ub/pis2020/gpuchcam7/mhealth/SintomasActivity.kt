package edu.ub.pis2020.gpuchcam7.mhealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import com.google.android.material.tabs.TabLayout
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.Illness

class SintomasActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    //https://www.raywenderlich.com/155-android-listview-tutorial-with-kotlin
    //val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sintomas)

        // Crear lista de enfermedades i cargarlas
        /*for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listItems[i] = recipe.title
        }*/

        //HARDCODED EJEMPLO

        val illness_A :Illness = Illness("A")
        illness_A.addIllnessSintoma("Símptoma 2")
        illness_A.addIllnessSintoma("Símptoma 3")
        val illness_B :Illness = Illness("B")
        illness_B.addIllnessSintoma("Símptoma 2")
        val illness_C :Illness = Illness("C")

        /*val illness_db = hashMapOf(
            "name" to "CoronaVirus",
            "causes" to "alarmismo",
            "sintomas" to "tos seca",
            "remedies" to "encerrarse"
        )*/

        /*val illness_db = hashMapOf(
            "name" to illness_A.getIllnessName(),
            "causes" to illness_A.getIllnessCauses(),
            "sintomas" to illness_A.getIllnessSintomas(),
            "remedies" to illness_A.getIllnessRemedies()
        )*/

        /*db.collection("illness")
            .add(illness_db)
            .addOnSuccessListener { documentReference ->
                Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener {e ->
                Log.w("TAG", "Error adding document", e)
            }*/

        val all_Illness: MutableList<Illness> = mutableListOf(illness_A, illness_B, illness_C)

        val listItems = searchIllnessCoincidence(all_Illness, mutableListOf("Símptoma 1", "Símptoma 2", "Símptoma 3"))

        // Asociar adapter

        //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        //listView.adapter = adapter
    }

    fun searchIllnessCoincidence(illness: MutableList<Illness>, sintomas: MutableList<String>): MutableList<Illness>{
        var list: MutableList<Illness> = mutableListOf()

        //Busqueda Lineal
        for (item in illness){

        }

        return illness
    }
}
