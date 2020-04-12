package edu.ub.pis2020.gpuchcam7.mhealth.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
//API KEY: 52d4d09a2cdc408a8e7b94bac7ba97be

public class Headlines {

    @SerializedName("status")
    @Expose
    private var status: String = ""

    @SerializedName("totalResults")
    @Expose
    private var totalResults: String = ""

    @SerializedName("articles")
    @Expose
    private var articles: List<Articles> = listOf()

    public fun getStatus(): String{
        return status
    }

    public fun getTotalResults(): String{
        return totalResults
    }

    public fun getArticles(): List<Articles>{
        return articles
    }
}