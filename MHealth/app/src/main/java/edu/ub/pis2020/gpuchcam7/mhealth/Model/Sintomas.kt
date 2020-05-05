package edu.ub.pis2020.gpuchcam7.mhealth.Model

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
            "Articulacions",
                "Articculacio_1",
            "Cap",
            "Coll",
            "Dents",
            "Nas",
            "Orelles",
            "Osos",
            "Parts Baixes",
            "Pit",
            "Ulls",
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