package edu.ub.pis2020.gpuchcam7.mhealth.News

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import edu.ub.pis2020.gpuchcam7.mhealth.NewDetailActivity
import edu.ub.pis2020.gpuchcam7.mhealth.R
import kotlinx.android.synthetic.main.news_layout.view.*
import java.text.ParseException
import java.util.*

//Adapter del view de cada noticia
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
        holder.itemView.setOnClickListener {
            val detail = Intent(context, NewDetailActivity::class.java)
            detail.putExtra("webURL", articleList[position].url)
            detail.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //Calling startActivity() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag. Is this really what you want?
            context.startActivity(detail)
        }
    }
}

class ListNewsViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    var article_title = itemView.article_title
    var article_time = itemView.article_time
    var article_image = itemView.article_image
}