package edu.ub.pis2020.gpuchcam7.mhealth.News

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient { //Interficie per fer crides web
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String?): Retrofit{
        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}