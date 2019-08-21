package com.actionCartingEnvironmental.action.view

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.actionCartingEnvironmental.action.R
import kotlinx.android.synthetic.main.view_account_item.view.*

class AccountItem : RelativeLayout {
    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr)
    {
        val attrValues = context.obtainStyledAttributes(attrs, R.styleable.account_item)
        if (attrValues.hasValue(R.styleable.account_item_text))
            text.text=attrValues.getString(R.styleable.account_item_text)
        if (attrValues.hasValue(R.styleable.account_item_image))
            image.setImageDrawable(attrValues.getDrawable(R.styleable.account_item_image))
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)
    init {
        LayoutInflater.from(context).inflate(R.layout.view_account_item, this, true)
    }
}