package com.actionCartingEnvironmental.action.activity.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.dashboard.ActionDashboardActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_activity_sign.*

class WelcomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        //OnClick Event
        register.setOnClickListener(this)
        forgot_password.setOnClickListener(this)
        guest_access.setOnClickListener(this)
        sign_in.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v) {
            guest_access -> {
                val guestIntent = Intent(this, GuestAccessActivity::class.java)
                startActivity(guestIntent)
            }
            register ->
            {
                val registerIntent = Intent(this, RegisterActivity::class.java)
                startActivity(registerIntent)
            }
            forgot_password ->
            {
                val resetIntent = Intent(this, ResetPasswordActivity::class.java)
                startActivity(resetIntent)
            }
            sign_in ->
            {
                val actiondashboardIntent = Intent(this, ActionDashboardActivity::class.java)
                startActivity(actiondashboardIntent)
            }
        }
    }
}
