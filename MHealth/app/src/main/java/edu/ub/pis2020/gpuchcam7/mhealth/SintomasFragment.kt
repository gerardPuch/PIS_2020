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

    lateinit private var ListSintomas: Sintomas

    lateinit var S1: Spinner; lateinit var ListS1: MutableList<SpinnerItem>
    lateinit var S2: Spinner; lateinit var ListS2: MutableList<SpinnerItem>
    lateinit var S3: Spinner; lateinit var ListS3: MutableList<SpinnerItem>
    lateinit var S4: Spinner; lateinit var ListS4: MutableList<SpinnerItem>
    lateinit var S5: Spinner; lateinit var ListS5: MutableList<SpinnerItem>
    lateinit var S6: Spinner; lateinit var ListS6: MutableList<SpinnerItem>
    lateinit var S7: Spinner; lateinit var ListS7: MutableList<SpinnerItem>
    lateinit var S8: Spinner; lateinit var ListS8: MutableList<SpinnerItem>
    lateinit var S9: Spinner; lateinit var ListS9: MutableList<SpinnerItem>
    lateinit var S10: Spinner; lateinit var ListS10: MutableList<SpinnerItem>
    lateinit var S11: Spinner; lateinit var ListS11: MutableList<SpinnerItem>
    lateinit var S12: Spinner; lateinit var ListS12: MutableList<SpinnerItem>
    lateinit var S13: Spinner; lateinit var ListS13: MutableList<SpinnerItem>
    lateinit var S14: Spinner; lateinit var ListS14: MutableList<SpinnerItem>
    lateinit var S15: Spinner; lateinit var ListS15: MutableList<SpinnerItem>
    lateinit var S16: Spinner; lateinit var ListS16: MutableList<SpinnerItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.ListSintomas = Sintomas()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Asocio los Spinners del Layout para trabajar con ellos
        S1 = Spinner1; S2 = Spinner2
        S3 = Spinner3; S4 = Spinner4
        S5 = Spinner5; S6 = Spinner6
        S7 = Spinner7; S8 = Spinner8
        S9 = Spinner9; S10 = Spinner10
        S11 = Spinner11; S12 = Spinner12
        S13 = Spinner13; S14 = Spinner14
        S15 = Spinner15; S16 = Spinner16

        //Establece los sintomas en los elementos de la lista
        setSintomas()

        var S1Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS1); S1.adapter = S1Adapter
        var S2Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS2); S2.adapter = S2Adapter
        var S3Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS3); S3.adapter = S3Adapter
        var S4Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS4); S4.adapter = S4Adapter
        var S5Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS5); S5.adapter = S5Adapter
        var S6Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS6); S6.adapter = S6Adapter
        var S7Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS7); S7.adapter = S7Adapter
        var S8Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS8); S8.adapter = S8Adapter
        var S9Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS9); S9.adapter = S9Adapter
        var S10Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS10); S10.adapter = S10Adapter
        var S11Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS11); S11.adapter = S11Adapter
        var S12Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS12); S12.adapter = S12Adapter
        var S13Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS13); S13.adapter = S13Adapter
        var S14Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS14); S14.adapter = S14Adapter
        var S15Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS15); S15.adapter = S15Adapter
        var S16Adapter: AdapterSpinner = AdapterSpinner(activity!!, 0, ListS16); S16.adapter = S16Adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sintomas, container, false)

        view.btnNext.setOnClickListener { view ->
            openActivity(false)
        }

        view.btnAll.setOnClickListener { view ->
            openActivity(true)
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


    private fun openActivity(allSelected: Boolean) {
        if(allSelected == true){
            var selected = arrayListOf<Int>()
            val intent = Intent(activity, SintomasActivity::class.java)
            intent.putIntegerArrayListExtra("selecteds", selected)
            intent.putExtra("allSelected", allSelected)
            startActivity(intent)
        }else{
            var selected = substractSintomasChecked()
            val intent = Intent(activity, SintomasActivity::class.java)
            intent.putIntegerArrayListExtra("selecteds", selected)
            intent.putExtra("allSelected", allSelected)
            startActivity(intent)
        }
    }

    //Función que devuelve el ID de los sintomas marcados
    private fun substractSintomasChecked(): ArrayList<Int>{
        var result = arrayListOf<Int>()
        var spinners = mutableListOf<Spinner>(S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16)

        var checkBoxes = mutableListOf<CheckBox>(
            Sintoma0, Sintoma1, Sintoma2, Sintoma3, Sintoma4, Sintoma5,
            Sintoma6, Sintoma7, Sintoma8, Sintoma9, Sintoma10, Sintoma14,
            Sintoma15, Sintoma19, Sintoma20, Sintoma21, Sintoma29, Sintoma30,
            Sintoma31, Sintoma32, Sintoma33, Sintoma55, Sintoma56, Sintoma57,
            Sintoma58, Sintoma59, Sintoma63, Sintoma64, Sintoma65, Sintoma66,
            Sintoma71, Sintoma72, Sintoma73, Sintoma74, Sintoma75, Sintoma76,
            Sintoma77, Sintoma78, Sintoma79, Sintoma80, Sintoma88, Sintoma89,
            Sintoma90, Sintoma91, Sintoma92, Sintoma109, Sintoma110, Sintoma111,
            Sintoma112, Sintoma118, Sintoma123, Sintoma124, Sintoma125, Sintoma132,
            Sintoma137, Sintoma138, Sintoma139, Sintoma140, Sintoma141, Sintoma142)

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
        return result
    }

    //Función que asocia cada checkbox e spinner con sus respectivo sintoma
    private fun setSintomas(){

        Sintoma0.setText(ListSintomas.getSintoma(0))
        Sintoma1.setText(ListSintomas.getSintoma(1))
        Sintoma2.setText(ListSintomas.getSintoma(2))
        Sintoma3.setText(ListSintomas.getSintoma(3))
        Sintoma4.setText(ListSintomas.getSintoma(4))
        Sintoma5.setText(ListSintomas.getSintoma(5))
        Sintoma6.setText(ListSintomas.getSintoma(6))
        Sintoma7.setText(ListSintomas.getSintoma(7))
        Sintoma8.setText(ListSintomas.getSintoma(8))
        Sintoma9.setText(ListSintomas.getSintoma(9))
        Sintoma10.setText(ListSintomas.getSintoma(10))

        //Spinner 1 (S1) : Arritmies
            var S1Title: SpinnerItem = SpinnerItem()
            S1Title.initializeItem(ListSintomas.getSintoma(11))
            var item1: SpinnerItem = SpinnerItem()
            item1.initializeItem(ListSintomas.getNameSintoma(12))
            var item2: SpinnerItem = SpinnerItem()
            item2.initializeItem(ListSintomas.getNameSintoma(13))

            ListS1 = mutableListOf(S1Title, item1, item2)

        Sintoma14.setText(ListSintomas.getSintoma(14))
        Sintoma15.setText(ListSintomas.getSintoma(15))

        //Spinner 2 (S2) : Butllofes
            var S2Title: SpinnerItem = SpinnerItem()
            S2Title.initializeItem(ListSintomas.getSintoma(16))
            var item3: SpinnerItem = SpinnerItem()
            item3.initializeItem(ListSintomas.getNameSintoma(17))
            var item4: SpinnerItem = SpinnerItem()
            item4.initializeItem(ListSintomas.getNameSintoma(18))

            ListS2 = mutableListOf(S2Title, item3, item4)

        Sintoma19.setText(ListSintomas.getSintoma(19))
        Sintoma20.setText(ListSintomas.getSintoma(20))
        Sintoma21.setText(ListSintomas.getSintoma(21))

        //Spinner 3 (S3) : Debilitat
            var S3Title: SpinnerItem = SpinnerItem()
            S3Title.initializeItem(ListSintomas.getSintoma(22))
            var item5: SpinnerItem = SpinnerItem()
            item5.initializeItem(ListSintomas.getNameSintoma(23))
            var item6: SpinnerItem = SpinnerItem()
            item6.initializeItem(ListSintomas.getNameSintoma(24))
            var item7: SpinnerItem = SpinnerItem()
            item7.initializeItem(ListSintomas.getNameSintoma(25))
            var item8: SpinnerItem = SpinnerItem()
            item8.initializeItem(ListSintomas.getNameSintoma(26))
            var item9: SpinnerItem = SpinnerItem()
            item9.initializeItem(ListSintomas.getNameSintoma(27))
            var item10: SpinnerItem = SpinnerItem()
            item10.initializeItem(ListSintomas.getNameSintoma(28))

            ListS3 = mutableListOf(S3Title, item5, item6, item7, item8, item9, item10)

        Sintoma29.setText(ListSintomas.getSintoma(29))
        Sintoma30.setText(ListSintomas.getSintoma(30))
        Sintoma31.setText(ListSintomas.getSintoma(31))
        Sintoma32.setText(ListSintomas.getSintoma(32))
        Sintoma33.setText(ListSintomas.getSintoma(33))

        //Spinner 4 (S5) : Dolor
            var S4Title: SpinnerItem = SpinnerItem()
            S4Title.initializeItem(ListSintomas.getSintoma(34))
            var item11: SpinnerItem = SpinnerItem()
            item11.initializeItem(ListSintomas.getNameSintoma(35))
            var item12: SpinnerItem = SpinnerItem()
            item12.initializeItem(ListSintomas.getNameSintoma(36))
            var item13: SpinnerItem = SpinnerItem()
            item13.initializeItem(ListSintomas.getNameSintoma(37))
            var item14: SpinnerItem = SpinnerItem()
            item14.initializeItem(ListSintomas.getNameSintoma(38))
            var item15: SpinnerItem = SpinnerItem()
            item15.initializeItem(ListSintomas.getNameSintoma(39))
            var item16: SpinnerItem = SpinnerItem()
            item16.initializeItem(ListSintomas.getNameSintoma(40))
            var item17: SpinnerItem = SpinnerItem()
            item17.initializeItem(ListSintomas.getNameSintoma(41))
            var item18: SpinnerItem = SpinnerItem()
            item18.initializeItem(ListSintomas.getNameSintoma(42))
            var item19: SpinnerItem = SpinnerItem()
            item19.initializeItem(ListSintomas.getNameSintoma(43))
            var item20: SpinnerItem = SpinnerItem()
            item20.initializeItem(ListSintomas.getNameSintoma(44))
            var item21: SpinnerItem = SpinnerItem()
            item21.initializeItem(ListSintomas.getNameSintoma(45))
            var item22: SpinnerItem = SpinnerItem()
            item22.initializeItem(ListSintomas.getNameSintoma(46))
            var item23: SpinnerItem = SpinnerItem()
            item23.initializeItem(ListSintomas.getNameSintoma(47))
            var item24: SpinnerItem = SpinnerItem()
            item24.initializeItem(ListSintomas.getNameSintoma(48))

            ListS4 = mutableListOf(S4Title, item11, item12, item13, item14, item15, item16, item17, item18, item19, item20, item21, item22, item23, item24)

        //Spinner 5 (S5) : Dolor articulacions
            var S5Title: SpinnerItem = SpinnerItem()
            S5Title.initializeItem(ListSintomas.getSintoma(49))
            var item25: SpinnerItem = SpinnerItem()
            item25.initializeItem(ListSintomas.getNameSintoma(50))
            var item26: SpinnerItem = SpinnerItem()
            item26.initializeItem(ListSintomas.getNameSintoma(51))
            var item27: SpinnerItem = SpinnerItem()
            item27.initializeItem(ListSintomas.getNameSintoma(52))
            var item28: SpinnerItem = SpinnerItem()
            item28.initializeItem(ListSintomas.getNameSintoma(53))
            var item29: SpinnerItem = SpinnerItem()
            item29.initializeItem(ListSintomas.getNameSintoma(54))

            ListS5 = mutableListOf(S5Title, item25, item26, item27, item28, item29)

        Sintoma55.setText(ListSintomas.getSintoma(55))
        Sintoma56.setText(ListSintomas.getSintoma(56))
        Sintoma57.setText(ListSintomas.getSintoma(57))
        Sintoma58.setText(ListSintomas.getSintoma(58))
        Sintoma59.setText(ListSintomas.getSintoma(59))

        //Spinner 6 (S6) : Femtes
            var S6Title: SpinnerItem = SpinnerItem()
            S6Title.initializeItem(ListSintomas.getSintoma(60))
            var item30: SpinnerItem = SpinnerItem()
            item30.initializeItem(ListSintomas.getNameSintoma(61))
            var item31: SpinnerItem = SpinnerItem()
            item31.initializeItem(ListSintomas.getNameSintoma(62))

            ListS6 = mutableListOf(S6Title, item30, item31)

        Sintoma63.setText(ListSintomas.getSintoma(63))
        Sintoma64.setText(ListSintomas.getSintoma(64))
        Sintoma65.setText(ListSintomas.getSintoma(65))
        Sintoma66.setText(ListSintomas.getSintoma(66))

        //Spinner 7 (S7) : Inflamació
            var S7Title: SpinnerItem = SpinnerItem()
            S7Title.initializeItem(ListSintomas.getSintoma(67))
            var item32: SpinnerItem = SpinnerItem()
            item32.initializeItem(ListSintomas.getNameSintoma(68))
            var item33: SpinnerItem = SpinnerItem()
            item33.initializeItem(ListSintomas.getNameSintoma(69))
            var item34: SpinnerItem = SpinnerItem()
            item34.initializeItem(ListSintomas.getNameSintoma(70))

            ListS7 = mutableListOf(S7Title, item32, item33, item34)

        Sintoma71.setText(ListSintomas.getSintoma(71))
        Sintoma72.setText(ListSintomas.getSintoma(72))
        Sintoma73.setText(ListSintomas.getSintoma(73))
        Sintoma74.setText(ListSintomas.getSintoma(74))
        Sintoma75.setText(ListSintomas.getSintoma(75))
        Sintoma76.setText(ListSintomas.getSintoma(76))
        Sintoma77.setText(ListSintomas.getSintoma(77))
        Sintoma78.setText(ListSintomas.getSintoma(78))
        Sintoma79.setText(ListSintomas.getSintoma(79))
        Sintoma80.setText(ListSintomas.getSintoma(80))

        //Spinner 8 (S9) : Paràlisi
            var S8Title: SpinnerItem = SpinnerItem()
            S8Title.initializeItem(ListSintomas.getSintoma(81))
            var item35: SpinnerItem = SpinnerItem()
            item35.initializeItem(ListSintomas.getNameSintoma(82))
            var item36: SpinnerItem = SpinnerItem()
            item36.initializeItem(ListSintomas.getNameSintoma(83))
            var item37: SpinnerItem = SpinnerItem()
            item37.initializeItem(ListSintomas.getNameSintoma(84))
            var item38: SpinnerItem = SpinnerItem()
            item38.initializeItem(ListSintomas.getNameSintoma(85))
            var item39: SpinnerItem = SpinnerItem()
            item39.initializeItem(ListSintomas.getNameSintoma(86))
            var item40: SpinnerItem = SpinnerItem()
            item40.initializeItem(ListSintomas.getNameSintoma(87))

            ListS8 = mutableListOf(S8Title, item35, item36, item37, item38, item39, item40)

        Sintoma88.setText(ListSintomas.getSintoma(88))
        Sintoma89.setText(ListSintomas.getSintoma(89))
        Sintoma90.setText(ListSintomas.getSintoma(90))
        Sintoma91.setText(ListSintomas.getSintoma(91))
        Sintoma92.setText(ListSintomas.getSintoma(92))

        //Spinner 9 (S9) : Pèrdua de sensibilitat
            var S9Title: SpinnerItem = SpinnerItem()
            S9Title.initializeItem(ListSintomas.getSintoma(93))
            var item41: SpinnerItem = SpinnerItem()
            item41.initializeItem(ListSintomas.getNameSintoma(94))
            var item42: SpinnerItem = SpinnerItem()
            item42.initializeItem(ListSintomas.getNameSintoma(95))
            var item43: SpinnerItem = SpinnerItem()
            item43.initializeItem(ListSintomas.getNameSintoma(96))
            var item44: SpinnerItem = SpinnerItem()
            item44.initializeItem(ListSintomas.getNameSintoma(97))
            var item45: SpinnerItem = SpinnerItem()
            item45.initializeItem(ListSintomas.getNameSintoma(98))
            var item46: SpinnerItem = SpinnerItem()
            item46.initializeItem(ListSintomas.getNameSintoma(99))

            ListS9 = mutableListOf(S9Title, item41, item42, item43, item44, item45, item46)

        //Spinner 10 (S10) : Picor
            var S10Title: SpinnerItem = SpinnerItem()
            S10Title.initializeItem(ListSintomas.getSintoma(100))
            var item47: SpinnerItem = SpinnerItem()
            item47.initializeItem(ListSintomas.getNameSintoma(101))
            var item48: SpinnerItem = SpinnerItem()
            item48.initializeItem(ListSintomas.getNameSintoma(102))

            ListS10 = mutableListOf(S10Title, item47, item48)

        //Spinner 11 (S11) : Pupiles
            var S11Title: SpinnerItem = SpinnerItem()
            S11Title.initializeItem(ListSintomas.getSintoma(103))
            var item49: SpinnerItem = SpinnerItem()
            item49.initializeItem(ListSintomas.getNameSintoma(104))
            var item50: SpinnerItem = SpinnerItem()
            item50.initializeItem(ListSintomas.getNameSintoma(105))

            ListS11 = mutableListOf(S11Title, item49, item50)

        //Spinner 12 (S12) : Respiració
            var S12Title: SpinnerItem = SpinnerItem()
            S12Title.initializeItem(ListSintomas.getSintoma(106))
            var item51: SpinnerItem = SpinnerItem()
            item51.initializeItem(ListSintomas.getNameSintoma(107))
            var item52: SpinnerItem = SpinnerItem()
            item52.initializeItem(ListSintomas.getNameSintoma(108))

            ListS12 = mutableListOf(S12Title, item51, item52)

        Sintoma109.setText(ListSintomas.getSintoma(109))
        Sintoma110.setText(ListSintomas.getSintoma(110))
        Sintoma111.setText(ListSintomas.getSintoma(111))
        Sintoma112.setText(ListSintomas.getSintoma(112))

        //Spinner 13 (S13) : Sagnat
            var S13Title: SpinnerItem = SpinnerItem()
            S13Title.initializeItem(ListSintomas.getSintoma(113))
            var item53: SpinnerItem = SpinnerItem()
            item53.initializeItem(ListSintomas.getNameSintoma(114))
            var item54: SpinnerItem = SpinnerItem()
            item54.initializeItem(ListSintomas.getNameSintoma(115))
            var item55: SpinnerItem = SpinnerItem()
            item55.initializeItem(ListSintomas.getNameSintoma(116))
            var item56: SpinnerItem = SpinnerItem()
            item56.initializeItem(ListSintomas.getNameSintoma(117))

            ListS13 = mutableListOf(S13Title, item53, item54, item55, item56)

        Sintoma118.setText(ListSintomas.getSintoma(118))

        //Spinner 14 (S14) : Sensacions extranyes
            var S14Title: SpinnerItem = SpinnerItem()
            S14Title.initializeItem(ListSintomas.getSintoma(119))
            var item57: SpinnerItem = SpinnerItem()
            item57.initializeItem(ListSintomas.getNameSintoma(120))
            var item58: SpinnerItem = SpinnerItem()
            item58.initializeItem(ListSintomas.getNameSintoma(121))
            var item59: SpinnerItem = SpinnerItem()
            item59.initializeItem(ListSintomas.getNameSintoma(122))

            ListS14 = mutableListOf(S14Title, item57, item58, item59)

        Sintoma123.setText(ListSintomas.getSintoma(123))
        Sintoma124.setText(ListSintomas.getSintoma(124))
        Sintoma125.setText(ListSintomas.getSintoma(125))

        //Spinner 15 (S15) : Taques a la pell
            var S15Title: SpinnerItem = SpinnerItem()
            S15Title.initializeItem(ListSintomas.getSintoma(126))
            var item60: SpinnerItem = SpinnerItem()
            item60.initializeItem(ListSintomas.getNameSintoma(127))
            var item61: SpinnerItem = SpinnerItem()
            item61.initializeItem(ListSintomas.getNameSintoma(128))
            var item62: SpinnerItem = SpinnerItem()
            item62.initializeItem(ListSintomas.getNameSintoma(129))
            var item63: SpinnerItem = SpinnerItem()
            item63.initializeItem(ListSintomas.getNameSintoma(130))
            var item64: SpinnerItem = SpinnerItem()
            item64.initializeItem(ListSintomas.getNameSintoma(131))

            ListS15 = mutableListOf(S15Title, item60, item61, item62, item63, item64)

        Sintoma132.setText(ListSintomas.getSintoma(132))

        //Spinner 16 (S16) : Tos
            var S16Title: SpinnerItem = SpinnerItem()
            S16Title.initializeItem(ListSintomas.getSintoma(133))
            var item65: SpinnerItem = SpinnerItem()
            item65.initializeItem(ListSintomas.getNameSintoma(134))
            var item66: SpinnerItem = SpinnerItem()
            item66.initializeItem(ListSintomas.getNameSintoma(135))
            var item67: SpinnerItem = SpinnerItem()
            item67.initializeItem(ListSintomas.getNameSintoma(136))

            ListS16 = mutableListOf(S16Title, item65, item66, item67)

        Sintoma137.setText(ListSintomas.getSintoma(137))
        Sintoma138.setText(ListSintomas.getSintoma(138))
        Sintoma139.setText(ListSintomas.getSintoma(139))
        Sintoma140.setText(ListSintomas.getSintoma(140))
        Sintoma141.setText(ListSintomas.getSintoma(141))
        Sintoma142.setText(ListSintomas.getSintoma(142))
    }
}
