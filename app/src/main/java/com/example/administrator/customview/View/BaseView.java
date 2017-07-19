package com.example.administrator.customview.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.wxq.view.CustomView;

/**
 * @author 王晓清
 * @version V_1.0.0
 * @date 2017/7/17
 * @description
 */

public class BaseView extends CustomView {
    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint1;

    @Override
    public void initView() {
        //初始化控件
        mPaint1 = new Paint();
        // 设置画笔颜色为蓝色
        mPaint1.setColor(Color.BLUE);
        // 设置画笔宽度为10px
        mPaint1.setStrokeWidth(5f);
        //设置画笔模式为填充
        mPaint1.setStyle(Paint.Style.FILL);

    }

    //100dp  300 xiangshu
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
//        canvas.drawPoint(100,100,mPaint1);
//        canvas.drawPoints(new float[]{
//                100,150,100,200,200,200,150,150
//        },mPaint1);
//
//       canvas.drawLine(0,0,200,300,mPaint1);
//        canvas.drawPoints(new float[]{
//                300,300,100,100,200,200,150,150
//        },mPaint1);
//
//        // 第三种
//        RectF rectF = new RectF(800,100,1000,200);
//        canvas.drawRect(rectF,mPaint1);
//
//        // 第一种
//        RectF RoundrectF = new RectF(500,600,800,800);
//        canvas.drawRoundRect(RoundrectF,30,30,mPaint1);
//
//        RectF rectF1=new RectF(100,100,800,400);//确定位子
//        mPaint1.setColor(Color.GRAY);
//        canvas.drawRect(rectF1,mPaint1);
//        mPaint1.setColor(Color.GREEN);
//        canvas.drawRoundRect(rectF1,700,650,mPaint1);
//        canvas.drawCircle(500,500,100,mPaint1);
        // 第一种
//        mPaint1.setStyle(Paint.Style.STROKE);
//        RectF rectF4 = new RectF(720,100,800,400);
//        canvas.drawOval(rectF4,mPaint1);
//
//
//        RectF rectF5 = new RectF(300,300,800,800);
//
//
//        canvas.drawArc(rectF5,0,-40,false,mPaint1);


        //内切圆  线条宽度在中间
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(50);
        canvas.drawCircle(200, 200, 200, paint);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);     //为了实验效果明显，特地设置描边宽度非常大
        // 描边
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(200, 200, 200, paint);


//        // 画字
//        Paint textPaint = new Paint();          // 创建画笔
//        textPaint.setColor(Color.BLACK);        // 设置颜色
//        textPaint.setStyle(Paint.Style.FILL);   // 设置样式
//        textPaint.setTextSize(50);              // 设置字体大小
//
//
//        // 文本(要绘制的内容)
//        String str = "ABCDEFGHIJK";
//
//        // 参数分别为 (文本 基线x 基线y 画笔)
//        canvas.drawText(str,200,500,textPaint);

       canvas.translate(mViewWidth/2,mViewHeight/2);
//        canvas.scale(1,-1);
        Path path=new Path();
        Path src=new Path();

        path.addRect(-200,-200,200,200,Path.Direction.CW);

        src.addCircle(0,0,100,Path.Direction.CW);

        path.addPath(src,0,100);

        mPaint1.setColor(Color.GREEN);
        mPaint1.setStyle(Paint.Style.STROKE);
          canvas.drawPath(path,mPaint1);


        Path path1=new Path();

        path1.lineTo(100,100);

        RectF rectF=new RectF(0,0,300,300);

//        path1.addArc(rectF,0,255);
        path1.arcTo(rectF,0,255);

        canvas.drawPath(path1,mPaint1);






    }
}
