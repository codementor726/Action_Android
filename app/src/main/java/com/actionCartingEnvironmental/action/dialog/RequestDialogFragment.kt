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
import kotlinx.android.synthetic.main.dialog_request_service.view.*



class RequestDialogFragment : DialogFragment() {

    companion object {

        fun show(activity: Activity) {
            RequestDialogFragment().apply {
                arguments = Bundle().apply {
                }
            }.show(activity.fragmentManager, null)
        }
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater?.inflate(R.layout.dialog_request_service, container, false)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        v?.close?.setOnClickListener {
            dismiss()
        }
        v?.addtional_pickup?.setOnClickListener{
            dismiss()
            val addtionalIntent = Intent(activity, AdditionalPickupActivity::class.java)
            startActivity(addtionalIntent)
        }
        v?.bulk_pickup?.setOnClickListener{
            dismiss()
            val bulkIntent = Intent(activity, BulkPickUpActivity::class.java)
            startActivity(bulkIntent)
        }
        v?.missed_pickup?.setOnClickListener{
            dismiss()
            val missIntent = Intent(activity, MissedPickUpActivity::class.java)
            startActivity(missIntent)
        }
        v?.service_change?.setOnClickListener {
            dismiss()
            val serviceIntent = Intent(activity, ServiceChangeActivity::class.java)
            startActivity(serviceIntent)
        }
        v?.order_new?.setOnClickListener {
            dismiss()
            val orderIntent = Intent(activity, OrderNewActivity::class.java)
            startActivity(orderIntent)
        }
        v?.existing_container?.setOnClickListener {
            dismiss()
            val existingIntent = Intent(activity, ExistingOrderActivity::class.java)
            startActivity(existingIntent)
        }
        return v
    }
}