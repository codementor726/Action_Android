package com.actionCartingEnvironmental.action.activity.dashboard

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.calendar.CalendarActivity
import com.actionCartingEnvironmental.action.activity.support.SupportActivity
import com.actionCartingEnvironmental.action.dialog.LaborDialogFragment
import com.actionCartingEnvironmental.action.dialog.RegisterDialogFragment
import com.actionCartingEnvironmental.action.dialog.WinterDialogFragment
import io.intercom.android.sdk.Intercom
import kotlinx.android.synthetic.main.activity_guest_dashboard.*
import kotlinx.android.synthetic.main.activity_guest_dashboard.message_us
import kotlinx.android.synthetic.main.activity_guest_dashboard.support_center
import kotlinx.android.synthetic.main.dialog_labor_schedule.*
import kotlinx.android.synthetic.main.dialog_login_detail.*
import kotlinx.android.synthetic.main.dialog_register.*
import kotlinx.android.synthetic.main.dialog_register.close
import kotlinx.android.synthetic.main.dialog_winter_schedule.*
import kotlinx.android.synthetic.main.dialog_winter_schedule.done
import kotlinx.android.synthetic.main.dialog_winter_schedule.text
import kotlinx.android.synthetic.main.include_collection_date.*
import kotlinx.android.synthetic.main.include_help.*
import kotlinx.android.synthetic.main.include_upcoming_holidays.*
import kotlinx.android.synthetic.main.include_upcoming_holidays.calendar

class GuestDashboardActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_dashboard)
        //set Clickable text
        buildSpannbleTextView();
        //OnClick Event
        register.setOnClickListener(this)
        calendar.setOnClickListener(this)
        message_us.setOnClickListener(this)
        support_center.setOnClickListener(this)
    }

    private fun buildSpannbleTextView() {
        val spannableString = SpannableString("There will be no service tonight due to storm conditions. see details")
        val clickableSpan = object :ClickableSpan()
        {
            override fun onClick(v: View) {
                WinterDialogFragment.show(this@GuestDashboardActivity)
            }
        }
        val clickableSpan1 = object :ClickableSpan()
        {
            override fun onClick(v: View) {
                LaborDialogFragment.show(this@GuestDashboardActivity)
            }
        }
        spannableString.setSpan(clickableSpan,14,32,0)
        spannableString.setSpan(UnderlineSpan(), 14, 32, 0)
        spannableString.setSpan(ForegroundColorSpan(resources.getColor(android.R.color.darker_gray)), 14, 32, 0)
        spannableString.setSpan(clickableSpan1,58,69,0)
        spannableString.setSpan(UnderlineSpan(), 58, 69, 0)
        alert_text.text = spannableString
        alert_text.movementMethod = LinkMovementMethod.getInstance()
    }

    override fun onClick(v: View?) {
        when(v)
        {
            register ->
            {
                RegisterDialogFragment.show(this@GuestDashboardActivity)
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
