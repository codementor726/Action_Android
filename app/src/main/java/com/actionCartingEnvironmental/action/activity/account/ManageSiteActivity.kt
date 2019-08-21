package com.actionCartingEnvironmental.action.activity.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.adapter.EventAdapter
import com.actionCartingEnvironmental.action.adapter.SiteAdapter
import kotlinx.android.synthetic.main.activity_calendar.*
import kotlinx.android.synthetic.main.activity_manage_site.*
import java.util.ArrayList

class ManageSiteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_site)

        val siteLists = ArrayList<String>()
        for (i in 0 until 5) {
            siteLists.add(resources.getString(R.string.sample))
        }
        site_list.layoutManager = LinearLayoutManager(this)
        val adapter = SiteAdapter(this, siteLists,0)
        site_list.adapter = adapter
    }
}
