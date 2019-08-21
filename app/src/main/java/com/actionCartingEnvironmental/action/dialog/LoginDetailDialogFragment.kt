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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.service.*
import kotlinx.android.synthetic.main.dialog_request_service.*
import kotlinx.android.synthetic.main.dialog_login_detail.view.*

class LoginDetailDialogFragment : DialogFragment() {

    companion object {

        fun show(activity: Activity) {
            LoginDetailDialogFragment().apply {
                arguments = Bundle().apply {
                }
            }.show(activity.fragmentManager, null)
        }
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater?.inflate(R.layout.dialog_login_detail, container, false)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        v?.close?.setOnClickListener {
            dismiss()
        }

        return v
    }
}