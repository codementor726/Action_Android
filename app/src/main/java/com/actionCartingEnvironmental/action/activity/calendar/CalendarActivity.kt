package com.actionCartingEnvironmental.action.activity.calendar

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.actionCartingEnvironmental.action.R
import com.actionCartingEnvironmental.action.activity.BaseActivity
import com.actionCartingEnvironmental.action.adapter.EventAdapter
import com.actionCartingEnvironmental.action.model.EventModel
import com.actionCartingEnvironmental.action.util.DrawableUtils
import com.applandeo.materialcalendarview.CalendarView
import com.applandeo.materialcalendarview.EventDay
import kotlinx.android.synthetic.main.activity_calendar.*
import java.time.YearMonth
import java.util.*

class CalendarActivity : BaseActivity() {
    var flag : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        buildCalendar();
        buildRecyclerView();
        open_calendar.setOnClickListener{
            if (flag == 0)
                translateViews(1, 500)
            else
                translateViews(0, 500)
        }
        back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun buildRecyclerView() {
        val eventLists = ArrayList<EventModel>()
        val year : Int = Calendar.getInstance().get(Calendar.YEAR);
        val month: Int = Calendar.getInstance().get(Calendar.MONTH);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val yearMonthObject = YearMonth.of(year, month)
            val daysInMonth = yearMonthObject.lengthOfMonth()
            for (i in 0 until daysInMonth) {
                eventLists.add(EventModel())
            }
            event_list.layoutManager = LinearLayoutManager(this)
            val adapter = EventAdapter(this, eventLists)
            event_list.adapter = adapter
        }
    }

    private fun translateViews(i: Int, duration: Long) {
        if ( i == 0) {
                calendar_view.animate()
                    .translationY(dpTopx(this@CalendarActivity, 0f))
                    .alpha(1.0f)
                    .setDuration(duration)
                event_list.animate()
                    .translationY(dpTopx(this@CalendarActivity, 0f))
                    .alpha(1.0f)
                    .setDuration(duration)
                flag = 0
        }
        else if ( i == 1)
        {
            calendar_view.animate()
                .translationY(dpTopx(this@CalendarActivity, 400f))
                .alpha(1.0f)
                .setDuration(duration)
            event_list.animate()
                .translationY(dpTopx(this@CalendarActivity, 400f))
                .alpha(1.0f)
                .setDuration(duration)
            flag = 1
        }
    }

    private fun buildCalendar() {
        calendar_view.setOnDayClickListener{
                eventDay-> Toast.makeText(applicationContext, eventDay.getCalendar().getTime().date.toString() + " " + eventDay.isEnabled(),Toast.LENGTH_SHORT)
                val number:Int = eventDay.getCalendar().getTime().date
                event_list.scrollToPosition(number)
        }
        val events = ArrayList<EventDay>()
        val calendar1 = Calendar.getInstance()
        calendar1.add(Calendar.DAY_OF_MONTH, 2)
        events.add(EventDay(calendar1, DrawableUtils.getThreeDots(this)))
        val calendar2 = Calendar.getInstance()
        calendar2.add(Calendar.DAY_OF_MONTH, 5)
        events.add(EventDay(calendar2, DrawableUtils.getThreeDots(this)))
        val calendar3 = Calendar.getInstance()
        calendar3.add(Calendar.DAY_OF_MONTH, 7)
        events.add(EventDay(calendar3, DrawableUtils.getThreeDots(this)))
        val calendar4 = Calendar.getInstance()
        calendar4.add(Calendar.DAY_OF_MONTH, 13)
        events.add(EventDay(calendar4, DrawableUtils.getThreeDots(this)))
        val min = Calendar.getInstance()
        min.add(Calendar.MONTH, -2)
        val max = Calendar.getInstance()
        max.add(Calendar.MONTH, 2)
        calendar_view.setMinimumDate(min)
        calendar_view.setMaximumDate(max)
        calendar_view.setEvents(events)
    }
}
