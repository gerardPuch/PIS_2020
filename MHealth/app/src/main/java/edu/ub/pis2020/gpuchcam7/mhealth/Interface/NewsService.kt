package edu.ub.pis2020.gpuchcam7.mhealth.Interface

import android.provider.ContactsContract
import retrofit2.http.GET

interface NewsService {
    @get:GET("v2/sources?apiKey=52d4d09a2cdc408a8e7b94bac7ba97be")
    val sources: Call<ContactsContract.CommonDataKinds.Website>
}