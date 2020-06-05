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

    //SP hace referencia a que es un Spinner con mas de un elemento
    lateinit var SP1: Spinner;    lateinit var ListSP1: MutableList<SpinnerItem>
    lateinit var SP2: Spinner;    lateinit var ListSP2: MutableList<SpinnerItem>
    lateinit var SP3: Spinner;    lateinit var ListSP3: MutableList<SpinnerItem>
    lateinit var SP4: Spinner;    lateinit var ListSP4: MutableList<SpinnerItem>
    lateinit var SP5: Spinner;    lateinit var ListSP5: MutableList<SpinnerItem>
    lateinit var SP6: Spinner;    lateinit var ListSP6: MutableList<SpinnerItem>
    lateinit var SP7: Spinner;    lateinit var ListSP7: MutableList<SpinnerItem>
    lateinit var SP8: Spinner;    lateinit var ListSP8: MutableList<SpinnerItem>
    lateinit var SP9: Spinner;    lateinit var ListSP9: MutableList<SpinnerItem>
    lateinit var SP10: Spinner;   lateinit var ListSP10: MutableList<SpinnerItem>
    lateinit var SP11: Spinner;   lateinit var ListSP11: MutableList<SpinnerItem>
    lateinit var SP12: Spinner;   lateinit var ListSP12: MutableList<SpinnerItem>
    lateinit var SP13: Spinner;   lateinit var ListSP13: MutableList<SpinnerItem>
    lateinit var SP14: Spinner;   lateinit var ListSP14: MutableList<SpinnerItem>
    lateinit var SP15: Spinner;   lateinit var ListSP15: MutableList<SpinnerItem>
    lateinit var SP16: Spinner;   lateinit var ListSP16: MutableList<SpinnerItem>

    //S hace referencia a un Spinner que solo contiene un elemento, a efectos practicos es un checkbox
    var S0 = SpinnerItem(); var S1 = SpinnerItem(); var S2 = SpinnerItem(); var S3 = SpinnerItem(); var S4 = SpinnerItem();
    var S5 = SpinnerItem(); var S6 = SpinnerItem(); var S7 = SpinnerItem(); var S8 = SpinnerItem(); var S9 = SpinnerItem();
    var S10 = SpinnerItem(); var S14 = SpinnerItem(); var S15 = SpinnerItem(); var S19 = SpinnerItem(); var S20 = SpinnerItem();
    var S21 = SpinnerItem(); var S29 = SpinnerItem(); var S30 = SpinnerItem(); var S31 = SpinnerItem(); var S32 = SpinnerItem();
    var S33 = SpinnerItem(); var S55 = SpinnerItem(); var S56 = SpinnerItem(); var S57 = SpinnerItem(); var S58 = SpinnerItem();
    var S59 = SpinnerItem(); var S63 = SpinnerItem(); var S64 = SpinnerItem(); var S65 = SpinnerItem(); var S66 = SpinnerItem();
    var S71 = SpinnerItem(); var S72 = SpinnerItem(); var S73 = SpinnerItem(); var S74 = SpinnerItem(); var S75 = SpinnerItem();
    var S76 = SpinnerItem(); var S77 = SpinnerItem(); var S78 = SpinnerItem(); var S79 = SpinnerItem(); var S88 = SpinnerItem();
    var S89 = SpinnerItem(); var S90 = SpinnerItem(); var S91 = SpinnerItem(); var S92 = SpinnerItem(); var S109 = SpinnerItem();
    var S110 = SpinnerItem(); var S111 = SpinnerItem(); var S112 = SpinnerItem(); var S118 = SpinnerItem(); var S123 = SpinnerItem();
    var S124 = SpinnerItem(); var S125 = SpinnerItem(); var S132 = SpinnerItem(); var S137 = SpinnerItem(); var S138 = SpinnerItem();
    var S139 = SpinnerItem(); var S140 = SpinnerItem(); var S141 = SpinnerItem(); var S142 = SpinnerItem(); var S80 = SpinnerItem();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.ListSintomas = Sintomas()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Asocio los Spinners del Layout para trabajar con ellos
        SP1 = Spinner1; SP2 = Spinner2; SP3 = Spinner3; SP4 = Spinner4; SP5 = Spinner5
        SP6 = Spinner6; SP7 = Spinner7; SP8 = Spinner8; SP9 = Spinner9; SP10 = Spinner10
        SP11 = Spinner11; SP12 = Spinner12; SP13 = Spinner13; SP14 = Spinner14; SP15 = Spinner15
        SP16 = Spinner16

        //Establece los sintomas en los elementos de la lista
        setSintomas()

        SP1.adapter = AdapterSpinner(activity!!, 0, ListSP1); SP2.adapter = AdapterSpinner(activity!!, 0, ListSP2);
        SP3.adapter = AdapterSpinner(activity!!, 0, ListSP3); SP4.adapter = AdapterSpinner(activity!!, 0, ListSP4);
        SP5.adapter = AdapterSpinner(activity!!, 0, ListSP5); SP6.adapter = AdapterSpinner(activity!!, 0, ListSP6);
        SP7.adapter = AdapterSpinner(activity!!, 0, ListSP7); SP8.adapter = AdapterSpinner(activity!!, 0, ListSP8);
        SP9.adapter = AdapterSpinner(activity!!, 0, ListSP9); SP10.adapter = AdapterSpinner(activity!!, 0, ListSP10);
        SP11.adapter = AdapterSpinner(activity!!, 0, ListSP11); SP12.adapter = AdapterSpinner(activity!!, 0, ListSP12);
        SP13.adapter = AdapterSpinner(activity!!, 0, ListSP13); SP14.adapter = AdapterSpinner(activity!!, 0, ListSP14);
        SP15.adapter = AdapterSpinner(activity!!, 0, ListSP15); SP16.adapter = AdapterSpinner(activity!!, 0, ListSP16);
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
        S0.initializeItem(ListSintomas.getSintoma(0))
        //
        S1.initializeItem(ListSintomas.getSintoma(1))
        //Afonia
        S2.initializeItem(ListSintomas.getSintoma(2))
        //Alucinacions
        S3.initializeItem(ListSintomas.getSintoma(3))
        //Alteració de la consciència
        S4.initializeItem(ListSintomas.getSintoma(4))
        //
        S5.initializeItem(ListSintomas.getSintoma(5))
        //
        S6.initializeItem(ListSintomas.getSintoma(6))
        //
        S7.initializeItem(ListSintomas.getSintoma(7))
        //
        S8.initializeItem(ListSintomas.getSintoma(8))
        //Ansietat
        S9.initializeItem(ListSintomas.getSintoma(9))
        //Apnea nocturna
        S10.initializeItem(ListSintomas.getSintoma(10))

        //Spinner 1 (SP1) : Arritmies
            var SP1Title: SpinnerItem = SpinnerItem()
            SP1Title.initializeItem(ListSintomas.getSintoma(11))
            //Bardicardia_A
            var item1: SpinnerItem = SpinnerItem()
            item1.initializeItem(ListSintomas.getNameSintoma(12))
            //Taquicardia_A
            var item2: SpinnerItem = SpinnerItem()
            item2.initializeItem(ListSintomas.getNameSintoma(13))

            ListSP1 = mutableListOf(SP1Title, item1, item2)

        //
        S14.initializeItem(ListSintomas.getSintoma(14))
        //Brunzit d'orelles
        S15.initializeItem(ListSintomas.getSintoma(15))

        //Spinner 2 (SP2) : Butllofes
            var SP2Title: SpinnerItem = SpinnerItem()
            SP2Title.initializeItem(ListSintomas.getSintoma(16))
            //Grans_B
            var item3: SpinnerItem = SpinnerItem()
            item3.initializeItem(ListSintomas.getNameSintoma(17))
            //Petites_B
            var item4: SpinnerItem = SpinnerItem()
            item4.initializeItem(ListSintomas.getNameSintoma(18))

            ListSP2 = mutableListOf(SP2Title, item3, item4)

        //
        S19.initializeItem(ListSintomas.getSintoma(19))
        //
        S20.initializeItem(ListSintomas.getSintoma(20))
        //Convulsions
        S21.initializeItem(ListSintomas.getSintoma(21))

        //Spinner 3 (SP3) : Debilitat
            var SP3Title: SpinnerItem = SpinnerItem()
            SP3Title.initializeItem(ListSintomas.getSintoma(22))
            //Braços_DE
            var item5: SpinnerItem = SpinnerItem()
            item5.initializeItem(ListSintomas.getNameSintoma(23))
            //Cames_DE
            var item6: SpinnerItem = SpinnerItem()
            item6.initializeItem(ListSintomas.getNameSintoma(24))
            //Cara_DE
            var item7: SpinnerItem = SpinnerItem()
            item7.initializeItem(ListSintomas.getNameSintoma(25))
            //General_DE
            var item8: SpinnerItem = SpinnerItem()
            item8.initializeItem(ListSintomas.getNameSintoma(26))
            //Mitja cara_DE
            var item9: SpinnerItem = SpinnerItem()
            item9.initializeItem(ListSintomas.getNameSintoma(27))
            //Mig cos_DE
            var item10: SpinnerItem = SpinnerItem()
            item10.initializeItem(ListSintomas.getNameSintoma(28))

            ListSP3 = mutableListOf(SP3Title, item5, item6, item7, item8, item9, item10)

        //
        S29.initializeItem(ListSintomas.getSintoma(29))
        //
        S30.initializeItem(ListSintomas.getSintoma(30))
        //Diarrea
        S31.initializeItem(ListSintomas.getSintoma(31))
        //Disfagia
        S32.initializeItem(ListSintomas.getSintoma(32))
        //Disnea
        S33.initializeItem(ListSintomas.getSintoma(33))

        //Spinner 4 (SP4) : Dolor
            var SP4Title: SpinnerItem = SpinnerItem()
            SP4Title.initializeItem(ListSintomas.getSintoma(34))
            //Abdomen_D
            var item11: SpinnerItem = SpinnerItem()
            item11.initializeItem(ListSintomas.getNameSintoma(35))
            //Cap_D
            var item12: SpinnerItem = SpinnerItem()
            item12.initializeItem(ListSintomas.getNameSintoma(36))
            //Cara_D
            var item13: SpinnerItem = SpinnerItem()
            item13.initializeItem(ListSintomas.getNameSintoma(37))
            //Cervicals_D
            var item14: SpinnerItem = SpinnerItem()
            item14.initializeItem(ListSintomas.getNameSintoma(38))
            //Coll_D
            var item15: SpinnerItem = SpinnerItem()
            item15.initializeItem(ListSintomas.getNameSintoma(39))
            //Dents_D
            var item16: SpinnerItem = SpinnerItem()
            item16.initializeItem(ListSintomas.getNameSintoma(40))
            //Esquena_D
            var item17: SpinnerItem = SpinnerItem()
            item17.initializeItem(ListSintomas.getNameSintoma(41))
            //Lumbar_D
            var item18: SpinnerItem = SpinnerItem()
            item18.initializeItem(ListSintomas.getNameSintoma(42))
            //Nas_D
            var item19: SpinnerItem = SpinnerItem()
            item19.initializeItem(ListSintomas.getNameSintoma(43))
            //Orelles_D
            var item20: SpinnerItem = SpinnerItem()
            item20.initializeItem(ListSintomas.getNameSintoma(44))
            //Osos_D
            var item21: SpinnerItem = SpinnerItem()
            item21.initializeItem(ListSintomas.getNameSintoma(45))
            //Parts Baixes_D
            var item22: SpinnerItem = SpinnerItem()
            item22.initializeItem(ListSintomas.getNameSintoma(46))
            //Pit_D
            var item23: SpinnerItem = SpinnerItem()
            item23.initializeItem(ListSintomas.getNameSintoma(47))
            //Ulls_D
            var item24: SpinnerItem = SpinnerItem()
            item24.initializeItem(ListSintomas.getNameSintoma(48))

            ListSP4 = mutableListOf(SP4Title, item11, item12, item13, item14, item15, item16, item17, item18, item19, item20, item21, item22, item23, item24)

        //Spinner 5 (SP) : Dolor articulacions
            var SP5Title: SpinnerItem = SpinnerItem()
            SP5Title.initializeItem(ListSintomas.getSintoma(49))
            //Cervicals_AT
            var item25: SpinnerItem = SpinnerItem()
            item25.initializeItem(ListSintomas.getNameSintoma(50))
            //Genolls_AT
            var item26: SpinnerItem = SpinnerItem()
            item26.initializeItem(ListSintomas.getNameSintoma(51))
            //Lumbars_AT
            var item27: SpinnerItem = SpinnerItem()
            item27.initializeItem(ListSintomas.getNameSintoma(52))
            //Mans_AT
            var item28: SpinnerItem = SpinnerItem()
            item28.initializeItem(ListSintomas.getNameSintoma(53))
            //Peus_AT
            var item29: SpinnerItem = SpinnerItem()
            item29.initializeItem(ListSintomas.getNameSintoma(54))

            ListSP5 = mutableListOf(SP5Title, item25, item26, item27, item28, item29)

        //olor al menjar
        S55.initializeItem(ListSintomas.getSintoma(55))
        //Espasmes
        S56.initializeItem(ListSintomas.getSintoma(56))
        //Estrenyiment
        S57.initializeItem(ListSintomas.getSintoma(57))
        //Fatiga
        S58.initializeItem(ListSintomas.getSintoma(58))
        //Febre
        S59.initializeItem(ListSintomas.getSintoma(59))

        //Spinner 6 (SP6) : Femtes
            var SP6Title: SpinnerItem = SpinnerItem()
            SP6Title.initializeItem(ListSintomas.getSintoma(60))
            //Clares_F
            var item30: SpinnerItem = SpinnerItem()
            item30.initializeItem(ListSintomas.getNameSintoma(61))
            //Olioses_F
            var item31: SpinnerItem = SpinnerItem()
            item31.initializeItem(ListSintomas.getNameSintoma(62))

            ListSP6 = mutableListOf(SP6Title, item30, item31)

        //Halitosi
        S63.initializeItem(ListSintomas.getSintoma(63))
        //Icterícia
        S64.initializeItem(ListSintomas.getSintoma(64))
        //Impotència
        S65.initializeItem(ListSintomas.getSintoma(65))
        //Incontinencia urinària
        S66.initializeItem(ListSintomas.getSintoma(66))

        //Spinner 7 (SP7) : Inflamació
            var SP7Title: SpinnerItem = SpinnerItem()
            SP7Title.initializeItem(ListSintomas.getSintoma(67))
            //Abdomen_I
            var item32: SpinnerItem = SpinnerItem()
            item32.initializeItem(ListSintomas.getNameSintoma(68))
            //Cames_I
            var item33: SpinnerItem = SpinnerItem()
            item33.initializeItem(ListSintomas.getNameSintoma(69))
            //Cara_I
            var item34: SpinnerItem = SpinnerItem()
            item34.initializeItem(ListSintomas.getNameSintoma(70))

            ListSP7 = mutableListOf(SP7Title, item32, item33, item34)

        //Insomni
        S71.initializeItem(ListSintomas.getSintoma(71))
        //Malestar General
        S72.initializeItem(ListSintomas.getSintoma(72))
        //Mareig
        S73.initializeItem(ListSintomas.getSintoma(73))
        //Mocs
        S74.initializeItem(ListSintomas.getSintoma(74))
        //Mort
        S75.initializeItem(ListSintomas.getSintoma(75))
        //Nauseas
        S76.initializeItem(ListSintomas.getSintoma(76))
        //Oliguria
        S77.initializeItem(ListSintomas.getSintoma(77))
        //Orina fosca
        S78.initializeItem(ListSintomas.getSintoma(78))
        //Palidesa
        S79.initializeItem(ListSintomas.getSintoma(79))
        //Palpitacions
        S80.initializeItem(ListSintomas.getSintoma(80))

        //Spinner 8 (SP8) : Paràlisi
            var SP8Title: SpinnerItem = SpinnerItem()
            SP8Title.initializeItem(ListSintomas.getSintoma(81))
            //Braços_PA
            var item35: SpinnerItem = SpinnerItem()
            item35.initializeItem(ListSintomas.getNameSintoma(82))
            //Cames_PA
            var item36: SpinnerItem = SpinnerItem()
            item36.initializeItem(ListSintomas.getNameSintoma(83))
            //Cara_PA
            var item37: SpinnerItem = SpinnerItem()
            item37.initializeItem(ListSintomas.getNameSintoma(84))
            //General_PA
            var item38: SpinnerItem = SpinnerItem()
            item38.initializeItem(ListSintomas.getNameSintoma(85))
            //Mitja cara_PA
            var item39: SpinnerItem = SpinnerItem()
            item39.initializeItem(ListSintomas.getNameSintoma(86))
            //Mig cos_PA
            var item40: SpinnerItem = SpinnerItem()
            item40.initializeItem(ListSintomas.getNameSintoma(87))

            ListSP8 = mutableListOf(SP8Title, item35, item36, item37, item38, item39, item40)

        //Parpella caiguda
        S88.initializeItem(ListSintomas.getSintoma(88))
        //Pèrdua de coneixement
        S89.initializeItem(ListSintomas.getSintoma(89))
        //Pèrdua de gana
        S90.initializeItem(ListSintomas.getSintoma(90))
        //Pèrdua de memòria
        S91.initializeItem(ListSintomas.getSintoma(91))
        //Pèrdua de pes
        S92.initializeItem(ListSintomas.getSintoma(92))

        //Spinner 9 (SP9) : Pèrdua de sensibilitat
            var SP9Title: SpinnerItem = SpinnerItem()
            SP9Title.initializeItem(ListSintomas.getSintoma(93))
            //Braços_SE
            var item41: SpinnerItem = SpinnerItem()
            item41.initializeItem(ListSintomas.getNameSintoma(94))
            //Cames_SE
            var item42: SpinnerItem = SpinnerItem()
            item42.initializeItem(ListSintomas.getNameSintoma(95))
            //Cara_SE
            var item43: SpinnerItem = SpinnerItem()
            item43.initializeItem(ListSintomas.getNameSintoma(96))
            //General_SE
            var item44: SpinnerItem = SpinnerItem()
            item44.initializeItem(ListSintomas.getNameSintoma(97))
            //Mitja cara_SE
            var item45: SpinnerItem = SpinnerItem()
            item45.initializeItem(ListSintomas.getNameSintoma(98))
            //Mig cos_SE
            var item46: SpinnerItem = SpinnerItem()
            item46.initializeItem(ListSintomas.getNameSintoma(99))

            ListSP9 = mutableListOf(SP9Title, item41, item42, item43, item44, item45, item46)

        //Spinner 10 (SP10) : Picor
            var SP10Title: SpinnerItem = SpinnerItem()
            SP10Title.initializeItem(ListSintomas.getSintoma(100))
            //Parts baixes_PI
            var item47: SpinnerItem = SpinnerItem()
            item47.initializeItem(ListSintomas.getNameSintoma(101))
            //Pell_PI
            var item48: SpinnerItem = SpinnerItem()
            item48.initializeItem(ListSintomas.getNameSintoma(102))

            ListSP10 = mutableListOf(SP10Title, item47, item48)

        //Spinner 11 (SP11) : Pupiles
            var SP11Title: SpinnerItem = SpinnerItem()
            SP11Title.initializeItem(ListSintomas.getSintoma(103))
            //Contretes_P
            var item49: SpinnerItem = SpinnerItem()
            item49.initializeItem(ListSintomas.getNameSintoma(104))
            //Dilatades_P
            var item50: SpinnerItem = SpinnerItem()
            item50.initializeItem(ListSintomas.getNameSintoma(105))

            ListSP11 = mutableListOf(SP11Title, item49, item50)

        //Spinner 12 (SP12) : Respiració
            var SP12Title: SpinnerItem = SpinnerItem()
            SP12Title.initializeItem(ListSintomas.getSintoma(106))
            //Taquipnea_R
            var item51: SpinnerItem = SpinnerItem()
            item51.initializeItem(ListSintomas.getNameSintoma(107))
            //Bradipnea_R
            var item52: SpinnerItem = SpinnerItem()
            item52.initializeItem(ListSintomas.getNameSintoma(108))

            ListSP12 = mutableListOf(SP12Title, item51, item52)

        //Retràs mental
        S109.initializeItem(ListSintomas.getSintoma(109))
        //Rigidesa
        S110.initializeItem(ListSintomas.getSintoma(110))
        //Rigidesa al clatell
        S111.initializeItem(ListSintomas.getSintoma(111))
        //Roncs
        S112.initializeItem(ListSintomas.getSintoma(112))

        //Spinner 13 (SP13) : Sagnat
            var SP13Title: SpinnerItem = SpinnerItem()
            SP13Title.initializeItem(ListSintomas.getSintoma(113))
            //"Amb les deposicions_S"
            var item53: SpinnerItem = SpinnerItem()
            item53.initializeItem(ListSintomas.getNameSintoma(114))
            //Amb l'orina_S
            var item54: SpinnerItem = SpinnerItem()
            item54.initializeItem(ListSintomas.getNameSintoma(115))
            //Boca_S
            var item55: SpinnerItem = SpinnerItem()
            item55.initializeItem(ListSintomas.getNameSintoma(116))
            //Nas_S
            var item56: SpinnerItem = SpinnerItem()
            item56.initializeItem(ListSintomas.getNameSintoma(117))

            ListSP13 = mutableListOf(SP13Title, item53, item54, item55, item56)

        //Secreció uretral
        S118.initializeItem(ListSintomas.getSintoma(118))

        //Spinner 14 (SP14) : Sensacions extranyes
            var SP14Title: SpinnerItem = SpinnerItem()
            SP14Title.initializeItem(ListSintomas.getSintoma(119))
            //Braç_EX
            var item57: SpinnerItem = SpinnerItem()
            item57.initializeItem(ListSintomas.getNameSintoma(120))
            //Cama_EX
            var item58: SpinnerItem = SpinnerItem()
            item58.initializeItem(ListSintomas.getNameSintoma(121))
            //General_EX
            var item59: SpinnerItem = SpinnerItem()
            item59.initializeItem(ListSintomas.getNameSintoma(122))

            ListSP14 = mutableListOf(SP14Title, item57, item58, item59)

        //Son
        S123.initializeItem(ListSintomas.getSintoma(123))
        //Sordesa
        S124.initializeItem(ListSintomas.getSintoma(124))
        //Suor
        S125.initializeItem(ListSintomas.getSintoma(125))

        //Spinner 15 (SP15) : Taques a la pell
        var SP15Title: SpinnerItem = SpinnerItem()
            SP15Title.initializeItem(ListSintomas.getSintoma(126))
            //Blanques_TA
            var item60: SpinnerItem = SpinnerItem()
            item60.initializeItem(ListSintomas.getNameSintoma(127))
            //Liles_TA
            var item61: SpinnerItem = SpinnerItem()
            item61.initializeItem(ListSintomas.getNameSintoma(128))
            //Marrons_TA
            var item62: SpinnerItem = SpinnerItem()
            item62.initializeItem(ListSintomas.getNameSintoma(129))
            //Negres_TA
            var item63: SpinnerItem = SpinnerItem()
            item63.initializeItem(ListSintomas.getNameSintoma(130))
            //Vermelles_TA
            var item64: SpinnerItem = SpinnerItem()
            item64.initializeItem(ListSintomas.getNameSintoma(131))

            ListSP15 = mutableListOf(SP15Title, item60, item61, item62, item63, item64)

        //Tremolor
        S132.initializeItem(ListSintomas.getSintoma(132))

        //Spinner 16 (SP16) : Tos
            var SP16Title: SpinnerItem = SpinnerItem()
            SP16Title.initializeItem(ListSintomas.getSintoma(133))
            //Amb mocs_T
            var item65: SpinnerItem = SpinnerItem()
            item65.initializeItem(ListSintomas.getNameSintoma(134))
            //Amb sang_T
            var item66: SpinnerItem = SpinnerItem()
            item66.initializeItem(ListSintomas.getNameSintoma(135))
            //Seca_T
            var item67: SpinnerItem = SpinnerItem()
            item67.initializeItem(ListSintomas.getNameSintoma(136))

            ListSP16 = mutableListOf(SP16Title, item65, item66, item67)

        //Úlceres
        S137.initializeItem(ListSintomas.getSintoma(137))
        //Verrugues
        S138.initializeItem(ListSintomas.getSintoma(138))
        //Visió borrosa
        S139.initializeItem(ListSintomas.getSintoma(139))
        //Visió doble
        S140.initializeItem(ListSintomas.getSintoma(140))
        //Vómit
        S141.initializeItem(ListSintomas.getSintoma(141))
        //Xiulets al respirar
        S142.initializeItem(ListSintomas.getSintoma(142))
    }
}
