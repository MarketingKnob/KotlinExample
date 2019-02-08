package mkobandroiddep.com.ktlnexmple.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import mkobandroiddep.com.ktlnexmple.R


class JavaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         var view =inflater.inflate(R.layout.fragment_java, container, false)
        return view
    }


}
