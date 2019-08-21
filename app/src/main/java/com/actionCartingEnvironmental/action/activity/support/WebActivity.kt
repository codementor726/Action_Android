package com.actionCartingEnvironmental.action.activity.support

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.model.AppIntent.Extras.EXTRA_TYPE
import com.actionCartingEnvironmental.action.model.AppIntent.WebType.TYPE_COLLETION_GUIDELINES
import com.actionCartingEnvironmental.action.model.AppIntent.WebType.TYPE_FACEBOOK
import com.actionCartingEnvironmental.action.model.AppIntent.WebType.TYPE_LINKEDIN
import com.actionCartingEnvironmental.action.model.AppIntent.WebType.TYPE_TWITTER
import com.actionCartingEnvironmental.action.model.AppIntent.WebType.TYPE_WORK_WITH_US
import com.actionCartingEnvironmental.action.model.AppIntent.WebType.TYPE_YOUTUBE
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        back.setOnClickListener{
            onBackPressed()
        }
        main_view!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        val webSettings = main_view.getSettings()
        webSettings.javaScriptEnabled = true
        when(intent.getIntExtra(EXTRA_TYPE,TYPE_FACEBOOK))
        {
            TYPE_FACEBOOK ->{
                title_view.text = resources.getString(R.string.facebook)
                main_view!!.loadUrl("https://www.facebook.com/ActionEnvironmental")
            }
            TYPE_TWITTER ->{
                title_view.text = resources.getString(R.string.twitter)
                main_view!!.loadUrl("https://twitter.com/ActionCarting")
            }
            TYPE_YOUTUBE ->{
                title_view.text = resources.getString(R.string.youtube)
                main_view!!.loadUrl("https://www.youtube.com/channel/UCMcwS2fViFs-dqCbOYnGBzQ")
            }
            TYPE_LINKEDIN ->{
                title_view.text = resources.getString(R.string.linkedin)
                main_view!!.loadUrl("https://www.linkedin.com/company/action-environmental-services/")
            }
            TYPE_WORK_WITH_US ->
            {
                title_view.text = resources.getString(R.string.work_with_us)
                main_view!!.loadUrl("https://usr56.dayforcehcm.com/CandidatePortal/en-US/actionenv")
            }
            TYPE_COLLETION_GUIDELINES ->
            {
                title_view.text = resources.getString(R.string.collection_recycling)
                //main_view!!.loadUrl("https://usr56.dayforcehcm.com/CandidatePortal/en-US/actionenv")
            }
        }
    }
}
