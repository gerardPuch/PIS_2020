package edu.ub.pis2020.gpuchcam7.mhealth.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Source {

    @SerializedName("id")
    @Expose
    var id: String = ""

    @SerializedName("name")
    @Expose
    var name: String = ""

    public fun getid(): String{
        return id
    }

    public fun setid(new: String){
        id = new
    }

    public fun getname(): String{
        return name
    }

    public fun setname(new: String){
        name = new
    }
}