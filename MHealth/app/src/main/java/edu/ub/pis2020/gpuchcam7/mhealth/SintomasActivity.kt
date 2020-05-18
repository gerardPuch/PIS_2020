package edu.ub.pis2020.gpuchcam7.mhealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.size
import com.google.android.material.tabs.TabLayout
import com.google.firebase.database.core.Tag
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.AdapterIllness
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.Illness
import kotlinx.android.synthetic.main.activity_sintomas.*

class SintomasActivity : AppCompatActivity() {

    lateinit var listView: ListView
    //https://www.raywenderlich.com/155-android-listview-tutorial-with-kotlin
    val db = FirebaseFirestore.getInstance()
    val TAG = "SintomasActivity"

    lateinit var selectedSintomas: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sintomas)

        listView = findViewById(R.id.found_sintomas)

        var selectedSintomas = intent.getStringArrayListExtra("selecteds")
        //settingIllnessDB()
        val all_Illness: MutableList<Illness> = getHARDCODEDIllnessDB()
        val listItems = searchIllnessCoincidence(all_Illness, selectedSintomas)
        //Corrige los resultados: estableciendo el porcentaje de coincidencia y asignando un color al indice de coincidencia
        correctResult(listItems)

        //Asociar adapter

        val adapter = AdapterIllness(this, 0, listItems)
        listView.adapter = adapter
    }

    fun correctResult(list: MutableList<Illness>) {
        var listSize = list.size
        var maxValue = 0
        list.forEach {
            if (it.getIllnessCoincidenceValue() > maxValue){
                maxValue = it.getIllnessCoincidenceValue()
            }
        }

        var colorValue = 0
        list.forEach {
            colorValue = (it.getIllnessCoincidenceValue()*100)/maxValue
            it.setIllnessCoincidenceColor(colorValue)
        }
    }

    fun searchIllnessCoincidence(illness: MutableList<Illness>, sintomas: ArrayList<String>): MutableList<Illness>{
        var resultList: MutableList<Illness> = mutableListOf()
        var counter = 0
        //Busqueda Secuencial O(n)
        for (item in illness){
            counter = 0

            for (it in sintomas){
                if(item.getIllnessSintomas().contains(it)){
                    counter++
                }
            }
            if(counter > 1){
                item.setIllnessCoincidenceValue(counter)
                resultList.add(item)
            }
        }
        return resultList
    }

    fun getIllnessDB(): MutableList<Illness>{
        val dbList =  mutableListOf<Illness>()
        val cities = ArrayList<Illness>()


        var coleccio = db.collection("illness")
            .get()
            .addOnSuccessListener { documents ->
            for (document in documents) {
                Log.d(TAG, "${document.id} => ${document.data}")

            } }
            .addOnFailureListener{ exception ->
                Log.w(TAG, "Error getting documents", exception)
            }

        val query = db.collection("illness")
        val registration = query.addSnapshotListener { snapshots, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                return@addSnapshotListener
            }
            for (doc in snapshots!!) {
                var instance = Illness(
                    doc.getData().get("illnessName") as String,
                    doc.getData().get("illnessCauses") as ArrayList<String>,
                    doc.getData().get("illnessSintomas") as MutableList<String>,
                    doc.getData().get("illnessRemedies") as MutableList<String>)
                dbList.add(instance)
                cities.add(instance)
            }

            Log.d(TAG, "Current cites in CA: $cities")
        }

        registration.remove()

            /*var testMap = it.getData()
            var instance = Illness(
                testMap!!.get("illnessName") as String,
                testMap!!.get("illnessCauses") as ArrayList<String>,
                testMap!!.get("illnessSintomas") as MutableList<String>,
                testMap!!.get("illnessRemedies") as MutableList<String>)
            dbList.add(instance)*/
        return dbList
    }

    fun settingIllnessDB(){
        //HARDCODED EJEMPLO
        var illnessList = arrayListOf<Illness>()

        val illness_A :Illness = Illness("A")
        illness_A.addIllnessSintoma("Símptoma 2")
        illness_A.addIllnessSintoma("Símptoma 3")
        illnessList.add(illness_A)

        db.collection("illness").document(illness_A.getIllnessName())
            .set(illness_A)
            .addOnSuccessListener { documentReference -> Log.d(TAG, "DocumentSnapshot succesfully written!") }
            .addOnFailureListener {e -> Log.w(TAG, "Error writting document", e) }


        val illness_B :Illness = Illness("B")
        illness_B.addIllnessSintoma("Símptoma 2")
        illnessList.add(illness_B)

        db.collection("illness").document(illness_B.getIllnessName())
            .set(illness_B)
            .addOnSuccessListener { documentReference -> Log.d(TAG, "DocumentSnapshot succesfully written!") }
            .addOnFailureListener {e -> Log.w(TAG, "Error writting document", e) }


        val illness_C :Illness = Illness("C")
        illnessList.add(illness_C)

        db.collection("illness").document(illness_C.getIllnessName())
            .set(illness_C)
            .addOnSuccessListener { documentReference ->Log.d(TAG, "DocumentSnapshot succesfully written!") }
            .addOnFailureListener {e -> Log.w(TAG, "Error writting document", e) }

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

    fun getHARDCODEDIllnessDB(): ArrayList<Illness> {
        //HARDCODED EJEMPLO
        var illnessList = arrayListOf<Illness>()

        val illness_A :Illness = Illness("A")
        illness_A.addIllnessSintoma("Símptoma 2")
        illness_A.addIllnessSintoma("Símptoma 3")
        illnessList.add(illness_A)

        val illness_B :Illness = Illness("B")
        illness_B.addIllnessSintoma("Símptoma 2")
        illnessList.add(illness_B)

        val illness_C :Illness = Illness("C")
        illnessList.add(illness_C)

        return illnessList
    }
}
