package edu.ub.pis2020.gpuchcam7.mhealth.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import edu.ub.pis2020.gpuchcam7.mhealth.Adapter.ViewHolder.ListSourceViewHolder
import edu.ub.pis2020.gpuchcam7.mhealth.Interface.ItemClickListener
import edu.ub.pis2020.gpuchcam7.mhealth.Model.Website
import edu.ub.pis2020.gpuchcam7.mhealth.NewsActivity
import edu.ub.pis2020.gpuchcam7.mhealth.R

class ListSourceAdapter (private val context: Context, private val webSite: Website) : RecyclerView.Adapter<ListSourceViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSourceViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val itemView = inflater.inflate(R.layout.source_news_layout, parent, false)
        return ListSourceViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return webSite.sources!!.size
    }

    override fun onBindViewHolder(holder: ListSourceViewHolder, position: Int) {
        holder.source_title.text = webSite.sources!![position].name

        holder.itemView.setOnClickListener {
            val intent = Intent(context, NewsActivity::class.java)
            intent.putExtra("source", webSite.sources!![position].id)
            context.startActivity(intent)
        }

        /*holder.setItemClickListener(object  : ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(context, NewsActivity::class.java)
                intent.putExtra("source", webSite.sources!![position].id)
                context.startActivity(intent)
            }
        })*/

        /*holder.setItemClickListener(object : ItemClickListener{
            override fun onClick(view: View, position: Int) {
                Toast.makeText(context, "S'ha fet Click", Toast.LENGTH_SHORT).show()
            }

        })*/

    }

}