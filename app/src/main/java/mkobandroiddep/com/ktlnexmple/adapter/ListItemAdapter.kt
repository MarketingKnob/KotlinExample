package mkobandroiddep.com.ktlnexmple.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import mkobandroiddep.com.ktlnexmple.R
import mkobandroiddep.com.ktlnexmple.model.ModelApi



class ListItemAdapter(context: Context,arrayList: ArrayList<ModelApi>):BaseAdapter() {
    private val layoutInflater: LayoutInflater
    private var arrayListDetails: ArrayList<ModelApi>


    init {
        this.layoutInflater = LayoutInflater.from(context)
        this.arrayListDetails = arrayList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val listRowHolder: ListRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.list_items, parent, false)
            listRowHolder = ListRowHolder(view)
            view.tag = listRowHolder
        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }

        listRowHolder.tvName.text = arrayListDetails.get(position).categoryName
        listRowHolder.tvdescription.text = arrayListDetails.get(position).descriptor
        listRowHolder.title.text = arrayListDetails.get(position).title
        return view

    }


    override fun getItem(position: Int): Any {

        return arrayListDetails.get(position)

    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayListDetails.size
    }

    private class ListRowHolder(row: View?) {
        val tvName: TextView
        val tvdescription: TextView
        val title: TextView
        val linearLayout: LinearLayout

        init {
            this.title = row!!.findViewById<TextView>(R.id.tvId)
            this.tvName = row.findViewById<TextView>(R.id.tvName)
            this.tvdescription = row.findViewById<TextView>(R.id.tvEmail)
            this.linearLayout = row.findViewById<LinearLayout>(R.id.linearLayout)
        }

    }
}
