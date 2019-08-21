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

class EventAdapter(val context : Context, val eventList: ArrayList<EventModel>) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    override fun onBindViewHolder(v: ViewHolder, position: Int) {
        v?.day?.text = (position+1).toString()
        val rnds = (0..10).random()
        if (rnds>5) {
            v.trash.visibility = View.GONE
        }
        else{
            v.trash.visibility = View.VISIBLE
        }
        val rnds1 = (0..10).random()
        if (rnds1>5) {
            v.recycling.visibility = View.GONE
        }
        else{
            v.recycling.visibility = View.VISIBLE
        }
        val rnds2 = (0..10).random()
        if (rnds2>5) {
            v.cardboard.visibility = View.GONE
        }
        else{
            v.cardboard.visibility = View.VISIBLE
        }
        val rnds3 = (0..10).random()
        if (rnds3>5) {
            v.compost.visibility = View.GONE
        }
        else{
            v.compost.visibility = View.VISIBLE
        }

        if (position == 4)
        {
            v.holiday.visibility = View.VISIBLE
        }
        else
        {
            v.holiday.visibility = View.GONE
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.item_recycler_view_event, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val trash = itemView.findViewById<LinearLayout>(R.id.trash)
        val recycling = itemView.findViewById<LinearLayout>(R.id.recycling)
        val cardboard = itemView.findViewById<LinearLayout>(R.id.cardboard)
        val compost = itemView.findViewById<LinearLayout>(R.id.compost)
        val holiday = itemView.findViewById<ConstraintLayout>(R.id.holiday)
        val day = itemView.findViewById<TextView>(R.id.day)
    }
}