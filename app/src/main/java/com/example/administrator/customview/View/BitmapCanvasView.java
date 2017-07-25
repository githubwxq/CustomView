package com.example.administrator.customview.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.wxq.view.CustomView;

/**
 * @author 王晓清
 * @version V_1.0.0
 * @date 2017/7/21
 * @description
 */

public class BitmapCanvasView extends CustomView {
    private Bitmap bitmap;

    private Canvas mcanvas;
    public BitmapCanvasView(Context context) {
        super(context);
    }

    public BitmapCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BitmapCanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bitmap=Bitmap.createBitmap(500,500,Bitmap.Config.ARGB_8888);
        mcanvas=new Canvas(bitmap);



        mDeafultPaint.setTextSize(100);
        mcanvas.drawText("我是王晓清",0,100,mDeafultPaint);

        canvas.drawBitmap(bitmap,0,0,mDeafultPaint);
    }
}
