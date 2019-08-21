package com.actionCartingEnvironmental.action.activity.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.dashboard.GuestDashboardActivity
import kotlinx.android.synthetic.main.activity_guest_access.*

class GuestAccessActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_access)
        //OnClick Event
        continue_guest.setOnClickListener(this)
        back.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            continue_guest -> {

                val guestIntent = Intent(this, GuestDashboardActivity::class.java)
                startActivity(guestIntent)
//                val guestIntent = Intent(this, RegistrationErrorActivity::class.java)
//                startActivity(guestIntent)
            }
            back -> {
                onBackPressed()
            }
        }
    }
}
