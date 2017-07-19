package com.example.administrator.customview.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;

import com.wxq.view.CustomView;

/**
 * @author 王晓清
 * @version V_1.0.0
 * @date 2017/7/18
 * @description
 */

public class PathOpView extends CustomView {
    public PathOpView(Context context) {
        super(context);
    }

    public PathOpView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PathOpView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        int x = 80;
//        int r = 100;
//
//        canvas.translate(250,0);
//
//        Path path1 = new Path();
//        Path path2 = new Path();
//        Path pathOpResult = new Path();
//
//        path1.addCircle(-x, 0, r, Path.Direction.CW);
//        path2.addCircle(x, 0, r, Path.Direction.CW);
//
//        pathOpResult.op(path1,path2, Path.Op.DIFFERENCE);
//        canvas.translate(0, 200);
//        canvas.drawText("DIFFERENCE", 240,0,mDeafultPaint);
//        canvas.drawPath(pathOpResult,mDeafultPaint);
//
//        pathOpResult.op(path1,path2, Path.Op.REVERSE_DIFFERENCE);
//        canvas.translate(0, 300);
//        canvas.drawText("REVERSE_DIFFERENCE", 240,0,mDeafultPaint);
//        canvas.drawPath(pathOpResult,mDeafultPaint);
//
//        pathOpResult.op(path1,path2, Path.Op.INTERSECT);
//        canvas.translate(0, 300);
//        canvas.drawText("INTERSECT", 240,0,mDeafultPaint);
//        canvas.drawPath(pathOpResult,mDeafultPaint);
//        pathOpResult.op(path1,path2, Path.Op.UNION);
//        canvas.translate(0, 300);
//        canvas.drawText("UNION", 240,0,mDeafultPaint);
//        canvas.drawPath(pathOpResult,mDeafultPaint);
//        pathOpResult.op(path1,path2, Path.Op.XOR);
//        canvas.translate(0, 300);
//        canvas.drawText("XOR", 240,0,mDeafultPaint);
//        canvas.drawPath(pathOpResult,mDeafultPaint);
//        canvas.translate(mViewWidth / 2, mViewHeight / 2);
//        Path path1 = new Path();
//        Path path2 = new Path();
//        Path path3 = new Path();
//        Path path4 = new Path();
//        path1.addCircle(0, 0, 200, Path.Direction.CW);
//        path2.addRect(0, -200, 200, 200, Path.Direction.CW);
//        path3.addCircle(0, -100, 100, Path.Direction.CW);
//        path4.addCircle(0, 100, 100, Path.Direction.CCW);
//        canvas.drawPath(path1, mDeafultPaint);
//        mDeafultPaint.setColor(Color.BLUE);
//        canvas.drawPath(path2, mDeafultPaint);
//        mDeafultPaint.setColor(Color.YELLOW);
//        canvas.drawPath(path3, mDeafultPaint);
//        mDeafultPaint.setColor(Color.BLACK);
//        canvas.drawPath(path4, mDeafultPaint);
//        mDeafultPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        path1.op(path2, Path.Op.DIFFERENCE);
//        path1.op(path3, Path.Op.UNION);
//        path1.op(path4, Path.Op.DIFFERENCE);
//        canvas.drawPath(path1, mDeafultPaint);


        // path边检

//        canvas.translate(mViewWidth/2,mViewHeight/2);
//        RectF rect1 = new RectF();              // 存放测量结果的矩形
//        Path path = new Path();                 // 创建Path并添加一些内容
//        path.lineTo(100,-50);
//        path.lineTo(100,50);
//        path.close();
//        path.addCircle(-100,0,100, Path.Direction.CW);
//        path.computeBounds(rect1,true);         // 测量Path
//        canvas.drawPath(path,mDeafultPaint);    // 绘制Path
//        mDeafultPaint.setStyle(Paint.Style.STROKE);
//        mDeafultPaint.setColor(Color.RED);
//        canvas.drawRect(rect1,mDeafultPaint);   // 绘制边界

        //pathmeasure
//        返回值	方法名	释义
//        void	setPath(Path path, boolean forceClosed)	关联一个Path
//        boolean	isClosed()	是否闭合
//        float	getLength()	获取Path的长度
//        boolean	nextContour()	跳转到下一个轮廓
//        boolean	getSegment(float startD, float stopD, Path dst, boolean startWithMoveTo)	截取片段
//        boolean	getPosTan(float distance, float[] pos, float[] tan)	获取指定长度的位置坐标及该点切线值
//        boolean	getMatrix(float distance, Matrix matrix, int flags)

//
//        canvas.translate(mViewWidth/2,mViewHeight/2);
//
//        Path path = new Path();
//
//        path.lineTo(0,200);
//        path.lineTo(200,200);
//        path.lineTo(200,0);
//
//
//        PathMeasure measure1 = new PathMeasure(path,false);
//        PathMeasure measure2 = new PathMeasure(path,true);
//
//        Log.e("TAG", "forceClosed=false---->"+measure1.getLength());
//        Log.e("TAG", "forceClosed=true----->"+measure2.getLength());
//
//        canvas.drawPath(path,mDeafultPaint);


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


        canvas.translate(mViewWidth / 2, mViewHeight / 2);          // 平移坐标系

        Path path = new Path();                                     // 创建Path并添加了一个矩形
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);

        Path dst = new Path();     //dst的第一个点                                 // 创建用于存储截取后内容的 Path
        dst.lineTo(-300, -300);                                     // <--- 在 dst 中添加一条线段

        PathMeasure measure = new PathMeasure(path, false);         // 将 Path 与 PathMeasure 关联

//        如果 startWithMoveTo 为 true, 则被截取出来到Path片段保持原状，如果 startWithMoveTo 为 false，则会将截取出来的 Path 片段的起始点移动到 dst 的最后一个点，以保证 dst 的连续性。
        measure.getSegment(200, 600, dst, false);                   // 截取一部分 并使用 moveTo 保持截取得到的 Path 第一个点的位置不变

        canvas.drawPath(dst, mDeafultPaint);                        // 绘制 Path


    }
}
