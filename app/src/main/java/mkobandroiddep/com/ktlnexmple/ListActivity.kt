package mkobandroiddep.com.ktlnexmple

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.AppCompatButton
import android.view.View
import android.support.v7.widget.Toolbar
import android.widget.*
import kotlinx.android.synthetic.main.activity_list.*
import java.util.*

class ListActivity : AppCompatActivity(),View.OnClickListener {

    val languge= arrayOf<String>("abc","abe","abr","abt","aby")
    lateinit var btnDialog:AppCompatButton
    lateinit var btnTabFragment:AppCompatButton
    lateinit var btnTabViewpager:AppCompatButton
    lateinit var seekBar: SeekBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        findViewId()

        val language:Array<String> = resources.getStringArray(R.array.technology_list)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,language)

        listView.adapter=arrayAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val selecteditem = arrayAdapter.getItem(position).toString()
            val itemasPos = arrayAdapter.getItemId(position).toString()
            Toast.makeText(applicationContext, "click item $selecteditem its position $itemasPos", Toast.LENGTH_SHORT).show()

        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                Toast.makeText(applicationContext, "seekbar progress: $progress", Toast.LENGTH_SHORT).show()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

    }

    fun findViewId(){

        btnDialog       =findViewById(R.id.btn_dialog)
        btnTabFragment  =findViewById(R.id.btn_tab_frag)
        btnTabViewpager =findViewById(R.id.btn_tab_viewpager)
        seekBar         =findViewById(R.id.seekbar_Default)

        btnDialog.setOnClickListener(this)
        btnTabFragment.setOnClickListener(this)
        btnTabViewpager.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v==btnDialog){
            alertDialog()
        }else if(v==btnTabFragment){
            intent = Intent(this,TabFragActivity::class.java)
            startActivity(intent)
        }else if(v==btnTabViewpager){
            intent = Intent(this,TabViewPager::class.java)
            startActivity(intent)
        }
    }

//   Kotlin Function For Open Default Dialog

    fun alertDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.dialogTitle)
        builder.setMessage(R.string.dialogMessage)
        builder.setIcon(R.drawable.ic_warning_black_24dp)
        
        builder.setPositiveButton("Yes"){dialog, which ->
            Toast.makeText(this,"Clicked On Position Button ",Toast.LENGTH_SHORT).show()

            intent= Intent(this,WebViewActivity::class.java)
            startActivity(intent)
        }

        builder.setNeutralButton("Cancel") { dialog, which ->
            Toast.makeText(this, "Clicked On Neutral Button ", Toast.LENGTH_SHORT).show()


        }

        builder.setNegativeButton("No"){dialog, which ->
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.javatpoint.com/"))
            startActivity(intent)
        }

        val alertDialog:AlertDialog=builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}


