package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import edu.ub.pis2020.gpuchcam7.mhealth.IllnessActivity
import edu.ub.pis2020.gpuchcam7.mhealth.R
import kotlinx.android.synthetic.main.illness_item.view.*
import java.util.ArrayList

class AdapterIllness(context: Context, resource: Int, objects: MutableList<Illness>): ArrayAdapter<Illness>(context, resource, objects) {
    lateinit var mContext: Context
    lateinit var listItems: MutableList<Illness>
    lateinit var myAdapter: AdapterIllness
    var isFromView: Boolean = false

    init {
        this.mContext = context
        this.listItems = objects
        this.myAdapter = this
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        lateinit var holder: ViewHolderIllness
        lateinit var view: View

        //Comprobar si hay view
        if(convertView == null){ //Crea el ViewHolder i el View
            var layoutInflator: LayoutInflater = LayoutInflater.from(mContext)
            view = layoutInflator.inflate(R.layout.illness_item, null)
            holder = ViewHolderIllness(view)
            holder.mTextView = view.illness_name
            holder.mCoincidenceNumber = view.illness_coincidence_number
            view.tag = holder //asocia el View y ViewHolder
        } else {//Coge el viewHolder
            view = convertView
            holder = view.tag as ViewHolderIllness
         }

        holder.mTextView!!.setText(listItems.get(position).getIllnessName())

        isFromView = true
        holder.mCoincidenceNumber.setText(listItems.get(position).getIllnessCoincidenceValue().toString())
        if (listItems.get(position).getIllnessCoincidenceColor() < 20){
            holder.mCoincidenceNumber.setBackgroundResource(R.drawable.green_circle_illness)
        }else if(listItems.get(position).getIllnessCoincidenceColor() > 20 && listItems.get(position).getIllnessCoincidenceColor() < 40){
            holder.mCoincidenceNumber.setBackgroundResource(R.drawable.kiwi_circle_illness)
        }else if(listItems.get(position).getIllnessCoincidenceColor() > 40 && listItems.get(position).getIllnessCoincidenceColor() < 60){
            holder.mCoincidenceNumber.setBackgroundResource(R.drawable.yellow_circle_illness)
        }else if(listItems.get(position).getIllnessCoincidenceColor() > 60 && listItems.get(position).getIllnessCoincidenceColor() < 80){
            holder.mCoincidenceNumber.setBackgroundResource(R.drawable.orange_circle_illness)
        }else if(listItems.get(position).getIllnessCoincidenceColor() > 80){
            holder.mCoincidenceNumber.setBackgroundResource(R.drawable.red_circle_illness)
        }
        isFromView = false

        holder.itemView.setOnClickListener({
            val intent = Intent(mContext, IllnessActivity::class.java)
            val causes = listItems.get(position).getIllnessCauses() as ArrayList<String>
            val sintomas = listItems.get(position).getIllnessSintomas() as ArrayList<Int>
            val remedies = listItems.get(position).getIllnessRemedies() as ArrayList<String>
            intent.putStringArrayListExtra("causes", causes)
            intent.putIntegerArrayListExtra("sintomas", sintomas)
            intent.putStringArrayListExtra("remedies", remedies)
            mContext.startActivity(intent)
        })

        return view
    }

}
class ViewHolderIllness(itemView: View): RecyclerView.ViewHolder(itemView){
    lateinit var mTextView: TextView
    lateinit var mCoincidenceNumber: TextView
}