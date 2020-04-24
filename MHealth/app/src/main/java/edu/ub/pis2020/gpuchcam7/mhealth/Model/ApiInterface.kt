package edu.ub.pis2020.gpuchcam7.mhealth.Model

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("Top_headlines")
    fun getHeadlines(@Query("country") country: String, @Query("apiKey") apiKey: String): Call
}