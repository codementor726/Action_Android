package com.actionCartingEnvironmental.action.dialog

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.View
import com.actionCartingEnvironmental.action.R
import kotlinx.android.synthetic.main.dialog_winter_schedule.view.*

class WinterDialogFragment : DialogFragment() {

    companion object {

        fun show(activity: Activity) {
            WinterDialogFragment().apply {
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
        view = activity.layoutInflater.inflate(R.layout.dialog_winter_schedule, null)
        val spannableString = SpannableString("Please be advised that due to dangerous winter " +
                "storm conditions and in accordance with government directives, " +
                "there will be NO SERVICE TONIGHT (Saturday night 9/20/18 into Sunday morning " +
                "9/21/18).\n\nService is thscheduled to resuem Sunday night(9/22/18).")
        spannableString.setSpan(null,124,142,0)
        spannableString.setSpan(UnderlineSpan(), 124, 142, 0)
        spannableString.setSpan(StyleSpan(Typeface.ITALIC), 144, 194, 0)
        spannableString.setSpan(ForegroundColorSpan(resources.getColor(android.R.color.darker_gray)), 14, 32, 0)
        view.text.text = spannableString
        view.done.setOnClickListener {
            dismiss()
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