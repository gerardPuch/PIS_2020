package edu.ub.pis2020.gpuchcam7.mhealth

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import dmax.dialog.SpotsDialog
import edu.ub.pis2020.gpuchcam7.mhealth.Adapter.ListSourceAdapter
import edu.ub.pis2020.gpuchcam7.mhealth.Common.Common
import edu.ub.pis2020.gpuchcam7.mhealth.Interface.NewsService
import edu.ub.pis2020.gpuchcam7.mhealth.Model.Website
import io.paperdb.Paper
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    /*IMPLEMENTAT*/
    lateinit var layoutManager: LinearLayoutManager
    lateinit var mService: NewsService
    lateinit var adapter: ListSourceAdapter
    lateinit var dialog: AlertDialog
    /*-----------*/

    /*IMPLEMENTAT*/
    /*-----------*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        /*IMPLEMENTAT*/

        //Init cache DB
        Paper.init(activity)

        //Init Servicio
        mService = Common.newsService

        //Init View
        /*swipe_to_refresh.setOnRefreshListener{
            loadWebSiteSource(true)
        }

        recycler_view_source_news.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(activity)
        recycler_view_source_news.layoutManager = layoutManager

        dialog = SpotsDialog(activity)

        loadWebSiteSource(false)
        /*-----------*/*/
    }

    /*IMPLEMENTAT*/
    private fun loadWebSiteSource (isRefresh: Boolean) {
        if(!isRefresh){
            val cache = Paper.book().read<String>("cache")
            if(cache != null && !cache.isBlank() && cache != "null"){
                //Leer Cache
                val webSite = Gson().fromJson<Website>(cache, Website::class.java)
                adapter = ListSourceAdapter(activity!!.baseContext, webSite)
                adapter.notifyDataSetChanged()
                recycler_view_source_news.adapter = adapter
            }
            else{
                //Cargar web y escribir en cache
                dialog.show()
                //Buscar la nueva data
                mService.sources.enqueue(object: retrofit2.Callback<Website>{
                    override fun onFailure(call: Call<Website>, t: Throwable) {
                        Toast.makeText(activity!!.baseContext, "Failed", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Website>, response: Response<Website>) {
                        adapter = ListSourceAdapter(activity!!.baseContext, response!!.body()!!)
                        adapter.notifyDataSetChanged()
                        recycler_view_source_news.adapter = adapter

                        //Guardar en cahce
                        Paper.book().write("cache", Gson().toJson(response!!.body()!!))

                        dialog.dismiss()
                    }
                })
            }
        }
        else{
            swipe_to_refresh.isRefreshing = true

            //Buscar la nueva data
            mService.sources.enqueue(object: retrofit2.Callback<Website>{
                override fun onFailure(call: Call<Website>, t: Throwable) {
                    Toast.makeText(activity!!.baseContext, "Failed", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Website>, response: Response<Website>) {
                    adapter = ListSourceAdapter(activity!!.baseContext, response!!.body()!!)
                    adapter.notifyDataSetChanged()
                    recycler_view_source_news.adapter = adapter

                    //Guardar en cahce
                    Paper.book().write("cache", Gson().toJson(response!!.body()!!))

                    swipe_to_refresh.isRefreshing = false
                }
            })
        }
    }
    /*-----------*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
