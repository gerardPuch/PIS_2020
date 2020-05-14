package edu.ub.pis2020.gpuchcam7.mhealth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.AdapterSpinner
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.Sintomas
import edu.ub.pis2020.gpuchcam7.mhealth.Sintomas.SpinnerItem
import kotlinx.android.synthetic.main.fragment_sintomas.*

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

        //Establece los sintomas en los elementos de la lista
        setSintomasNames()

        var S1Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS1)
        S1.adapter = S1Adapter
        var S2Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS2)
        S2.adapter = S2Adapter
        var S3Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS3)
        S3.adapter = S3Adapter
        var S4Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS4)
        S4.adapter = S4Adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sintomas, container, false)
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

    fun Next(view: View) {
        val intent = Intent(activity, SintomasActivity::class.java)
        startActivity(intent)
    }

    fun setSintomasNames(){
        //Alucinacions
        Sintoma1.setText(ListSintomas.getSintoma(0))

        //Spinner 1 (S1) : Arritmies
            var S1Title: SpinnerItem = SpinnerItem()
            S1Title.initializeItem(ListSintomas.getSintoma(1))
            //Bardicardia
            var item1: SpinnerItem = SpinnerItem()
            item1.initializeItem(ListSintomas.getSintoma(2))
            //Taquicardia
            var item2: SpinnerItem = SpinnerItem()
            item2.initializeItem(ListSintomas.getSintoma(3))

            ListS1 = mutableListOf(S1Title, item1, item2)
        //Diarrea
        Sintoma2.setText(ListSintomas.getSintoma(4))
        //Disnea
        Sintoma3.setText(ListSintomas.getSintoma(5))
        //Spinner 2 (S2) : Dolor
            var S2Title: SpinnerItem = SpinnerItem()
            S2Title.initializeItem(ListSintomas.getSintoma(6))
            //Abdomen
            var item3: SpinnerItem = SpinnerItem()
            item3.initializeItem(ListSintomas.getSintoma(7))
            //Cap
            var item4: SpinnerItem = SpinnerItem()
            item4.initializeItem(ListSintomas.getSintoma(8))
            //Coll
            var item5: SpinnerItem = SpinnerItem()
            item5.initializeItem(ListSintomas.getSintoma(9))
            //Dents
            var item6: SpinnerItem = SpinnerItem()
            item6.initializeItem(ListSintomas.getSintoma(10))
            //Nas
            var item7: SpinnerItem = SpinnerItem()
            item7.initializeItem(ListSintomas.getSintoma(11))
            //Orelles
            var item8: SpinnerItem = SpinnerItem()
            item8.initializeItem(ListSintomas.getSintoma(12))
            //Osos
            var item9: SpinnerItem = SpinnerItem()
            item9.initializeItem(ListSintomas.getSintoma(13))
            //Parts Baixes
            var item10: SpinnerItem = SpinnerItem()
            item10.initializeItem(ListSintomas.getSintoma(14))
            //Pit
            var item11: SpinnerItem = SpinnerItem()
            item11.initializeItem(ListSintomas.getSintoma(15))
            //Ulls
            var item12: SpinnerItem = SpinnerItem()
            item12.initializeItem(ListSintomas.getSintoma(16))

            ListS2 = mutableListOf(S2Title, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12)
        //Spinner 3 (S3) : Dolor Articulacions
            var S3Title: SpinnerItem = SpinnerItem()
            S3Title.initializeItem(ListSintomas.getSintoma(17))
            //Articculacio_1
            var item13: SpinnerItem = SpinnerItem()
            item13.initializeItem(ListSintomas.getSintoma(18))

            ListS3 = mutableListOf(S3Title, item13)
        //Febre
        Sintoma4.setText(ListSintomas.getSintoma(19))
        //Mareig
        Sintoma5.setText(ListSintomas.getSintoma(20))
        //Mocs
        Sintoma6.setText(ListSintomas.getSintoma(21))
        //Nauseas
        Sintoma7.setText(ListSintomas.getSintoma(22))
        //Pèrdua de coneixement
        Sintoma8.setText(ListSintomas.getSintoma(23))
        //Spinner 4 (S4) : Sagnat
            var S4Title: SpinnerItem = SpinnerItem()
            S4Title.initializeItem(ListSintomas.getSintoma(24))
            //Forat1
            var item14: SpinnerItem = SpinnerItem()
            item14.initializeItem(ListSintomas.getSintoma(25))

            ListS4 = mutableListOf(S4Title, item14)
        //Tos
        Sintoma9.setText(ListSintomas.getSintoma(26))
        //Vómit
        Sintoma10.setText(ListSintomas.getSintoma(27))
    }
}
