package com.actionCartingEnvironmental.action.activity.service

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.dashboard.ActionDashboardActivity
import com.actionCartingEnvironmental.action.activity.support.SupportActivity
import com.actionCartingEnvironmental.action.dialog.SubmitFragment
import kotlinx.android.synthetic.main.activity_additional_pickup.*
import kotlinx.android.synthetic.main.activity_additional_pickup.done
import kotlinx.android.synthetic.main.activity_bulk_pick_up.*
import kotlinx.android.synthetic.main.dialog_submit.*
import kotlinx.android.synthetic.main.dialog_winter_schedule.*
import kotlinx.android.synthetic.main.view_title.*

class BulkPickUpActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bulk_pick_up)
        close.setOnClickListener(this)
        done.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v)
        {
            close ->
            {
                onBackPressed()
            }
            done ->
            {
                SubmitFragment.show(this@BulkPickUpActivity)
            }
        }
    }
}
