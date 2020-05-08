package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

class SpinnerItem {
    lateinit var text: String
    var selected: Boolean = false

    fun setTextItem(new: String){
        this.text = new
    }

    fun getTextItem(): String{
        return this.text
    }

    fun setSelectedItem(state : Boolean){
        this.selected = state
    }

    fun isSelected(): Boolean{
        return this.selected
    }

    fun initializeItem(new: String){
        this.text = new
        this.selected = false
    }
}