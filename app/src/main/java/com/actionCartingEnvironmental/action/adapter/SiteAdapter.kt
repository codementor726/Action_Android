package com.actionCartingEnvironmental.action.adapter

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.VisibleForTesting
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.model.EventModel
import java.util.*
import kotlin.collections.ArrayList

class SiteAdapter(val context : Context, val eventList: ArrayList<String>, val type: Int) : RecyclerView.Adapter<SiteAdapter.ViewHolder>() {

    override fun onBindViewHolder(v: ViewHolder, position: Int) {
//        v?.day?.text = (position+1).toString()
        if (type == 1)
        {
            v.sitName.setTextColor(context.resources.getColor(android.R.color.darker_gray))
            v.siteUrl.setTextColor(context.resources.getColor(android.R.color.darker_gray))
            v.line.setBackgroundColor(context.resources.getColor(android.R.color.darker_gray))
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.item_recyclerview_site, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sitName = itemView.findViewById<TextView>(R.id.site_name)
        val line = itemView.findViewById<View>(R.id.line)
        val siteUrl = itemView.findViewById<TextView>(R.id.site_url)
    }
}