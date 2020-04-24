package edu.ub.pis2020.gpuchcam7.mhealth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.ub.pis2020.gpuchcam7.mhealth.Model.Adapter
import edu.ub.pis2020.gpuchcam7.mhealth.Model.ApiClient
import edu.ub.pis2020.gpuchcam7.mhealth.Model.Articles
import edu.ub.pis2020.gpuchcam7.mhealth.Model.Headlines
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

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
    lateinit var recyclerView: RecyclerView
    final val API_KEY: String = "52d4d09a2cdc408a8e7b94bac7ba97be" //la meva API KEY
    lateinit var adapter: Adapter
    lateinit var articles: List<Articles>
    /*-----------*/

    /*IMPLEMENTAT*/
    /*-----------*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*IMPLEMENTAT*/
        recyclerView = recyclerView.findViewById(R.id.recyclerView) //???? 34:00
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        var country: String = getCountry()
        retrieveJson(country, API_KEY)
        /*-----------*/

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    /*IMPLEMENTAT*/
    fun retrieveJson(country: String, apiKey: String){
        var call: Call<Headlines> = ApiClient().getInstance().getApi().getHeadlines(country, apiKey) as Call<Headlines>
        call.enqueue(object : Callback<Headlines>{
            override fun onResponse(call: Call<Headlines>, response: Response<Headlines>) {
                if (response.isSuccessful() && response.body()!!.getArticles() != null){
                    articles = emptyList()
                    articles = response.body()!!.getArticles()
                    adapter = Adapter(context!!, articles)
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<Headlines>, t: Throwable) {
                Toast.makeText(context!!, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun getCountry(): String{
        var locale: Locale = Locale.getDefault()
        return "11"
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
