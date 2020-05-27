package edu.ub.pis2020.gpuchcam7.mhealth

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import dmax.dialog.SpotsDialog
import edu.ub.pis2020.gpuchcam7.mhealth.Adapter.ListNewsAdapter
import edu.ub.pis2020.gpuchcam7.mhealth.Common.Common
import edu.ub.pis2020.gpuchcam7.mhealth.Interface.NewsService
import edu.ub.pis2020.gpuchcam7.mhealth.Model.News
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.fragment_news.swipe_to_refresh
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity : AppCompatActivity() {

    var source = ""
    var webHotUrl: String? = ""
    
    lateinit var dialog: AlertDialog
    lateinit var mService: NewsService
    lateinit var adapter: ListNewsAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        //Init View
        mService = Common.newsService

        dialog = SpotsDialog(this)

        swipe_to_refresh.setOnRefreshListener {
            loadNews(source, true)
        }

        diagonalLayout.setOnClickListener{
            val detail = Intent(baseContext, NewDetailActivity::class.java)
            detail.putExtra("webURL", webHotUrl)
            startActivity(detail)
        }

        list_news.setHasFixedSize(true)
        list_news.layoutManager = LinearLayoutManager(this)

        if(intent != null){
            source = intent.getStringExtra("source")
            if(!source.isEmpty())
                loadNews(source, false)
        }
    }

    private fun loadNews(source: String?, isRefreshed: Boolean) {
        if(isRefreshed){
            dialog.show()
            mService.getNewsFromSource(Common.getNewsAPI(source!!))
                .enqueue(object : Callback<News>{
                    override fun onFailure(call: Call<News>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(call: Call<News>, response: Response<News>) {
                        dialog.dismiss()

                        //Obtener primer articulo de las hot news
                        Picasso.with(baseContext)
                            .load(response!!.body()!!.articles!![0].urlToImage)
                            .into(top_image)

                        top_title.text = response!!.body()!!.articles!![0].title
                        top_author.text = response!!.body()!!.articles!![0].author

                        webHotUrl = response!!.body()!!.articles!![0].url

                        //Cargar el resto de articulos
                        val removeFirstItem = response!!.body()!!.articles

                        //Como hemos obtenido el primer objeto de las hot news, tenemos que eliminarlo
                        removeFirstItem!!.removeAt(0)

                        adapter = ListNewsAdapter(removeFirstItem!!, baseContext)
                        adapter.notifyDataSetChanged()
                        list_news.adapter = adapter

                    }

                })
        }
        else{
            swipe_to_refresh.isRefreshing = true
            mService.getNewsFromSource(Common.getNewsAPI(source!!))
                .enqueue(object : Callback<News>{
                    override fun onFailure(call: Call<News>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(call: Call<News>, response: Response<News>) {
                        swipe_to_refresh.isRefreshing = false

                        //Obtener primer articulo de las hot news
                        Picasso.with(baseContext)
                            .load(response!!.body()!!.articles!![0].urlToImage)
                            .into(top_image)

                        top_title.text = response!!.body()!!.articles!![0].title
                        top_author.text = response!!.body()!!.articles!![0].author

                        webHotUrl = response!!.body()!!.articles!![0].url

                        //Cargar el resto de articulos
                        val removeFirstItem = response!!.body()!!.articles

                        //Como hemos obtenido el primer objeto de las hot news, tenemos que eliminarlo
                        removeFirstItem!!.removeAt(0)

                        adapter = ListNewsAdapter(removeFirstItem!!, baseContext)
                        adapter.notifyDataSetChanged()
                        list_news.adapter = adapter

                    }

                })
        }
    }
    fun clickOnArticle(intent: Intent){

    }
}
