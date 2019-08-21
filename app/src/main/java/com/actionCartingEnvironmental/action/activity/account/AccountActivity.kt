package com.actionCartingEnvironmental.action.activity.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.auth.WelcomeActivity
import com.actionCartingEnvironmental.action.activity.dashboard.ActionDashboardActivity
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.include_address_form.*

class AccountActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        notification.setOnClickListener(this)
        email.setOnClickListener(this)
        personal_information.setOnClickListener(this)
        change_password.setOnClickListener(this)
        change_site.setOnClickListener(this)
        logout.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        when(p0)
        {
            notification ->
            {
                val intent = Intent(applicationContext, NotificationActivity::class.java)
                startActivity(intent)
            }
            email ->
            {
                val intent = Intent(applicationContext, EmailActivity::class.java)
                startActivity(intent)
            }
            personal_information ->
            {
                val intent = Intent(applicationContext, PersonalInfoActivity::class.java)
                startActivity(intent)
            }
            change_password ->
            {
                val intent = Intent(applicationContext, ChangePasswordActivity::class.java)
                startActivity(intent)
            }
            change_site ->
            {
                val intent = Intent(applicationContext, ManageSiteActivity::class.java)
                startActivity(intent)
            }
            logout ->
            {
                val intent = Intent(applicationContext, WelcomeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        }
    }
}
