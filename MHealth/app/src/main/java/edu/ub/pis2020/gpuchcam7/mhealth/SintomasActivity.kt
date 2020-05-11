package edu.ub.pis2020.gpuchcam7.mhealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.Illness

class SintomasActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    //https://www.raywenderlich.com/155-android-listview-tutorial-with-kotlin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sintomas)

        // Crear lista de enfermedades i cargarlas
        /*for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listItems[i] = recipe.title
        }*/

        //HARDCODED EJEMPLO

        val ilness_A :Illness = Illness("A")
        ilness_A.addIllnessSintoma("Símptoma 2")
        ilness_A.addIllnessSintoma("Símptoma 3")
        val ilness_B :Illness = Illness("B")
        ilness_B.addIllnessSintoma("Símptoma 2")
        val ilness_C :Illness = Illness("C")

        val all_Illness: MutableList<Illness> = mutableListOf(ilness_A, ilness_B, ilness_C)

        val listItems = searchIllnessCoincidence()

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
