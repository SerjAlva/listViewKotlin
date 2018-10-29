package com.example.leserge.listviewkotlin

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ActionMenuView
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text

class Adaptador(private var activity: Activity, private var items: ArrayList<Estados>) : BaseAdapter() {

    private class ViewHolder(row: View?){
        var nombre: TextView? = null
        var capital: TextView? = null

        init {
            this.nombre = row?.findViewById<TextView>(R.id.nombre)
            this.capital = row?.findViewById<TextView>(R.id.capital)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder
        if(convertView == null){
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.renglon, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var estado = items[position]
        viewHolder.nombre?.text = estado.nombre
        viewHolder.capital?.text = estado.capital

        return view as View
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}