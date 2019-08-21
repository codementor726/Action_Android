package com.actionCartingEnvironmental.action.activity.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.adapter.SignUpAdapter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var pagerAdapter: SignUpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val arrayList = ArrayList<String>()
        arrayList.add(resources.getString(R.string.register_account))
        arrayList.add(resources.getString(R.string.login_details))
        pagerAdapter = SignUpAdapter(supportFragmentManager, arrayList)
        viewPager.adapter = pagerAdapter
        viewPager.setSwipePagingEnabled(false)
        setActiveFragment(0);
    }

    public fun setActiveFragment(activeNum: Int) {
        when (activeNum)
        {
            0 ->{
                viewPager.setCurrentItem(0,true);
            }
            1 ->{
                viewPager.setCurrentItem(1,true);
            }
        }
    }
}
