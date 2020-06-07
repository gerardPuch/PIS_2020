package edu.ub.pis2020.gpuchcam7.mhealth

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import dmax.dialog.SpotsDialog
import edu.ub.pis2020.gpuchcam7.mhealth.News.ListNewsAdapter
import edu.ub.pis2020.gpuchcam7.mhealth.News.Common
import edu.ub.pis2020.gpuchcam7.mhealth.News.NewsService
import edu.ub.pis2020.gpuchcam7.mhealth.News.News
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_news.swipe_to_refresh
import retrofit2.Call
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {

    private var webHotUrl: String = "https://newsapi.org/v2/everything?q=OMS&language=es&apiKey=52d4d09a2cdc408a8e7b94bac7ba97be"

    lateinit private var dialog: AlertDialog
    lateinit private var mService: NewsService
    lateinit private var adapter: ListNewsAdapter
    lateinit private var layoutManager: LinearLayoutManager

    lateinit private var parentContext: Context

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        this.parentContext = context!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Init View
        mService = Common.newsService

        dialog = SpotsDialog(parentContext)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipe_to_refresh.setOnRefreshListener {
            loadNews(true)
        }

        list_news.setHasFixedSize(true)
        list_news.layoutManager = LinearLayoutManager(parentContext)

        loadNews(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment().apply {}
    }

    private fun loadNews(isRefreshed: Boolean) {
        if(isRefreshed){
            dialog.show()
            mService.getNewsFromSource(webHotUrl)
                .enqueue(object : retrofit2.Callback<News> {
                    override fun onFailure(call: Call<News>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(call: Call<News>, response: Response<News>) {
                        dialog.dismiss()

                        if(response!!.body()!!.articles!![0].urlToImage == null){// si no hay imagen disponible se carga una por defecto
                            response!!.body()!!.articles!![0].urlToImage = "https://www.eventoplus.com/content/thumbs/960_540/content/imgsxml/galerias/noticias/6883/big-comunicado-oms-urgencias652.jpg"
                        }

                        //Obtener primer articulo de las hot news
                        Picasso.with(parentContext)
                            .load(response!!.body()!!.articles!![0].urlToImage)
                            .into(top_image)

                        top_title.text = "Notícies de la OMS i salut"

                        //Cargar el resto de articulos
                        val listItem = response!!.body()!!.articles

                        //El primer objeto de las hot news es un duplicado, tenemos que eliminarlo
                        listItem!!.removeAt(0)

                        adapter =
                            ListNewsAdapter(
                                listItem!!,
                                parentContext
                            )
                        adapter.notifyDataSetChanged()
                        list_news.adapter = adapter

                    }
                })
        }
        else{
            swipe_to_refresh.isRefreshing = true
            mService.getNewsFromSource(webHotUrl)
                .enqueue(object : retrofit2.Callback<News> {
                    override fun onFailure(call: Call<News>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(call: Call<News>, response: Response<News>) {
                        swipe_to_refresh.isRefreshing = false

                        //Obtener primer articulo de las hot news

                        if(response!!.body()!!.articles!![0].urlToImage == null){// si no hay imagen disponible se carga una por defecto
                            response!!.body()!!.articles!![0].urlToImage = "https://www.eventoplus.com/content/thumbs/960_540/content/imgsxml/galerias/noticias/6883/big-comunicado-oms-urgencias652.jpg"
                        }

                        //Cargamos la imagen del primer articulo si esta disponible
                        Picasso.with(parentContext)
                            .load(response!!.body()!!.articles!![0].urlToImage)
                            .into(top_image)

                        top_title.text = "Notícies de la OMS i salut"

                        //Cargar el resto de articulos
                        val listItem = response!!.body()!!.articles

                        //El primer objeto de las hot news es un duplicado, tenemos que eliminarlo
                        listItem!!.removeAt(0)

                        adapter =
                            ListNewsAdapter(
                                listItem!!,
                                parentContext
                            )
                        adapter.notifyDataSetChanged()
                        list_news.adapter = adapter
                    }
                })
        }
    }
}
