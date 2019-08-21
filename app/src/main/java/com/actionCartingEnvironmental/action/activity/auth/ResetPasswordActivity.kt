package com.actionCartingEnvironmental.action.activity.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.actionCartingEnvironmental.action.R
import kotlinx.android.synthetic.main.activity_guest_access.*

class ResetPasswordActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        //OnClick Event
        back.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v) {
            back -> {
                onBackPressed()
            }
        }
    }
}
