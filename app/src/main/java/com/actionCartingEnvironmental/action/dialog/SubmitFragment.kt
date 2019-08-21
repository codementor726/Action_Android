package com.actionCartingEnvironmental.action.dialog

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.View
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.dashboard.ActionDashboardActivity
import com.actionCartingEnvironmental.action.activity.support.SupportActivity
import kotlinx.android.synthetic.main.dialog_submit.view.*
import kotlinx.android.synthetic.main.dialog_submit.*

class SubmitFragment : DialogFragment() {

    companion object {

        fun show(activity: Activity) {
            SubmitFragment().apply {
                arguments = Bundle().apply {
                }
            }.show(activity.fragmentManager, null)
        }
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var view: View? = null
        view = activity.layoutInflater.inflate(R.layout.dialog_submit, null)
        view.view_request.setOnClickListener {
            val dashboardIntent = Intent(activity, ActionDashboardActivity::class.java)
            startActivity(dashboardIntent)
            activity.finish()
        }
        view.return_dashboard.setOnClickListener{
            val supportIntent = Intent(activity, SupportActivity::class.java)
            startActivity(supportIntent)
            activity.finish()
        }
        val builder:AlertDialog.Builder =  AlertDialog.Builder(activity)
            .setView(view)
        return builder
            .create()
            .apply {
                setCanceledOnTouchOutside(false)
            }
    }
}