package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

class Illness {
    private var name: String = "name"
    private var coincidence_value: Int = 0
    private var causes: MutableList<String> = mutableListOf("empty")
    private var sintomas: MutableList<String> = mutableListOf("empty")
    private var remedies: MutableList<String> = mutableListOf("empty")

    constructor(name: String){
        this.name = name
        this.coincidence_value = 1
        this.causes = mutableListOf("Casua 1")
        this.sintomas = mutableListOf("Símptoma 1")
        this.remedies = mutableListOf("Remei 1")
    }

    fun setIllnessName(name: String){
        this.name = name
    }

    fun getIllnessName(): String{
        return name
    }

    fun setIllnessCoincidenceValue(number: Int){
        coincidence_value = number
    }

    fun getIllnessCoincidenceValue(): Int{
        return coincidence_value
    }

    fun addIllnessCause(new: String){
        causes.add(new)
    }

    fun getIllnessCauses(): MutableList<String>{
        return causes
    }

    fun addIllnessSintoma(new: String){
        sintomas.add(new)
    }

    fun getIllnessSintomas(): MutableList<String>{
        return sintomas
    }

    fun addIllnessRemedy(new: String){
        remedies.add(new)
    }

    fun getIllnessRemedies(): MutableList<String>{
        return remedies
    }
}