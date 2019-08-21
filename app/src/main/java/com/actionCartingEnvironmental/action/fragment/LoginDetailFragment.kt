/*
 * Copyright (c) 2017 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.actionCartingEnvironmental.action.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.auth.RegisterActivity
import com.actionCartingEnvironmental.action.activity.auth.RegistrationErrorActivity
import com.actionCartingEnvironmental.action.activity.dashboard.ActionDashboardActivity
import kotlinx.android.synthetic.main.fragment_login_detail.*
import kotlinx.android.synthetic.main.fragment_login_detail.back
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.include_login_details.*
import kotlinx.android.synthetic.main.include_register.*


class LoginDetailFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
    Bundle?): View? {
      val view = inflater.inflate(R.layout.fragment_login_detail, container, false)
      val args = arguments
      return view
    }

    companion object {
      fun newInstance(title: String): LoginDetailFragment {
        val args = Bundle()
        args.putString("title", title)
        val fragment = LoginDetailFragment()
        fragment.arguments = args
        return fragment
      }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        back.setOnClickListener(this)
        continue_detail.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v)
        {
            back ->
            {
                (activity as RegisterActivity).setActiveFragment(0)
            }
            continue_detail ->
            {
                val intent = Intent(context, ActionDashboardActivity::class.java)
                startActivity(intent)
            }
        }
    }

}
