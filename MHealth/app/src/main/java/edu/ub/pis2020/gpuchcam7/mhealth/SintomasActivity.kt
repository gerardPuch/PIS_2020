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
import com.google.firebase.firestore.QueryDocumentSnapshot
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.AdapterIllness
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.HarcodedDataBase
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.Illness
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.Sintomas
import kotlinx.android.synthetic.main.activity_sintomas.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await

class SintomasActivity : AppCompatActivity() {

    private val sintomasReference = Sintomas()
    lateinit private var listView: ListView
    //https://www.raywenderlich.com/155-android-listview-tutorial-with-kotlin

    private val db = FirebaseFirestore.getInstance()
    private val TAG = "SintomasActivity"

    lateinit private var selectedSintomas: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sintomas)
        listView = findViewById(R.id.found_sintomas)

        //Obtenemos el Boolean que determina si se muestran todas las enfermedades
        var allSelected = intent.getBooleanExtra("allSelected", true)

        //settingIllnessDB()

        val all_Illness: MutableList<Illness> = HarcodedDataBase().getHardcodedData() //base de datos local que contiene todas las enfermedades
        //getIllnessDB(all_Illness)

        var listItems = mutableListOf<Illness>() //Resultado de la búsqueda

        if(allSelected == false){
            var selectedSintomas = intent.getIntegerArrayListExtra("selecteds") //IDs de los sintomas seleccionados

            //Obtenemos todas las enfermedades que coincidan con los sintomas seleccionados
            listItems = searchIllnessCoincidence(all_Illness, selectedSintomas)
            //listItems = searchIllnessCoincidence(all_Illness, arrayListOf(0,1,2,3))

            if(listItems.size == 0){
                textView_sintomas_activity.text = " No s'ha trobat cap enfermetat, \n Prova de seleccionar més Símptomes "
            }
        }else{
            listItems = all_Illness

            if(listItems.size == 0){
                textView_sintomas_activity.text = " No hi han enfermetats que mostrar "
            }
        }

        //Asociar adapter
        val adapter = AdapterIllness(this, 0, listItems)
        listView.adapter = adapter
    }

    //Función que devuelve una lista de las enfermedades con 2 o mas sintomas coincidentes.
    private fun searchIllnessCoincidence(illness: MutableList<Illness>, sintomas: ArrayList<Int>): MutableList<Illness>{
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
        //Corrige los resultados: estableciendo el porcentaje de coincidencia y asignando un color al indice de coincidencia
        return correctResult(resultList)
    }

    private fun correctResult(list: MutableList<Illness>): MutableList<Illness> {
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

        //list.sortBy { it.getIllnessCoincidenceValue() }

        return list
    }

    fun settingIllnessDB(){
        var illnessList = arrayListOf<Illness>()

        val illness_A :Illness = Illness("A")
        illness_A.addIllnessSintoma(0)
        illness_A.addIllnessSintoma(1)
        illness_A.addIllnessSintoma(2)
        illness_A.addIllnessSintoma(3)
        illnessList.add(illness_A)

        db.collection("illness").document(illness_A.getIllnessName())
            .set(illness_A)
            .addOnSuccessListener { documentReference -> Log.d(TAG, "DocumentSnapshot succesfully written!") }
            .addOnFailureListener {e -> Log.w(TAG, "Error writting document", e) }


        val illness_B :Illness = Illness("B")
        illness_B.addIllnessSintoma(0)
        illness_B.addIllnessSintoma(1)
        illness_B.addIllnessSintoma(2)
        illnessList.add(illness_B)

        db.collection("illness").document(illness_B.getIllnessName())
            .set(illness_B)
            .addOnSuccessListener { documentReference -> Log.d(TAG, "DocumentSnapshot succesfully written!") }
            .addOnFailureListener {e -> Log.w(TAG, "Error writting document", e) }


        val illness_C :Illness = Illness("C")
        illness_C.addIllnessSintoma(0)
        illness_C.addIllnessSintoma(1)
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

    //
    fun getIllnessDB(dbList: MutableList<Illness>){
        val coleccio = db.collection("illness")
        coleccio
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    var instance = Illness(
                        document.data["illnessName"] as String,
                        document.data["illnessCauses"] as ArrayList<String>,
                        document.data["illnessSintomas"] as MutableList<Int>,
                        document.data["illnessRemedies"] as MutableList<String>)
                    dbList.add(instance)
                }
            }
            .addOnFailureListener{ exception ->
                Log.w(TAG, "Error getting documents", exception)
            }
    }
}
