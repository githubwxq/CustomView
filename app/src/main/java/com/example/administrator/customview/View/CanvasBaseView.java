package com.example.administrator.customview.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.util.AttributeSet;

import com.example.administrator.customview.R;
import com.wxq.view.CustomView;

/**
 * @author 王晓清
 * @version V_1.0.0
 * @date 2017/7/17
 * @description
 */

public class CanvasBaseView extends CustomView {
    public CanvasBaseView(Context context) {
        super(context);
        recording();
    }

    public CanvasBaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        recording();
    }

    public CanvasBaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        recording();
    }

    Paint mPaint;
    Bitmap bitmap;
    @Override
    public void initView() {
        //初始化控件
        mPaint = new Paint();
        // 设置画笔颜色为蓝色
        mPaint.setColor(Color.BLUE);
        // 设置画笔宽度为10px
        mPaint.setStrokeWidth(5f);
        //设置画笔模式为填充
        mPaint.setStyle(Paint.Style.STROKE);

        BitmapFactory.Options options = new  BitmapFactory.Options();
        options.inSampleSize = 2 ; //图片宽高都为原来的二分之一，即图片为原来的四分之一

        bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.timg,options);

        bitmap= zoomImage(bitmap,300,300);

//        ImageUtils.
    }




    public  Bitmap zoomImage(Bitmap bgimage, double newWidth,
                                   double newHeight) {
        // 获取这个图片的宽和高
        float width = bgimage.getWidth();
        float height = bgimage.getHeight();
        // 创建操作图片用的matrix对象
        Matrix matrix = new Matrix();
        // 计算宽高缩放率
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 缩放图片动作
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int) width,
                (int) height, matrix, true);
        return bitmap;
    }

    // 1.创建Picture
    private Picture mPicture = new Picture();

    //100dp  300 xiangshu
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
//        mPaint.setColor(Color.BLACK);
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,100,mPaint);
//        // 在坐标原点绘制一个蓝色圆形
//        mPaint.setColor(Color.BLUE);
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,100,mPaint);  //画布位移了
//
        canvas.translate(mViewWidth / 2, mViewHeight / 2);
//        缩放的中心默认为坐标原点,而缩放中心轴就是坐标轴
//        RectF rect = new RectF(0,-400,400,0);   // 矩形区域
//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//        canvas.scale(0.5f,0.5f);                // 画布缩放
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);

//        RectF rect = new RectF(0, -400, 400, 0);   // 矩形区域

//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//
//        canvas.scale(-0.5f,-0.5f);          // 画布缩放  <-- 缩放中心向右偏移了200个单位
//
//        mPaint.setColor(Color.WHITE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);
//

//        mPaint.setColor(Color.WHITE);
//
//        canvas.scale(0.9f, 0.9f);
//        canvas.drawRect(rect, mPaint);

//        canvas.rotate(180);                     // 旋转180度 <-- 默认旋转中心为原点
//        canvas.drawRect(rect, mPaint);
//        canvas.rotate(90);
//        canvas.drawRect(rect, mPaint);


//        canvas.rotate(180,200,0);               // 旋转180度 <-- 旋转中心向右偏移200个单位
//
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);
//
//
//
//
        canvas.drawCircle(0,0,400,mPaint);          // 绘制两个圆形
        canvas.drawCircle(0,0,380,mPaint);

        for (int i=0; i<=360; i+=10){               // 绘制圆形之间的连接线
            canvas.drawLine(0,380,0,400,mPaint);
            canvas.rotate(10);
        }

        mPicture.draw(canvas);

        for (int i=0; i<=10; i++){               // 绘制圆形之间的连接线
            canvas.drawBitmap(bitmap,0,0,new Paint());
            canvas.rotate(36);
        }


    }


    // 2.录制内容方法
    private void recording() {
        // 开始录制 (接收返回值Canvas)
        Canvas canvas = mPicture.beginRecording(500, 500);
        // 创建一个画笔
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        // 在Canvas中具体操作
        // 位移
//        canvas.translate(250,250);
        // 绘制一个圆
        canvas.drawCircle(0,0,100,paint);

        mPicture.endRecording();
    }



}

//
//    Bitmap bitmap=null;
//try {
//        InputStream is = mContext.getAssets().open("bitmap.png");
//        bitmap = BitmapFactory.decodeStream(is);
//        is.close();
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//
//        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(),R.raw.bitmap);
//
//
//        Bitmap bitmap = BitmapFactory.decodeFile("/sdcard/bitmap.png");