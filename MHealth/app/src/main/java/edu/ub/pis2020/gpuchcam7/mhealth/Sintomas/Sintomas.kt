package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

class Sintomas {
    val ListSintomas = mutableListOf<String>(
        "Acropàquies",//0
        "Afonia",//1
        "Alucinacions",//2
        "Alteració de la consciència",//3
        "Ansietat",//4
        "Apnea nocturna",//5
        "Arritmies",//6 S1
            "Bardicardia_A",//7
            "Taquicardia_A",//8
        "Brunzit d'orelles",//9
        "Convulsions",//10
        "Debilitat",//11 S2
            "General_DE",//12
            "Part del cos_1_DE",//13
        "Diarrea",//14
        "Disfagia",//15
        "Disnea",//16
        "Dolor",//17 S3
            "Abdomen_D",//18
            "Cap_D",//19
            "Coll_D",//20
            "Dents_D",//21
            "Nas_D",//22
            "Orelles_D",//23
            "Osos_D",//24
            "Parts Baixes_D",//25
            "Pit_D",//26
            "Ulls_D",//27
        "Dolor articulacions",//28 S4
            "Articculacio_1_AT",//29
        "Espasmes",//30
        "Fatiga",//31
        "Febre",//32
        "Halitosi",//33
        "Icterícia",//34
        "Inflat",//35 S5
            "Part del cos_1_I",//36
        "Mareig",//37
        "Mocs",//38
        "Mort",//39
        "Nauseas",//40
        "Palidesa",//41
        "Paràlisi",//42
        "Pèrdua de coneixement",//43
        "Pèrdua de gana",//44
        "Pèrdua de pes",//45
        "Pèrdua de sensibilitat",//46 S6
            "Part del cos_1_SE",//47
        "Pupiles",//48 S7
            "Contretes_P",//49
            "Dilatades_P",//50
        "Respiració",//51 S8
            "Taquipnea_R",//52
            "Bradipnea_R",//53
        "Rigidesa al clatell",//54
        "Roncs",//55
        "Sagnat",//56 S9
            "Forat1_S",//57
        "Secreció retral",//58
        "Son",//59
        "Suor",//60
        "Tos",//61
        "Úlceres",//62
        "Visió borrosa",//63
        "Vómit",//64
        "Xiulets al respirar"//65
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
            7,8 -> code = "_A"
            12,13 -> code = "_DE"
            18,19,20,21,22,23,24,25,26 -> code = "_D"
            28 -> code = "_AT"
            35 -> code = "_I"
            46 -> code = "_SE"
            48,49 -> code = "_R"
            51,52 -> code = "_S"
        }
        return name.removeSuffix(code)
    }

    fun getCodeSintoma(name: String, parent: String) :String{
        var code = ""
        when (parent){
            "Arritmies" -> code = "_A"
            "Debilitat" -> code = "_DE"
            "Dolor" -> code = "_D"
            "Dolor articulacions" -> code = "_AT"
            "Inflat" -> code = "_I"
            "Pèrdua de sensibilitat" -> code = "_SE"
            "Respiració" -> code = "_R"
            "Sagnat" -> code = "_S"
        }
        return name+code
    }
}