package edu.ub.pis2020.gpuchcam7.mhealth.Model

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class ApiClient {
    private final val BASE_URL: String = "https://newsapi.org/v2/"
    private var apiClient: ApiClient? = null
    private var retrofit: Retrofit? = null

    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    public fun getInstance(): ApiClient{
        if (apiClient == null){
            apiClient = ApiClient()
        }
        return apiClient as ApiClient
    }

    public fun getApi(): ApiInterface{
        return retrofit!!.create(ApiInterface::class.java)
    }
}