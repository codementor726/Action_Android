package com.actionCartingEnvironmental.action.view

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.actionCartingEnvironmental.action.R
import kotlinx.android.synthetic.main.view_alarm.view.*

class AlarmView : RelativeLayout {
    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr)
    {
        val attrValues = context.obtainStyledAttributes(attrs, R.styleable.alarm_view)
        if (attrValues.hasValue(R.styleable.alarm_view_mainText))
            title.text=attrValues.getString(R.styleable.alarm_view_mainText)
        if (attrValues.hasValue(R.styleable.alarm_view_description))
            description.text=attrValues.getString(R.styleable.alarm_view_description)
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)
    init {
        LayoutInflater.from(context).inflate(R.layout.view_alarm, this, true)
    }
}