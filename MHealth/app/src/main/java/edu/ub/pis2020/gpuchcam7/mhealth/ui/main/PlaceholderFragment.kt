package edu.ub.pis2020.gpuchcam7.mhealth.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import edu.ub.pis2020.gpuchcam7.mhealth.GuiaFragment
import edu.ub.pis2020.gpuchcam7.mhealth.NewsFragment
import edu.ub.pis2020.gpuchcam7.mhealth.R
import edu.ub.pis2020.gpuchcam7.mhealth.SintomasFragment

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater .inflate(R.layout.fragment_sintomas, container, false)
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): Fragment? {
            var fragment: Fragment? = null

            when (sectionNumber){
                1 -> fragment = SintomasFragment()
                2 -> fragment = NewsFragment()
            }
            return fragment
        }
    }
}