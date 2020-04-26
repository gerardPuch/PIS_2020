package edu.ub.pis2020.gpuchcam7.mhealth.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Headlines {

    @SerializedName("status")
    @Expose
    val status: String = ""

    @SerializedName("totalResults")
    @Expose
    val totalResults: String = ""

    @SerializedName("articles")
    @Expose
    val articles: List<Articles> = listOf()

}