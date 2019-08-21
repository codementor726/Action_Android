package com.actionCartingEnvironmental.action.activity.support

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.auth.RegistrationErrorActivity
import com.actionCartingEnvironmental.action.model.AppIntent.WebType.TYPE_COLLETION_GUIDELINES
import com.actionCartingEnvironmental.action.model.AppIntent.WebType.TYPE_FACEBOOK
import com.actionCartingEnvironmental.action.model.AppIntent.WebType.TYPE_LINKEDIN
import com.actionCartingEnvironmental.action.model.AppIntent.WebType.TYPE_TWITTER
import com.actionCartingEnvironmental.action.model.AppIntent.WebType.TYPE_WORK_WITH_US
import com.actionCartingEnvironmental.action.model.AppIntent.WebType.TYPE_YOUTUBE
import io.intercom.android.sdk.Intercom
import kotlinx.android.synthetic.main.activity_support.*
import kotlinx.android.synthetic.main.include_support_header.*

class SupportActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)

        facebook.setOnClickListener(this)
        twitter.setOnClickListener(this)
        youtube.setOnClickListener(this)
        linkedin.setOnClickListener(this)
        work_us.setOnClickListener(this)
        collections.setOnClickListener(this)
        help_center.setOnClickListener(this)
        message_us.setOnClickListener(this)
        back.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        when (p0)
        {
            facebook ->
            {
                val fIntent = Intent(this, WebActivity::class.java)
                fIntent.putExtra(resources.getString(R.string.type), TYPE_FACEBOOK)
                startActivity(fIntent)
            }
            twitter ->
            {
                val tIntent = Intent(this, WebActivity::class.java)
                tIntent.putExtra(resources.getString(R.string.type), TYPE_TWITTER)
                startActivity(tIntent)
            }
            youtube ->
            {
                val yIntent = Intent(this, WebActivity::class.java)
                yIntent.putExtra(resources.getString(R.string.type), TYPE_YOUTUBE)
                startActivity(yIntent)
            }
            linkedin ->
            {
                val lIntent = Intent(this, WebActivity::class.java)
                lIntent.putExtra(resources.getString(R.string.type), TYPE_LINKEDIN)
                startActivity(lIntent)
            }
            work_us ->
            {
                val wIntent = Intent(this, WebActivity::class.java)
                wIntent.putExtra(resources.getString(R.string.type), TYPE_WORK_WITH_US)
                startActivity(wIntent)
            }
            collections ->
            {
                val cIntent = Intent(this, WebActivity::class.java)
                cIntent.putExtra(resources.getString(R.string.type), TYPE_COLLETION_GUIDELINES)
                startActivity(cIntent)
            }
            help_center ->
            {
                Intercom.client().displayHelpCenter()
            }
            message_us ->
            {
                Intercom.client().displayMessenger()
            }
            back ->
            {
                onBackPressed()
            }
        }
    }
}
