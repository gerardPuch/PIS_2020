package edu.ub.pis2020.gpuchcam7.mhealth.News

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsService { //endpoints interface, necesaria para obtener informacion del source
    @get:GET("v2/everything?q=OMS&language=es&apiKey=52d4d09a2cdc408a8e7b94bac7ba97be")
    val sources: Call<Website>

    @GET
    fun getNewsFromSource(@Url url: String) :Call<News>
}