package edu.ub.pis2020.gpuchcam7.mhealth.Model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import edu.ub.pis2020.gpuchcam7.mhealth.R

class Adapter : RecyclerView.Adapter<ViewHolder> {

    lateinit var context: Context
    lateinit var articles: List<Articles>

    constructor(context: Context, articles: List<Articles>) {
        this.context = context
        this.articles = articles
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var a: Articles = articles.get(position)
        holder.tvTitle.setText(a.gettitle())
        holder.tvSource.setText(a.getsource().name)
        holder.tvDate.setText(a.getpublishedAt())

        var imageUrl: String = a.geturlToImage()

        Picasso.with(this.context).load(imageUrl).into(holder.imageView)
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    var tvSource: TextView = itemView.findViewById(R.id.tvSource)
    var tvDate: TextView = itemView.findViewById(R.id.tvDate)
    var imageView: ImageView = itemView.findViewById(R.id.image)
    var cardView: CardView = itemView.findViewById(R.id.card)
}