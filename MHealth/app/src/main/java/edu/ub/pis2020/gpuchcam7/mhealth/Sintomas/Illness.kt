package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

class Illness {
    private var name: String = "name"
    private var coincidence_value: Int = 0
    private var coincidence_color: Int = 0
    private var causes: MutableList<String> = mutableListOf()
    private var sintomas: MutableList<Int> = mutableListOf()
    private var remedies: MutableList<String> = mutableListOf()

    constructor(name: String){
        this.name = name
        this.coincidence_value = 0
        this.coincidence_color = 0
        this.causes = mutableListOf()
        this.sintomas = mutableListOf()
        this.remedies = mutableListOf()
    }
    constructor(name: String, causes: MutableList<String>, sintomas: MutableList<Int>, remedies: MutableList<String>){
        this.name = name
        this.coincidence_value = 0
        this.coincidence_color = 0
        this.causes = causes
        this.sintomas = sintomas
        this.remedies = remedies
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

    fun setIllnessCoincidenceColor(number: Int){
        coincidence_color = number
    }

    fun getIllnessCoincidenceColor(): Int{
        return coincidence_color
    }

    fun addIllnessCause(new: String){
        causes.add(new)
    }

    fun getIllnessCauses(): MutableList<String>{
        return causes
    }

    fun addIllnessSintoma(new: Int){
        sintomas.add(new)
    }

    fun getIllnessSintomas(): MutableList<Int>{
        return sintomas
    }

    fun addIllnessRemedy(new: String){
        remedies.add(new)
    }

    fun getIllnessRemedies(): MutableList<String>{
        return remedies
    }
}