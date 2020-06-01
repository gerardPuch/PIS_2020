package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

class Sintomas {
    val ListSintomas = mutableListOf<String>(
        "Alucinacions",//0
        "Arritmies",//1
            "Bardicardia_A",//2
            "Taquicardia_A",//3
        "Diarrea",//4
        "Disnea",//5
        "Dolor",//6
            "Abdomen_D",//7
            "Cap_D",//8
            "Coll_D",//9
            "Dents_D",//10
            "Nas_D",//11
            "Orelles_D",//12
            "Osos_D",//13
            "Parts Baixes_D",//14
            "Pit_D",//15
            "Ulls_D",//16
        "Dolor Articulacions",//17
            "Articculacio_1_AT",//18
        "Febre",//19
        "Mareig",//20
        "Mocs",//21
        "Nauseas",//22
        "Pèrdua de coneixement",//23
        "Sagnat",//24
            "Forat1_S",//25
        "Tos",//26
        "Vómit"//27

    /*
    Ansietat
    Debilitat
        General
        Part del cos_1_DE
    Disfagia
    Fatiga
    Icterícia (pell de color groc)
    Inflat
        part del cos_1_I
    Mort
    Palidesa
    Pèrdua de sensibilitat
        Part del cos_1_SE
    Respiració
        taquipnea_R
        bradipnea
    Suor
    */
    )

    fun getNumSintomas(): Int{
        return ListSintomas.size
    }

    fun getSintomaID(name: String): Int{
        if(ListSintomas.contains(name)){
            return ListSintomas.indexOf(name)
        }
        return -1
    }

    fun getSintoma(position: Int) :String{
        return ListSintomas[position]
    }
    fun getNameSintoma(position: Int):String{
        var name = ListSintomas[position]
        var code = ""
        when (position){
            2,3 -> code = "_A"
            7,8,9,10,11,12,13,14,15,16-> code = "_D"
            18 -> code = "_AT"
            25 -> code = "_S"
            /*"Debilitat" -> code = "_DE"
            "Inflat" -> code = "_I"
            "Pèrdua de sensibilitat" -> code = "_SE"
            "Respiració" -> code = "_R"*/
        }
        return name.removeSuffix(code)
    }

    fun getCodeSintoma(name: String, parent: String) :String{
        var code = ""
        when (parent){
            "Arritmies" -> code = "_A"
            "Dolor" -> code = "_D"
            "Dolor Articulacions" -> code = "_AT"
            "Sagnat" -> code = "_S"
            "Debilitat" -> code = "_DE"
            "Inflat" -> code = "_I"
            "Pèrdua de sensibilitat" -> code = "_SE"
            "Respiració" -> code = "_R"
        }
        return name+code
    }
}