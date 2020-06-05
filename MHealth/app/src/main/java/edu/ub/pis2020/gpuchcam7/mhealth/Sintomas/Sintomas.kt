package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

class Sintomas {
    val ListSintomas = mutableListOf<String>(
        "Acropàquies",//0
        "Adenopaties",//1
        "Afonia",//2
        "Alucinacions",//3
        "Alteració de la consciència",//4
        "Alteració de la conducta/personalitat",//5
        "Alteradió de la marxa",//6
        "Alteradió de la parla",//7
        "Alteradió de l'equilibri",//8
        "Ansietat",//9
        "Apnea nocturna",//10
        "Arritmies",//11 S1
            "Bardicardia_A",//12
            "Taquicardia_A",//13
        "Bony a la pell",//14
        "Brunzit d'orelles",//15
        "Butllofes",//16 S2
            "Grans_B",//17
            "Petites_B",//18
        "Calfreds",//19
        "Cianosi",//20
        "Convulsions",//21
        "Debilitat",//22 S3
            "Braços_DE",//23
            "Cames_DE",//24
            "Cara_DE",//25
            "General_DE",//26
            "Mitja cara_DE",//27
            "Mig cos_DE",//28
        "Demència",//29
        "Deterirament intelectual",//30
        "Diarrea",//31
        "Disfagia",//32
        "Disnea",//33
        "Dolor",//34 S4
            "Abdomen_D",//35
            "Cap_D",//36
            "Cara_D",//37
            "Cervicals_D",//38
            "Coll_D",//39
            "Dents_D",//40
            "Esquena_D",//41
            "Lumbar_D",//42
            "Nas_D",//43
            "Orelles_D",//44
            "Osos_D",//45
            "Parts Baixes_D",//46
            "Pit_D",//47
            "Ulls_D",//48
        "Dolor articulacions",//49 S5
            "Cervicals_AT",//50
            "Genolls_AT",//51
            "Lumbars_AT",//52
            "Mans_AT",//53
            "Peus_AT",//54
        "Dolor al menjar",//55
        "Espasmes",//56
        "Estrenyiment",//57
        "Fatiga",//58
        "Febre",//59
        "Femtes",//60 S6
            "Clares_F",//61
            "Olioses_F",//62
        "Halitosi",//63
        "Icterícia",//64
        "Impotència",//65
        "Incontinencia urinària",//66
        "Inflamació",//67 S7
            "Abdomen_I",//68
            "Cames_I",//69
            "Cara_I",//70
        "Insomni",//71
        "Malestar General",//72
        "Mareig",//73
        "Mocs",//74
        "Mort",//75
        "Nauseas",//76
        "Oliguria",//77
        "Orina fosca",//78
        "Palidesa",//79
        "Palpitacions",//80
        "Paràlisi",//81 S8
            "Braços_PA",//82
            "Cames_PA",//83
            "Cara_PA",//84
            "General_PA",//85
            "Mitja cara_PA",//86
            "Mig cos_PA",//87
        "Parpella caiguda",//88
        "Pèrdua de coneixement",//89
        "Pèrdua de gana",//90
        "Pèrdua de memòria",//91
        "Pèrdua de pes",//92
        "Pèrdua de sensibilitat",//93 S9
            "Braços_SE",//94
            "Cames_SE",//95
            "Cara_SE",//96
            "General_SE",//97
            "Mitja cara_SE",//98
            "Mig cos_SE",//99
        "Picor",//100 S10
            "Parts baixes_PI",//101
            "Pell_PI",//102
        "Pupiles",//103 S11
            "Contretes_P",//104
            "Dilatades_P",//105
        "Respiració",//106 S12
            "Taquipnea_R",//107
            "Bradipnea_R",//108
        "Retràs mental",//109
        "Rigidesa",//110
        "Rigidesa al clatell",//111
        "Roncs",//112
        "Sagnat",//113 S13
            "Amb les deposicions_S",//114
            "Amb l'orina_S",//115
            "Boca_S",//116
            "Nas_S",//117
        "Secreció uretral",//118
        "Sensacions extranyes",//119 S14
            "Braç_EX",//120
            "Cama_EX",//121
            "General_EX",//122
        "Son",//123
        "Sordesa",//124
        "Suor",//125
        "Taques a la pell",//126 S15
            "Blanques_TA",//127
            "Liles_TA",//128
            "Marrons_TA",//129
            "Negres_TA",//130
            "Vermelles_TA",//131
        "Tremolor",//132
        "Tos",//133 S16
            "Amb mocs_T",//134
            "Amb sang_T",//135
            "Seca_T",//136
        "Úlceres",//137
        "Verrugues",//138
        "Visió borrosa",//139
        "Visió doble",//140
        "Vómit",//141
        "Xiulets al respirar"//142
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