package com.example.administrator.customview.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

import com.wxq.view.CustomView;

/**
 * @author 王晓清
 * @version V_1.0.0
 * @date 2017/7/18
 * @description
 */

public class AndroidLogoView extends CustomView {


    public AndroidLogoView(Context context) {
        super(context);
    }

    public AndroidLogoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AndroidLogoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mViewWidth / 2, mViewHeight / 2);          // 平移坐标系


        //宽为200 算起来
        mDeafultPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mDeafultPaint.setColor(Color.GREEN);
        Path path = new Path();
        // 创建Path并添加了一个矩形
        float[] jiao = new float[]{0, 0, 0, 0, 20, 20, 20, 20};
        path.addRoundRect(-100, 20, 100, 220, jiao, Path.Direction.CW);   //做左下角
        Path path2 = new Path();                                     // 着手
        path2.addRoundRect(-160, 0, -120, 140, 100, 100, Path.Direction.CW);
        Path path4 = new Path();                                     // 着手
        path4.addRoundRect(120, 0, 160, 140, 100, 100, Path.Direction.CW);        //右手
        Path path5 = new Path();                                     // 左脚
        path5.addRoundRect(20, 220, 60, 280, jiao, Path.Direction.CW);
        Path path6 = new Path();                                     // 右边脚
        path6.addRoundRect(-60, 220, -20, 280, jiao, Path.Direction.CW);
        // 眼睛 何触角
        Path path7 = new Path();                                     // 眼睛
        path7.addCircle(40, -50, 10, Path.Direction.CW);
        Path path8 = new Path();                                     // 眼睛
        path8.addCircle(-40, -50, 10, Path.Direction.CW);
        //储蓄
        float angle = (float) (Math.PI * 2 / 8);  //2pai
        Path path9 = new Path();
        float a = 100 * (float) Math.cos(angle);
        float b = 100 * (float) Math.sin(angle);
        path9.moveTo(70, -70);
        path9.lineTo(110, -110);
        path9.close();
        Path path10= new Path();
        path10.moveTo(-100*(float) Math.cos(angle), -100*(float) Math.sin(angle));

        path10.lineTo(-160*(float) Math.cos(angle),-160*(float) Math.sin(angle));
        Path path3 = new Path();                                     // 创建Path并添加了一个矩形
        path3.addArc(-100, -100, 100, 100, 0, -180);
        canvas.drawPath(path, mDeafultPaint);
        canvas.drawPath(path4, mDeafultPaint);
        canvas.drawPath(path3, mDeafultPaint);
        canvas.drawPath(path2, mDeafultPaint);
        canvas.drawPath(path5, mDeafultPaint);
        canvas.drawPath(path6, mDeafultPaint);
        mDeafultPaint.setColor(Color.WHITE);
        canvas.drawPath(path7, mDeafultPaint);
        canvas.drawPath(path8, mDeafultPaint);
        mDeafultPaint.setColor(Color.GREEN);
        mDeafultPaint.setStrokeWidth(10);
        mDeafultPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPath(path9, mDeafultPaint);
        canvas.drawPath(path10, mDeafultPaint);

//
//        canvas.translate(mViewWidth / 2, mViewHeight / 2);          // 平移坐标系
//
//        Path path = new Path();                                     // 创建Path并添加了一个矩形
//        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
//
//        Path dst = new Path();                                      // 创建用于存储截取后内容的 Path
//
//        PathMeasure measure = new PathMeasure(path, false);         // 将 Path 与 PathMeasure 关联
//
//// 截取一部分存入dst中，并使用 moveTo 保持截取得到的 Path 第一个点的位置不变
////        measure.getSegment(200, 600, dst, true);
//        measure.getSegment(200, 600, dst, false);
//
//        canvas.drawPath(dst, mDeafultPaint);
//
//


//
//
//
//        Path dst = new Path();     //dst的第一个点                                 // 创建用于存储截取后内容的 Path
//        dst.lineTo(-300, -300);                                     // <--- 在 dst 中添加一条线段
//
//        PathMeasure measure = new PathMeasure(path, false);         // 将 Path 与 PathMeasure 关联
//
////        如果 startWithMoveTo 为 true, 则被截取出来到Path片段保持原状，如果 startWithMoveTo 为 false，则会将截取出来的 Path 片段的起始点移动到 dst 的最后一个点，以保证 dst 的连续性。
//        measure.getSegment(200, 600, dst, false);                   // 截取一部分 并使用 moveTo 保持截取得到的 Path 第一个点的位置不变

        // 绘制 Path


    }
}
