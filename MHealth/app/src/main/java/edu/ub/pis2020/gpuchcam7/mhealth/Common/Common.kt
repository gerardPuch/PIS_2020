package edu.ub.pis2020.gpuchcam7.mhealth.Common

import edu.ub.pis2020.gpuchcam7.mhealth.Interface.NewsService
import edu.ub.pis2020.gpuchcam7.mhealth.Remote.RetrofitClient

object Common {
    val BASE_URL = "https://newsapi.org/"
    val API_KEY = "52d4d09a2cdc408a8e7b94bac7ba97be"

    val newsService: NewsService
        get() = RetrofitClient.getClient(BASE_URL).create(NewsService::class.java)
}