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
import kotlinx.android.synthetic.main.dialog_labor_schedule.view.*

class LaborDialogFragment : DialogFragment() {

    companion object {

        fun show(activity: Activity) {
            LaborDialogFragment().apply {
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
        view = activity.layoutInflater.inflate(R.layout.dialog_labor_schedule, null)
        val spannableString = SpannableString("Please be advised that in observance of Labor Day there will " +
                "be NO SERVICE on Sunday(9/3/17) night into Monday(9/14/17) morning. \n\nService will resume Monday night (9/4/17)")
        spannableString.setSpan(null,64,74,0)
        spannableString.setSpan(UnderlineSpan(), 64, 74, 0)
        spannableString.setSpan(StyleSpan(Typeface.ITALIC), 84, 92, 0)
        spannableString.setSpan(StyleSpan(Typeface.ITALIC), 111, 120, 0)
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