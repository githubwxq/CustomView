package com.example.administrator.customview.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.customview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/27 0027.
 */

public class FlowLayout extends ViewGroup {
    private static final String TAG = "FlowLayout";
    private static final int LEFT = -1;
    private static final int CENTER = 0;
    private static final int RIGHT = 1;



    protected List<List<View>> mAllViews=new ArrayList<>();


    protected  List<Integer> mLineHeight=new ArrayList<>();


    protected  List<Integer> mLineWidth=new ArrayList<>();


    private int mGravity;

    private List<View> lineViews = new ArrayList<>();


    private float vertical_space;
    private float horizontal_space;

    public FlowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TagFlowLayout);
        mGravity = ta.getInt(R.styleable.TagFlowLayout_tag_gravity, LEFT);
        ta.recycle();
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec); //如果是确切的宽度的话
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        // wrap_content
        int width = 0;
        int height = 0;

        int lineWidth = 0;
        int lineHeight = 0;

        int cCount = getChildCount();

        for (int i = 0; i < cCount; i++) {
            View child=getChildAt(i);

            if(child.getVisibility()==View.GONE){
                if(i==cCount-1){
                    width= Math.max(lineWidth,width);
                    height+=lineHeight;
                }
                continue;
            }


            measureChild(child,widthMeasureSpec,heightMeasureSpec);

            //默认的布局参数类
            MarginLayoutParams lp = (MarginLayoutParams) child
                    .getLayoutParams();


            int childWidth=child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;

            int childHeight=child.getHeight()+lp.topMargin+lp.bottomMargin;

            //换行
            if(lineWidth+childWidth>sizeWidth-getPaddingLeft()-getPaddingRight()){
                width = Math.max(width, lineWidth);
                lineWidth = childWidth;
                height += lineHeight;
                lineHeight = childHeight;
            }else {
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }


            if (i == cCount - 1) {
                width = Math.max(lineWidth, width);
                height += lineHeight;
            }

        }

        setMeasuredDimension(
                //
                modeWidth == MeasureSpec.EXACTLY ? sizeWidth : width + getPaddingLeft() + getPaddingRight(),
                modeHeight == MeasureSpec.EXACTLY ? sizeHeight : height + getPaddingTop() + getPaddingBottom()//
        );
    }






    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

        mAllViews.clear();
        mLineHeight.clear();
        mLineWidth.clear();
        lineViews.clear();

        int width = getWidth();

        int lineWidth = 0;
        int lineHeight = 0;

        int cCount = getChildCount();

        for (int i = 0; i < cCount; i++) {
            View child=getChildAt(i);
            if (child.getVisibility() == View.GONE) {
                continue;
            }

            MarginLayoutParams lp = (MarginLayoutParams) child
                    .getLayoutParams();

            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();






        }





    }
}
