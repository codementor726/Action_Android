package com.actionCartingEnvironmental.action.activity.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.dashboard.ActionDashboardActivity
import java.lang.ref.WeakReference

class SplashActivity : AppCompatActivity() {

    private lateinit var safeHandler:SafeHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //Delay 1s for show splash screen
        safeHandler = SafeHandler(this)
        safeHandler.postDelayed({
            val welcomeIntent = Intent(this, WelcomeActivity::class.java)
            startActivity(welcomeIntent)
            finish()
        }, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()
        safeHandler.removeCallbacksAndMessages(null)
    }

    class SafeHandler(activity: SplashActivity) : Handler() {
        private val activity: WeakReference<SplashActivity> = WeakReference(activity)
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            activity.get()?.let { context ->
                val welcomeIntent = Intent(context, WelcomeActivity::class.java)
                context.startActivity(welcomeIntent)
                context.finish()
            }
        }
    }
}