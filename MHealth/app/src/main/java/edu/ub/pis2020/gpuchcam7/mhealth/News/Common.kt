package edu.ub.pis2020.gpuchcam7.mhealth.News

import edu.ub.pis2020.gpuchcam7.mhealth.News.RetrofitClient

//Objecto para gestionar los enlaces y llamadas de la NewsAPI
object Common {
    val BASE_URL = "https://newsapi.org/"
    val API_KEY = "52d4d09a2cdc408a8e7b94bac7ba97be"

    val newsService: NewsService
        get() = RetrofitClient.getClient(BASE_URL).create(NewsService::class.java)
}