package edu.ub.pis2020.gpuchcam7.mhealth.Interface

import android.provider.ContactsContract
import edu.ub.pis2020.gpuchcam7.mhealth.Model.News
import edu.ub.pis2020.gpuchcam7.mhealth.Model.Website
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsService {
    @get:GET("v2/sources?apiKey=52d4d09a2cdc408a8e7b94bac7ba97be")
    val sources: Call<Website>

    @GET
    fun getNewsFromSource(@Url url: String) :Call<News>
}