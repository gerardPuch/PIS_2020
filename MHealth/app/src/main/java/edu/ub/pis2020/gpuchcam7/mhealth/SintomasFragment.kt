 package edu.ub.pis2020.gpuchcam7.mhealth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.core.view.children
import androidx.core.view.get
import androidx.core.view.size
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.AdapterSpinner
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.Sintomas
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.SpinnerItem
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.ViewHolder
import kotlinx.android.synthetic.main.fragment_sintomas.*
import kotlinx.android.synthetic.main.fragment_sintomas.view.*
import kotlinx.android.synthetic.main.spinner_item.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [SintomasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SintomasFragment : Fragment() {

    lateinit var ListSintomas: Sintomas

    lateinit var S1: Spinner
    lateinit var ListS1: MutableList<SpinnerItem>

    lateinit var S2: Spinner
    lateinit var ListS2: MutableList<SpinnerItem>

    lateinit var S3: Spinner
    lateinit var ListS3: MutableList<SpinnerItem>

    lateinit var S4: Spinner
    lateinit var ListS4: MutableList<SpinnerItem>

    lateinit var S5: Spinner
    lateinit var ListS5: MutableList<SpinnerItem>

    lateinit var S6: Spinner
    lateinit var ListS6: MutableList<SpinnerItem>

    lateinit var S7: Spinner
    lateinit var ListS7: MutableList<SpinnerItem>

    lateinit var S8: Spinner
    lateinit var ListS8: MutableList<SpinnerItem>

    lateinit var S9: Spinner
    lateinit var ListS9: MutableList<SpinnerItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.ListSintomas = Sintomas()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Asocio los Spinners del Layout para trabajar con ellos
        S1 = Spinner1
        S2 = Spinner2
        S3 = Spinner3
        S4 = Spinner4
        S5 = Spinner5
        S6 = Spinner6
        S7 = Spinner7
        S8 = Spinner8
        S9 = Spinner9

        //Establece los sintomas en los elementos de la lista
        setSintomas()

        var S1Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS1)
        S1.adapter = S1Adapter
        var S2Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS2)
        S2.adapter = S2Adapter
        var S3Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS3)
        S3.adapter = S3Adapter
        var S4Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS4)
        S4.adapter = S4Adapter
        var S5Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS5)
        S5.adapter = S5Adapter
        var S6Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS6)
        S6.adapter = S6Adapter
        var S7Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS7)
        S7.adapter = S7Adapter
        var S8Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS8)
        S8.adapter = S8Adapter
        var S9Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS9)
        S9.adapter = S9Adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sintomas, container, false)

        view.btnNext.setOnClickListener { view ->
            openActivity()
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         **/
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SintomasFragment().apply {}
    }

    fun openActivity() {
        var selected = substractSintomasChecked()
        val intent = Intent(activity, SintomasActivity::class.java)
        intent.putIntegerArrayListExtra("selecteds", selected)
        startActivity(intent)
    }

    fun substractSintomasChecked(): ArrayList<Int>{
        var result = arrayListOf<Int>()
        var spinners = mutableListOf<Spinner>(S1, S2, S3, S4, S5, S6, S7, S8, S9)

        var checkBoxes = mutableListOf<CheckBox>(
            Sintoma1, Sintoma2, Sintoma3, Sintoma4, Sintoma5,
            Sintoma6, Sintoma7, Sintoma8, Sintoma9, Sintoma10,
            Sintoma11, Sintoma12, Sintoma13, Sintoma14, Sintoma15,
            Sintoma16, Sintoma17, Sintoma18, Sintoma19, Sintoma20,
            Sintoma21, Sintoma22, Sintoma23, Sintoma24, Sintoma25,
            Sintoma26, Sintoma27, Sintoma28, Sintoma29, Sintoma30,
            Sintoma31, Sintoma32, Sintoma33, Sintoma34, Sintoma35)

        for (it in spinners){
            var spinnerRoot = it.adapter.getItem(0) as SpinnerItem
            var spinnerName = spinnerRoot.getTextItem()
            for (i in 0..it.adapter.count-1){ // numero de SpinnerItems
                var aux = it.adapter.getItem(i) as SpinnerItem
                if(aux.isSelected()){
                    result.add(ListSintomas.getSintomaID(ListSintomas.getCodeSintoma(aux.text, spinnerName)))
                }
            }
        }

        for (it in checkBoxes){
            if(it.isChecked){
                result.add(ListSintomas.getSintomaID(it.text.toString()))
            }
        }

        /*for (it in spinners){
            for (i in 0..it.adapter.count-1){ // numero de SpinnerItems
                var aux = it.adapter.getItem(i) as SpinnerItem
                var check = CheckBox(context)
                check.text = aux.getTextItem()
                check.isChecked = aux.isSelected()
                checkBoxes.add(check)
            }
        }

        for (it in checkBoxes){
            if(it.isChecked){
                result.add(it.text.toString())
            }
        }*/

        return result
    }

    fun setSintomas(){
        //Acropàquies
        Sintoma1.setText(ListSintomas.getSintoma(0))
        //Afonia
        Sintoma2.setText(ListSintomas.getSintoma(1))
        //Alucinacions
        Sintoma3.setText(ListSintomas.getSintoma(2))
        //Alteració de la consciència
        Sintoma4.setText(ListSintomas.getSintoma(3))
        //Ansietat
        Sintoma5.setText(ListSintomas.getSintoma(4))
        //Apnea nocturna
        Sintoma6.setText(ListSintomas.getSintoma(5))

        //Spinner 1 (S1) : Arritmies
            var S1Title: SpinnerItem = SpinnerItem()
            S1Title.initializeItem(ListSintomas.getSintoma(6))
            //Bardicardia_A
            var item1: SpinnerItem = SpinnerItem()
            item1.initializeItem(ListSintomas.getNameSintoma(7))
            //Taquicardia_A
            var item2: SpinnerItem = SpinnerItem()
            item2.initializeItem(ListSintomas.getNameSintoma(8))

            ListS1 = mutableListOf(S1Title, item1, item2)

        //Brunzit d'orelles
        Sintoma7.setText(ListSintomas.getSintoma(9))
        //Convulsions
        Sintoma8.setText(ListSintomas.getSintoma(10))

        //Spinner 2 (S2) : Debilitat
            var S2Title: SpinnerItem = SpinnerItem()
            S2Title.initializeItem(ListSintomas.getSintoma(11))
            //General_DE
            var item3: SpinnerItem = SpinnerItem()
            item3.initializeItem(ListSintomas.getNameSintoma(12))
            //Part del cos_1_DE
            var item4: SpinnerItem = SpinnerItem()
            item4.initializeItem(ListSintomas.getNameSintoma(13))

            ListS2 = mutableListOf(S2Title, item3, item4)

        //Diarrea
        Sintoma9.setText(ListSintomas.getSintoma(14))
        //Disfagia
        Sintoma10.setText(ListSintomas.getSintoma(15))
        //Disnea
        Sintoma11.setText(ListSintomas.getSintoma(16))

        //Spinner 3 (S3) : Dolor
            var S3Title: SpinnerItem = SpinnerItem()
            S3Title.initializeItem(ListSintomas.getSintoma(17))
            //Abdomen_D
            var item5: SpinnerItem = SpinnerItem()
            item5.initializeItem(ListSintomas.getNameSintoma(18))
            //Cap_D
            var item6: SpinnerItem = SpinnerItem()
            item6.initializeItem(ListSintomas.getNameSintoma(19))
            //Coll_D
            var item7: SpinnerItem = SpinnerItem()
            item7.initializeItem(ListSintomas.getNameSintoma(20))
            //Dents_D
            var item8: SpinnerItem = SpinnerItem()
            item8.initializeItem(ListSintomas.getNameSintoma(21))
            //Nas_D
            var item9: SpinnerItem = SpinnerItem()
            item9.initializeItem(ListSintomas.getNameSintoma(22))
            //Orelles_D
            var item10: SpinnerItem = SpinnerItem()
            item10.initializeItem(ListSintomas.getNameSintoma(23))
            //Osos_D
            var item11: SpinnerItem = SpinnerItem()
            item11.initializeItem(ListSintomas.getNameSintoma(24))
            //Parts Baixes_D
            var item12: SpinnerItem = SpinnerItem()
            item12.initializeItem(ListSintomas.getNameSintoma(25))
            //Pit_D
            var item13: SpinnerItem = SpinnerItem()
            item13.initializeItem(ListSintomas.getNameSintoma(26))
            //Ulls_D
            var item14: SpinnerItem = SpinnerItem()
            item14.initializeItem(ListSintomas.getNameSintoma(27))

            ListS3 = mutableListOf(S3Title, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14)

        //Spinner 4 (S4) : Dolor articulacions
            var S4Title: SpinnerItem = SpinnerItem()
            S4Title.initializeItem(ListSintomas.getSintoma(28))
            //Articculacio_1_AT
            var item15: SpinnerItem = SpinnerItem()
            item15.initializeItem(ListSintomas.getNameSintoma(29))

            ListS4 = mutableListOf(S4Title, item15)

        //Espasmes
        Sintoma12.setText(ListSintomas.getSintoma(30))
        //Fatiga
        Sintoma13.setText(ListSintomas.getSintoma(31))
        //Febre
        Sintoma14.setText(ListSintomas.getSintoma(32))
        //Halitosi
        Sintoma15.setText(ListSintomas.getSintoma(33))
        //Icterícia
        Sintoma16.setText(ListSintomas.getSintoma(34))

        //Spinner 5 (S5) : Inflat
            var S5Title: SpinnerItem = SpinnerItem()
            S5Title.initializeItem(ListSintomas.getSintoma(35))
            //Part del cos_1_I
            var item16: SpinnerItem = SpinnerItem()
            item16.initializeItem(ListSintomas.getNameSintoma(36))

            ListS5 = mutableListOf(S5Title, item16)

        //Mareig
        Sintoma17.setText(ListSintomas.getSintoma(37))
        //Mocs
        Sintoma18.setText(ListSintomas.getSintoma(38))
        //Mort
        Sintoma19.setText(ListSintomas.getSintoma(39))
        //Nauseas
        Sintoma20.setText(ListSintomas.getSintoma(44))
        //Palidesa
        Sintoma21.setText(ListSintomas.getSintoma(41))
        //Paràlisi
        Sintoma22.setText(ListSintomas.getSintoma(42))
        //Pèrdua de coneixement
        Sintoma23.setText(ListSintomas.getSintoma(43))
        //Pèrdua de gana
        Sintoma24.setText(ListSintomas.getSintoma(44))
        //Pèrdua de pes
        Sintoma25.setText(ListSintomas.getSintoma(45))

        //Spinner 6 (S6) : Pèrdua de sensibilitat
            var S6Title: SpinnerItem = SpinnerItem()
            S6Title.initializeItem(ListSintomas.getSintoma(46))
            //Part del cos_1_SE
            var item17: SpinnerItem = SpinnerItem()
            item17.initializeItem(ListSintomas.getNameSintoma(47))

            ListS6 = mutableListOf(S6Title, item17)

        //Spinner 7 (S7) : Pupiles
            var S7Title: SpinnerItem = SpinnerItem()
            S7Title.initializeItem(ListSintomas.getSintoma(48))
            //Contretes_P
            var item18: SpinnerItem = SpinnerItem()
            item18.initializeItem(ListSintomas.getNameSintoma(49))
            //Dilatades_P
            var item19: SpinnerItem = SpinnerItem()
            item19.initializeItem(ListSintomas.getNameSintoma(50))

            ListS7 = mutableListOf(S7Title, item18, item19)

        //Spinner 8 (S8) : Respiració
            var S8Title: SpinnerItem = SpinnerItem()
            S8Title.initializeItem(ListSintomas.getSintoma(51))
            //Taquipnea_R
            var item20: SpinnerItem = SpinnerItem()
            item20.initializeItem(ListSintomas.getNameSintoma(52))
            //Bradipnea_R
            var item21: SpinnerItem = SpinnerItem()
            item21.initializeItem(ListSintomas.getNameSintoma(53))

            ListS8 = mutableListOf(S8Title, item20, item21)

        //Rigidesa al clatell
        Sintoma26.setText(ListSintomas.getSintoma(54))
        //Roncs
        Sintoma27.setText(ListSintomas.getSintoma(55))

        //Spinner 9 (S9) : Sagnat
            var S9Title: SpinnerItem = SpinnerItem()
            S9Title.initializeItem(ListSintomas.getSintoma(56))
            //Forat1_S
            var item22: SpinnerItem = SpinnerItem()
            item22.initializeItem(ListSintomas.getNameSintoma(57))

            ListS9 = mutableListOf(S9Title, item22)

        //Secreció retral
        Sintoma28.setText(ListSintomas.getSintoma(58))
        //Son
        Sintoma29.setText(ListSintomas.getSintoma(59))
        //Suor
        Sintoma30.setText(ListSintomas.getSintoma(60))
        //Tos
        Sintoma31.setText(ListSintomas.getSintoma(61))
        //Úlceres
        Sintoma32.setText(ListSintomas.getSintoma(62))
        //Visió borrosa
        Sintoma33.setText(ListSintomas.getSintoma(63))
        //Vómit
        Sintoma34.setText(ListSintomas.getSintoma(64))
        //Xiulets al respirar
        Sintoma35.setText(ListSintomas.getSintoma(65))
    }
}
