package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

class SpinnerItem {
    lateinit private var text: String
    private var selected: Boolean = false
    private var id: Int = -1

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

    fun setID(value: Int){
        this.id = value
    }

    fun getID(): Int{
        return  this.id
    }
}