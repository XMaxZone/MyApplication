package com.yianke.pet.Common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/1/5.
 */

public class Listview extends ListView {

    public Listview(Context context) {
        this(context,null);
    }

    public Listview(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Listview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //重写测量方法

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

































