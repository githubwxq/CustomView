package com.example.administrator.customview.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/2/26 0026.
 */

public class CustomLayout extends ViewGroup {
    public CustomLayout(Context context) {
        this(context, null, 0);
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {

    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int count = getChildCount();
        int childMeasureWidth = 0;
        int childMeasureHeight = 0;
        int layoutWidth = 0;    // 容器已经占据的宽度
        int layoutHeight = 0;   // 容器已经占据的高度  默认
        int maxChildHeight = 0; //一行中子控件最高的高度，用于决定下一行高度应该在目前基础上累加多少
        for (int i = 0; i < count; i++) {
            View childAt = getChildAt(i);
            childMeasureWidth = childAt.getMeasuredWidth();
            childMeasureHeight = childAt.getMeasuredHeight();
            //
//            layoutWidth+=childMeasureWidth;//宽度累加


            if (layoutWidth + childMeasureWidth < getWidth()) {
                left = layoutWidth;
                right = left + childMeasureWidth;
                top = layoutHeight;
                bottom = top + childMeasureHeight;
            } else {
                //排满后换行
                layoutWidth = 0;
                layoutHeight += maxChildHeight;
                maxChildHeight = 0;
                left = layoutWidth;
                right = left + childMeasureWidth;
                top = layoutHeight;
                bottom = top + childMeasureHeight;
            }

            layoutWidth += childMeasureWidth;  //宽度累加
            if (childMeasureHeight > maxChildHeight) {
                maxChildHeight = childMeasureHeight;
            }


            //确定子控件的位置，四个参数分别代表（左上右下）点的坐标值
            childAt.layout(left, top, right, bottom);


        }


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //*********************************************************************//
//        //稍后会重新写这个方法，能达到wrap_content的效果
//        measureChildren(widthMeasureSpec, heightMeasureSpec);
//        //测量并保存layout的宽高(使用getDefaultSize时，wrap_content和match_perent都是填充屏幕) //wrap 得而外处理
//        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
//
//
        //*********************************************************************//
        //加入布局后大小重新计算
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        int layoutWidth = 0;

        int layoutHeight = 0;

        // 计算出所有的childView的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int cWidth = 0;
        int cHeight = 0;


        int count = getChildCount();


        if (widthMode == MeasureSpec.EXACTLY) {
            //如果布局容器的宽度模式是确定的（具体的size或者match_parent），直接使用父窗体建议的宽度
            layoutWidth = sizeWidth;
        } else {
            for (int i = 0; i < count; i++) {
                View child = getChildAt(i);
                cWidth = child.getWidth();
                layoutWidth = cWidth > layoutWidth ? cWidth : layoutWidth;
            }
        }


//高度很宽度处理思想一样
        if (heightMode == MeasureSpec.EXACTLY) {
            layoutHeight = sizeHeight;
        } else {
            for (int i = 0; i < count; i++) {
                View child = getChildAt(i);
                cHeight = child.getMeasuredHeight();
                layoutHeight = cHeight > layoutHeight ? cHeight : layoutHeight;
            }
        }
        // 测量并保存layout的宽高
        setMeasuredDimension(layoutWidth, layoutHeight);

    }


    //    在ViewGroup中有下面几个关于LayoutParams的方法，generateLayoutParams (AttributeSet attrs)是在布局文件被填充为对象的时候调用的，
//    这个方法是下面几个方法中最重要的，如果不重写它，我么布局文件中设置的布局参数都不能拿到。后面我也会专门写一篇博客来介绍布局文件被添加到activity窗口的过程，
//    里面会讲到这个方法被调用的来龙去脉。其他几个方法我们最好也能重写一下，将里面的LayoutParams换成我们自定义的CustomLayoutParams类
//    ，避免以后会遇到布局参数类型转换异常
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new CustomLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new CustomLayoutParams(p);
    }


    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new CustomLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected boolean checkLayoutParams(LayoutParams p) {
        return p instanceof CustomLayoutParams;
    }
}
