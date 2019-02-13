package mkobandroiddep.com.ktlnexmple.fragments


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import mkobandroiddep.com.ktlnexmple.R

class PhpFragment : Fragment() {

    lateinit var tvEmail:AppCompatTextView
    lateinit var tvPass:AppCompatTextView
    lateinit var sharedPreferences: SharedPreferences
    private val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view=inflater.inflate(R.layout.fragment_php, container, false)

        tvEmail=view.findViewById(R.id.tv_email)
        tvPass=view.findViewById(R.id.tv_pass)

        val activity = activity

        sharedPreferences   = activity!!.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val id_email   = sharedPreferences.getString("id_email","abc")
        val id_pass = sharedPreferences.getString("pass_key","123")

        if(!(!id_email.equals(0) || !id_pass.equals("defaultname"))){
            tvEmail.setText("default Email: $id_email").toString()
            tvPass.text = "default Pass: $id_pass"
        }else{
            tvEmail.setText("default Email: $id_email").toString()
            tvPass.text = "default Pass: $id_pass"
        }

        return view
    }

}
