package com.wxq.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by wxq on 2018/2/27 0027.
 */

public abstract class CustomLayout extends ViewGroup {


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    public CustomLayout(Context context) {
        this(context,null);
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr,0);
        if (attrs!=null) {
            initAttribute(attrs);
        }
    }

    /**
     * 初始化属性
     * @param attrs
     */
    public abstract  void   initAttribute(AttributeSet attrs);

}
