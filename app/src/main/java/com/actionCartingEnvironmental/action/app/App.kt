package com.actionCartingEnvironmental.action.app

import android.app.Application
import com.actionCartingEnvironmental.action.R
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.identity.Registration



class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val apiKey:String = resources.getString(R.string.intercom_api_key)
        val appId:String = resources.getString(R.string.intercom_app_id)
        Intercom.initialize(this, apiKey, appId);
//        if (loggedIn) {
//            /* We're logged in, we can register the user with Intercom */
//            val registration = Registration.create().withUserId("123456")
//            Intercom.client().registerIdentifiedUser(registration)
//        } else {
//            /* Since we aren't logged in, we are an unidentified user.
//     * Let's register. */
            Intercom.client().registerUnidentifiedUser()
//        }
    }

}