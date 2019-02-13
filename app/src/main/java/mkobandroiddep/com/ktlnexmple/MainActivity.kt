package mkobandroiddep.com.ktlnexmple

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatEditText
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var etEmail: AppCompatEditText
    lateinit var etConfPass: AppCompatEditText
    lateinit var etPass: AppCompatEditText
    lateinit var btnVerify: AppCompatButton

    lateinit var strEmail:String
    lateinit var strPass:String
    lateinit var strConfPass:String
    lateinit var sharedPreferences: SharedPreferences
    private val sharedPrefFile = "kotlinsharedpreference"

    val Tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewId()

        btnVerify.setOnClickListener(View.OnClickListener {

            strEmail        =etEmail.text.toString()
            strPass         =etPass.text.toString()
            strConfPass     =etConfPass.text.toString()

            if (!strEmail.equals("")) {
                if (strPass.equals(strConfPass)) {
                    Log.d(Tag, "$strEmail Pass:$strPass")
                    Toast.makeText(applicationContext,"Done",Toast.LENGTH_LONG).show()

                    intent = Intent(applicationContext,ListActivity::class.java)
                    intent.putExtra("Email",strEmail)
                    intent.putExtra("Pass",strConfPass)
                    startActivity(intent)

                    val editor:SharedPreferences.Editor =  sharedPreferences.edit()
                    editor.putString("id_email",strEmail)
                    editor.putString("pass_key",strConfPass)
                    editor.apply()
                    editor.commit()

                } else {
                    Toast.makeText(this@MainActivity, "Pass not same.", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this@MainActivity, "enter your email.", Toast.LENGTH_LONG).show()
            }

        })
    }

    fun findViewId(){
        etEmail         =findViewById(R.id.et_email)
        etPass          =findViewById(R.id.et_pass)
        etConfPass      =findViewById(R.id.et_conf_pass)
        btnVerify       =findViewById(R.id.btn_verify)

        sharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)


    }
}

