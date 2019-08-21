package com.actionCartingEnvironmental.action.activity.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.BaseActivity
import com.actionCartingEnvironmental.action.dialog.RequestDialogFragment
import kotlinx.android.synthetic.main.activity_action_dashboard.*
import kotlinx.android.synthetic.main.activity_iwsdashboard.*
import kotlinx.android.synthetic.main.activity_iwsdashboard.setting
import kotlinx.android.synthetic.main.include_collection_date.*

class IWSDashboardActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iwsdashboard)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorLightGreen));
        //OnClick Event
        setting.setOnClickListener(this)
        request_service.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v)
        {
            request_service ->
            {
                RequestDialogFragment.show(this@IWSDashboardActivity)
            }
            setting ->
            {
                val settingIntent = Intent(this, ActionDashboardActivity::class.java)
                startActivity(settingIntent)
                finish()
            }
        }
    }
}
