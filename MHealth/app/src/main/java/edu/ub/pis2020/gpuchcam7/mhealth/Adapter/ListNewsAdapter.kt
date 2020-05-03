package edu.ub.pis2020.gpuchcam7.mhealth.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import edu.ub.pis2020.gpuchcam7.mhealth.Adapter.ViewHolder.ListNewsViewHolder
import edu.ub.pis2020.gpuchcam7.mhealth.Common.ISO8601Parser
import edu.ub.pis2020.gpuchcam7.mhealth.Interface.ItemClickListener
import edu.ub.pis2020.gpuchcam7.mhealth.Model.Articles
import edu.ub.pis2020.gpuchcam7.mhealth.R
import java.text.ParseException
import java.util.*

class ListNewsAdapter(val articleList:MutableList<Articles>, private val context: Context) :RecyclerView.Adapter<ListNewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNewsViewHolder {
        var inflater = LayoutInflater.from(parent!!.context)
        val itemView = inflater.inflate(R.layout.news_layout, parent, false)
        return ListNewsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ListNewsViewHolder, position: Int) {
        //Cargar Image
        Picasso.with(context)
            .load(articleList[position].urlToImage)
            .into(holder.article_image)


        if(articleList[position].title!!.length > 65){
            holder.article_title.text = articleList[position].title!!.substring(0,65)+"..."
        }
        else{
            holder.article_title.text = articleList[position].title!!
        }

        if(articleList[position].publishedAt != null){
            var date: Date? = null
            try{
                date = ISO8601Parser.parse(articleList[position].publishedAt!!) //27:31
            }
            catch (ex: ParseException) {
                ex.printStackTrace()
            }
            holder.article_time.setReferenceTime(date!!.time)
        }

        //Set Event Click
        holder.setItemClickListener(object :ItemClickListener{
            override fun onClick(view: View, position: Int) {
                //Per implementar
            }
        })
    }
}