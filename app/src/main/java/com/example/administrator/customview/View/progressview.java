package com.example.administrator.customview.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/6/5.
 */

public class progressview extends View {

    // 上下字体为宽250个dp默认
    //     固定 上下40px  20dp 中间进度条24像素 12dp
    private int currentWidth=600;// xianghsu
    private int currentheight=60;// xianghsu
    int blueStart=  Color.parseColor("#56ddf5");
    int blueEnd=  Color.parseColor("#1d99f1");
    int orangeStart=Color.parseColor("#f1d61e");
    int orangeEnd=Color.parseColor("#ef5b3b");
    int mode=1;  // 1 代表只有一条竖线的情况  2 代表有两条竖线的情况

    float singleLineNumber=0;
    float firstNumber=0;
    float secondNumber=0;

    /**分段颜色*/
    private static final int[] SECTION_COLORS = {Color.GREEN,Color.YELLOW,Color.RED};

//    private static final int[] SECTION_COLORS = {Color.GREEN,Color.YELLOW,Color.RED};
    /**进度条最大值*/
    private float maxCount=100;
    /**进度条当前值*/
    private float currentCount=90;

    // 宽高
    private int mWidth=dipToPx(250);

    private int  mHeight=dipToPx(52);
    // 画笔
    private Paint mPaint = new Paint();

    public progressview(Context context) {
     this(context,null);
    }

    public progressview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight=h;
        mWidth=w;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.translate(0,50);
//        canvas.translate(mWidth / 2, mHeight / 2);  // 将话不移动中心
//
//
//
//        Paint paint=new Paint();
//        paint.setColor(Color.RED);  //设置画笔颜色
//        paint.setStyle(Style.FILL);//设置填充样式
//        paint.setStrokeWidth(15);//设置画笔宽度
//
//        RectF rect = new RectF(100, 10, 300, 100);
//        canvas.drawRoundRect(rect, 20, 10, paint);


        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        int round=currentheight/2;
        mPaint.setColor(Color.WHITE);

        RectF rectbg=new RectF(0,50,mWidth,mHeight-50);

        // 背景进度条
        canvas.drawRoundRect(rectbg,round,round,mPaint);

   //     mPaint.setColor(Color.TRANSPARENT);

        RectF rectBlackbg=new RectF(2,2+50,mWidth-2,mHeight-2-50);

        canvas.drawRoundRect(rectBlackbg,round,round,mPaint);



        // float其中的一个比例 话
       // float section=currentCount/maxCount;
        float section1=0.6f;
        float section2=0.8f;
           //先搞一个框

        RectF rectProgressbg=new RectF(3,3+50,(mWidth-3)*section1,mHeight-3-50);

//        if(section1<=0.5f){
//
//
//            if(section1 != 0.0f){
//                mPaint.setColor(SECTION_COLORS[0]);
//            }else{
//                mPaint.setColor(Color.TRANSPARENT);
//            }
//
//
//        }else{
//
//            int count = (section1 <= section2 ) ? 2 : 3;
//
//            int[] colors=new int[count];
//
//            System.arraycopy(SECTION_COLORS,0,colors,0,count);
//
//            float [] positions=new float[count];
//
//            if(count==2){
//                positions[0]=0.0f;
//                positions[1]=1-positions[0];
//
//
//            }else{
//                positions[0]=0.0f;
//                positions[1] = (maxCount/3)/currentCount;
//                positions[2] = 1.0f-positions[0]*2;
//
//            }
//            positions[positions.length-1] = 1.0f;
//            LinearGradient shader = new LinearGradient(3, 3, (mWidth-3)*section1, mHeight-3, colors,null, Shader.TileMode.MIRROR);
//            mPaint.setShader(shader);
//
////
////            TileMode：（一共有三种）
////            CLAMP  ：如果渲染器超出原始边界范围，会复制范围内边缘染色。
////            REPEAT ：横向和纵向的重复渲染器图片，平铺。
////            MIRROR ：横向和纵向的重复渲染器图片，这个和REPEAT重复方式不一样，他是以镜像方式平铺。
//
//
//
//        }



        LinearGradient shader = new LinearGradient(3, 3+50, (mWidth-3)*section1, mHeight-3-50, SECTION_COLORS,null, Shader.TileMode.MIRROR);
        mPaint.setShader(shader);


        canvas.drawRoundRect(rectProgressbg, round, round, mPaint);



        Paint paint=new Paint();
        paint.setColor(Color.WHITE);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式
        paint.setStrokeWidth(5);//设置画笔宽度

//
//        float section1=0.6f;
//        float section2=0.8f;

        canvas.drawLine((mWidth-3)*0.45f, 50, (mWidth-3)*0.45f, mHeight-3-50, paint);

        paint.setColor(Color.RED);

        canvas.drawLine((mWidth-3)*section2, 50, (mWidth-3)*section2, mHeight-3-50, paint);

        //写文字
        paint.setColor(Color.GREEN);
        paint.setTextSize(28); //以px为单位14 sp 转 像素
        canvas.drawText("25", (mWidth-3)*0.45f-14, 30, paint); // 字体坐标

        paint.setColor(Color.RED);
        paint.setTextSize(28); //以px为单位14 sp 转 像素
        canvas.drawText("1805", (mWidth-3)*section2-28,  mHeight-3-50+30, paint); // 字体坐标
    }




    private int dipToPx(int dip) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
    }

    /***
     * 设置最大的进度值
     * @param maxCount
     */
    public void setMaxCount(float maxCount) {
        this.maxCount = maxCount;
    }

    /***
     * 设置当前的进度值
     * @param currentCount
     */
    public void setCurrentCount(float currentCount) {
        this.currentCount = currentCount > maxCount ? maxCount : currentCount;
        invalidate();
    }


   //设置一条线的情况
    public void setOneLine(float singleLine) {
        singleLineNumber=singleLine;
        mode=1;
        invalidate();
    }


    //设置一条线的情况
    public void setTwoLine(float one,float two) {
         firstNumber= one;
         secondNumber=two;
         mode=2;
         invalidate();
    }






    public float getMaxCount() {
        return maxCount;
    }

    public float getCurrentCount() {
        return currentCount;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.EXACTLY || widthSpecMode == MeasureSpec.AT_MOST) {
            mWidth = widthSpecSize;
        } else {
            mWidth = 0;
        }
        if (heightSpecMode == MeasureSpec.AT_MOST || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            mHeight = dipToPx(15);
        } else {
            mHeight = heightSpecSize;
        }
        setMeasuredDimension(mWidth, mHeight);
    }



    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public  int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public  int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}
