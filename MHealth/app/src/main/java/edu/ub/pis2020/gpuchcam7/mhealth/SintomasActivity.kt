package edu.ub.pis2020.gpuchcam7.mhealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import com.google.firebase.database.core.Tag
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.Illness

class SintomasActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    //https://www.raywenderlich.com/155-android-listview-tutorial-with-kotlin
    val db = FirebaseFirestore.getInstance()

    val TAG = "SintomasActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sintomas)

        // Crear lista de enfermedades i cargarlas
        /*for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listItems[i] = recipe.title
        }*/

        settingIllnessDB()

        //val all_Illness: MutableList<Illness> =

        //val listItems = searchIllnessCoincidence(all_Illness, mutableListOf("Símptoma 1", "Símptoma 2", "Símptoma 3"))

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

    /*fun getIllnessDB(): MutableList<Illness>{

    }*/

    fun settingIllnessDB(){
        //HARDCODED EJEMPLO

        val illness_A :Illness = Illness("A")
        illness_A.addIllnessSintoma("Símptoma 2")
        illness_A.addIllnessSintoma("Símptoma 4")
        val illness_B :Illness = Illness("B")
        illness_B.addIllnessSintoma("Símptoma 2")
        val illness_C :Illness = Illness("C")

        db.collection("illness").document(illness_A.getIllnessName())
            .set(illness_A)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot succesfully written!")
            }
            .addOnFailureListener {e ->
                Log.w(TAG, "Error writting document", e)
            }

        /*db.collection("illness")
            .add(illness_db)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener {e ->
                Log.w(TAG, "Error adding document", e)
            }*/

        Toast.makeText(this, "CoronaVirus añadido a la coleccion", Toast.LENGTH_SHORT).show()

    }
}
