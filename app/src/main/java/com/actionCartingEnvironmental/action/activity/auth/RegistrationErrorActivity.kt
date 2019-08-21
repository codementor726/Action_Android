package com.actionCartingEnvironmental.action.activity.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.dashboard.GuestDashboardActivity
import kotlinx.android.synthetic.main.activity_registration_error.*

class RegistrationErrorActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_error)
        //OnClick Event
        back.setOnClickListener(this)
        continue_guest.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v) {
            back -> {
                onBackPressed()
            }
            continue_guest -> {
                val guestIntent = Intent(this, GuestDashboardActivity::class.java)
                startActivity(guestIntent)
            }
        }
    }

}
