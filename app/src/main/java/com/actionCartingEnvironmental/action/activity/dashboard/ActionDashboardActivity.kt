package com.actionCartingEnvironmental.action.activity.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.BaseActivity
import com.actionCartingEnvironmental.action.activity.account.AccountActivity
import com.actionCartingEnvironmental.action.activity.calendar.CalendarActivity
import com.actionCartingEnvironmental.action.activity.support.SupportActivity
import com.actionCartingEnvironmental.action.adapter.SiteAdapter
import com.actionCartingEnvironmental.action.dialog.LaborDialogFragment
import com.actionCartingEnvironmental.action.dialog.RequestDialogFragment
import com.actionCartingEnvironmental.action.dialog.WinterDialogFragment
import io.intercom.android.sdk.Intercom
import kotlinx.android.synthetic.main.activity_manage_site.*
import kotlinx.android.synthetic.main.include_collection_date.*
import kotlinx.android.synthetic.main.include_dashboard_header.*
import kotlinx.android.synthetic.main.include_help.*
import kotlinx.android.synthetic.main.include_help.message_us
import java.util.ArrayList

class ActionDashboardActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_dashboard)
        //OnClick Event
        request_service.setOnClickListener(this)
        setting.setOnClickListener(this)
        calendar.setOnClickListener(this)
        support_center.setOnClickListener(this)
        message_us.setOnClickListener(this)

        val siteLists = ArrayList<String>()
        for (i in 0 until 5) {
            siteLists.add(resources.getString(R.string.sample))
        }
        site_list.layoutManager = LinearLayoutManager(this)
        val adapter = SiteAdapter(this, siteLists,1)
        site_list.adapter = adapter
    }

    override fun onClick(v: View?) {
        when(v)
        {
            request_service ->
            {

                RequestDialogFragment.show(this@ActionDashboardActivity)
            }
            setting ->
            {
                val accountIntent = Intent(this, AccountActivity::class.java)
                startActivity(accountIntent)
            }
            calendar ->
            {
                val calendarIntent = Intent(this, CalendarActivity::class.java)
                startActivity(calendarIntent)
            }
            support_center ->
            {
                val calendarIntent = Intent(this, SupportActivity::class.java)
                startActivity(calendarIntent)
            }
            message_us ->
            {
                Intercom.client().displayMessenger()
            }
        }
    }

}
