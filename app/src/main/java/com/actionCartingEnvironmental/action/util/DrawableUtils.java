package com.actionCartingEnvironmental.action.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.content.ContextCompat;
import com.actionCartingEnvironmental.action.R;
import com.applandeo.materialcalendarview.CalendarUtils;

/**
 * Created by Mateusz Kornakiewicz on 02.08.2018.
 */

public final class DrawableUtils {

    private DrawableUtils() {
    }

    public static Drawable getThreeDots(Context context){
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ximg_three_dot);

        //Add padding to too large icon
        int inset = context.getResources().getDimensionPixelOffset(R.dimen.big_img_item_size);
        return new InsetDrawable(drawable, inset, 0, inset, 0);
    }
}
