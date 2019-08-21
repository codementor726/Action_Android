package com.actionCartingEnvironmental.action.view

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.actionCartingEnvironmental.action.R
import kotlinx.android.synthetic.main.view_top.view.*

class TopView : RelativeLayout {
    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr)
    {
        val attrValues = context.obtainStyledAttributes(attrs, R.styleable.custom_title)
        if (attrValues.hasValue(R.styleable.custom_title_titleText))
            title.text=attrValues.getString(R.styleable.custom_title_titleText)
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)
    init {
        LayoutInflater.from(context).inflate(R.layout.view_top, this, true)
        close.setOnClickListener {
            val activity = context as Activity
            activity.onBackPressed()
        }
    }
}