package edu.ub.pis2020.gpuchcam7.mhealth.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.ub.pis2020.gpuchcam7.mhealth.Adapter.ViewHolder.ListNewsViewHolder
import edu.ub.pis2020.gpuchcam7.mhealth.Model.Articles
import edu.ub.pis2020.gpuchcam7.mhealth.R

class ListNewsAdapter(val articleList:List<Articles>, private val context: Context) :RecyclerView.Adapter<ListNewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNewsViewHolder {
        var inflater = LayoutInflater.from(parent!!.context)
        val itemView = inflater.inflate(R.layout.news_layout, parent, false)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListNewsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}