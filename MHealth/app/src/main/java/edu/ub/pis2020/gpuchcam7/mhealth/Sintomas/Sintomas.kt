package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

class Sintomas {
    val ListSintomas = mutableListOf<String>(
        "Alucinacions",
        "Arritmies",
            "Bardicardia",
            "Taquicardia",
        "Diarrea",
        "Disnea",
        "Dolor",
            "Abdomen",
            "Cap",
            "Coll",
            "Dents",
            "Nas",
            "Orelles",
            "Osos",
            "Parts Baixes",
            "Pit",
            "Ulls",
        "Dolor Articulacions",
            "Articculacio_1",
        "Febre",
        "Mareig",
        "Mocs",
        "Nauseas",
        "Pèrdua de coneixement",
        "Sagnat",
            "Forat1",
        "Tos",
        "Vómit"
    )

    fun getNumSintomas(): Int{
        return ListSintomas.size
    }

    fun getSintoma(position: Int) :String{
        return ListSintomas[position]
    }
}