package com.example.administrator.customview.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;

import com.example.administrator.customview.R;
import com.wxq.view.CustomView;

/**
 * @author 王晓清
 * @version V_1.0.0
 * @date 2017/7/21
 * @description
 */

public class BitmapShaderView extends CustomView {
    public BitmapShaderView(Context context) {
        super(context);
    }

    public BitmapShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BitmapShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    BitmapShader mShader;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();

//        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.yourname);
//        mShader = new BitmapShader(bmp, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
//        mDeafultPaint.setShader(mShader);
//        mDeafultPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawRect(0,0,500,500,mDeafultPaint);


//        mDeafultPaint.setTextSize(200);
//        mDeafultPaint.setColor(Color.RED);
//        mDeafultPaint.setTypeface(Typeface.DEFAULT_BOLD);
//        mDeafultPaint.setShader(mShader);
//        canvas.drawText("小狗狗我是你大爷你妹的哦！！！！！！！！！",0,250,mDeafultPaint);
//


//        RadialGradient mShader = new RadialGradient(200, 200, 200, new int[]{Color.parseColor("#00aa00"), Color.parseColor("#880033"),
//                Color.parseColor("#F8795A"),
//                Color.parseColor("#CC423C")}, new float[]{0.0f, 0.2f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
//        mDeafultPaint.setShader(mShader);
//        canvas.drawRect(0, 0, 400, 400, mDeafultPaint);



        //组合渲染器 16中组合方式 设置图的背景融合图片显示好看的背景





        Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.mipmap.yourname);



//        Bitmap result = Bitmap.createScaledBitmap(bmp,250,250,false);
        //1. 编写1个BitmapShader.
        BitmapShader bitmapShader = new BitmapShader(bmp, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        //2. 编写1个RadiasGradient。
        RadialGradient radialGradient = new RadialGradient(500,500,100, Color.BLACK,Color.YELLOW, Shader.TileMode.CLAMP);
        //3. 将它们进行混合产生新的Shader.
        ComposeShader composeShader = new ComposeShader(bitmapShader,radialGradient,new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mDeafultPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mDeafultPaint.setShader(composeShader);
        //4. 以新的Shader绘制一个圆。
        canvas.drawCircle(500,500,500,mDeafultPaint);

        canvas.drawText("qwerqqweqweqwe",100,100,mDeafultPaint);

    }
}
