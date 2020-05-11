package edu.ub.pis2020.gpuchcam7.mhealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView

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

        val listItems = arrayOfNulls<String>()

        // Asociar adapter

        //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        //listView.adapter = adapter
    }
}
