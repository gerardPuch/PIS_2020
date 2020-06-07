package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ub.pis2020.gpuchcam7.mhealth.R
import kotlinx.android.synthetic.main.spinner_item.view.*


class AdapterSpinner(context: Context, resource: Int, objects: MutableList<SpinnerItem>): ArrayAdapter<SpinnerItem>(context, resource, objects) {
    lateinit private var mContext: Context
    lateinit private var listState: MutableList<SpinnerItem>
    lateinit private var myAdapter: AdapterSpinner
    private var isFromView: Boolean = false

    init {
        this.mContext = context
        this.listState = objects
        this.myAdapter = this
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View{
        lateinit var holder: ViewHolder
        lateinit var view: View

        //Comprobar si hay view
        if(convertView == null){ //Crea el ViewHolder i el View
            var layoutInflator: LayoutInflater = LayoutInflater.from(mContext)
            view = layoutInflator.inflate(R.layout.spinner_item, null)
            holder = ViewHolder(view)
            holder.mTextView = view.text
            holder.mCheckBox = view.checkbox
            view.tag = holder //asocia el View y ViewHolder
        } else {//Coge el viewHolder
            view = convertView
            holder = view.tag as ViewHolder
        }

        holder.mTextView!!.setText(listState.get(position).getTextItem())

        isFromView = true
        holder.mCheckBox!!.setChecked(listState.get(position).isSelected());
        isFromView = false;

        if(listState.size > 1){
            if ((position == 0)) {
                holder.mCheckBox.setVisibility(View.INVISIBLE);
            } else {
                holder.mCheckBox.setVisibility(View.VISIBLE);
            }
        }
        holder.mCheckBox.setTag(position);
        holder.mCheckBox.setOnCheckedChangeListener({ buttonView, isChecked ->
            if (!isFromView) {
                listState.get(position).setSelectedItem(isChecked)
            }
        })
        return view
    }
}

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    lateinit var mTextView: TextView
    lateinit var mCheckBox: CheckBox
}
