package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ub.pis2020.gpuchcam7.mhealth.R
import kotlinx.android.synthetic.main.illness_item.view.*
import kotlinx.android.synthetic.main.string_list_item.view.*
import java.util.ArrayList

class AdapterStringList(context: Context, resource: Int, objects: ArrayList<String>): ArrayAdapter<String>(context, resource, objects){
    lateinit var mContext: Context
    lateinit var listItems: ArrayList<String>
    lateinit var myAdapter: AdapterStringList

    init {
        this.mContext = context
        this.listItems = objects
        this.myAdapter = this
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        lateinit var holder: ViewHolderStringList
        lateinit var view: View

        //Comprobar si hay view
        if(convertView == null){ //Crea el ViewHolder i el View
            var layoutInflator: LayoutInflater = LayoutInflater.from(mContext)
            view = layoutInflator.inflate(R.layout.string_list_item, null)
            holder = ViewHolderStringList(view)
            holder.mTextView = view.string_element
            view.tag = holder //asocia el View y ViewHolder
        } else {//Coge el viewHolder
            view = convertView
            holder = view.tag as ViewHolderStringList
        }

        holder.mTextView!!.setText(listItems.get(position))

        return view
    }
}

class ViewHolderStringList(itemView: View): RecyclerView.ViewHolder(itemView){
    lateinit var mTextView: TextView
}