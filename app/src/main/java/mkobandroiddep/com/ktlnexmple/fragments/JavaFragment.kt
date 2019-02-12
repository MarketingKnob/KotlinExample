package mkobandroiddep.com.ktlnexmple.fragments


import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import mkobandroiddep.com.ktlnexmple.ConnectionDetector
import mkobandroiddep.com.ktlnexmple.R
import mkobandroiddep.com.ktlnexmple.TabFragActivity
import mkobandroiddep.com.ktlnexmple.adapter.ListItemAdapter
import mkobandroiddep.com.ktlnexmple.model.ModelApi
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class JavaFragment : Fragment() {

    lateinit var listView_details: ListView
    var arrayList: ArrayList<ModelApi> = ArrayList()

    val client = OkHttpClient()
    lateinit var cd: ConnectionDetector

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_java, container, false)
        val activity = activity

        cd = ConnectionDetector()
        cd.isConnectingToInternet(activity!!)
        if (cd.isConnectingToInternet(activity)) {
            run("http://planetory.agency/artist/Webservice/get_all_jobs")
        } else {
            Toast.makeText(activity,
                "no net", Toast.LENGTH_LONG).show()

        }

        return view
    }

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val str_response = response.body()!!.string()
                val json_contact = JSONObject(str_response)
                val json_array:JSONArray=json_contact.getJSONArray("data")
                var i:Int
                val size:Int=json_array.length()
                arrayList= ArrayList();

                for (i in 0 until size){

                    val json_objectdetail:JSONObject=json_array.getJSONObject(i)
                    val model= ModelApi();
                    model.title=json_objectdetail.getString("title")
                    model.categoryName=json_objectdetail.getString("category_name")
                    model.descriptor=json_objectdetail.getString("description")

                    arrayList.add(model)

                }

                activity!!.runOnUiThread {

                    val listAdapter:ListItemAdapter
                    listAdapter= ListItemAdapter(activity!!,arrayList)
                    listView_details.adapter=listAdapter

                }




            }
            override fun onFailure(call: Call, e: IOException) {

            }
        })
    }


}
