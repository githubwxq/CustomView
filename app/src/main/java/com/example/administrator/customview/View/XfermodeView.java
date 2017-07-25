package com.example.administrator.customview.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.wxq.view.CustomView;

/**
 * @author 王晓清
 * @version V_1.0.0
 * @date 2017/7/21
 * @description
 */

public class XfermodeView extends CustomView {
    int width = 400;
    int height = 400;
    Bitmap dstBmp;
    Bitmap srcBmp;


    public XfermodeView(Context context) {
        super(context);
    }

    public XfermodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public XfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void initView() {
        super.initView();
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        srcBmp = makeSrc(400, 400);
        dstBmp=makeDst(400,400);




    }

    private Bitmap makeDst(int w, int h) {

        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(0xFF66AAFF);
        c.drawOval(0, 0, w, h, p);
        return bm;
    }

    private Bitmap makeSrc(int width, int height) {
        Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);
        mDeafultPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mDeafultPaint.setColor(0xffffcc44);
        canvas.drawRect(0, 0, width, height, mDeafultPaint);
        return bm;
    }

//    我们先回顾下Mode.SRC_IN的效果：在处理源图像时，以显示源图像为主，在相交时利用目标图像的透明度来改变源图像的透明度和饱和度。当目标图像透明度为0时，源图像就完全不显示。
//    再回过来看结果，第一个结果是对的，因为不与圆相交以外的区域透明度都是0，而第二个图像怎么就变成了这屌样，源图像全部都显示出来了。
//
//            （1）、saveLayer的绘图流程
//    这是因为在调用saveLayer时，会生成了一个全新的bitmap，这个bitmap的大小就是我们指定的保存区域的大小，新生成的bitmap是全透明的，在调用saveLayer后所有的绘图操作都是在这个bitmap上进行的。
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);  //设了背景另开一个图陈确保图片以为的透明度为0
        int layerID= canvas.saveLayer(0, 0, width * 2, height * 2, mDeafultPaint, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBmp,0,0,mDeafultPaint);
        mDeafultPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(srcBmp, width / 2, height / 2, mDeafultPaint);
        mDeafultPaint.setXfermode(null);
         canvas.restoreToCount(layerID);
        mDeafultPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawCircle(0,0,100,mDeafultPaint);

    }
}
