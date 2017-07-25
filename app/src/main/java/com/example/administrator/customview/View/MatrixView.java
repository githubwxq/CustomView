package com.example.administrator.customview.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;

import com.example.administrator.customview.R;
import com.wxq.view.CustomView;

/**
 * @author 王晓清
 * @version V_1.0.0
 * @date 2017/7/20
 * @description  matrix 用法
 *
 * 基本方法	equals hashCode toString toShortString	比较、 获取哈希值、 转换为字符串
数值操作	set reset setValues getValues	设置、 重置、 设置数值、 获取数值
数值计算	mapPoints mapRadius mapRect mapVectors	计算变换后的数值
设置(set)	setConcat setRotate setScale setSkew setTranslate	设置变换
前乘(pre)	preConcat preRotate preScale preSkew preTranslate	前乘变换
后乘(post)	postConcat postRotate postScale postSkew postTranslate	后乘变换
特殊方法	setPolyToPoly setRectToRect rectStaysRect setSinCos	一些特殊操作
矩阵相关	invert isAffine isIdentity	求逆矩阵、 是否为仿射矩阵、 是否为单位矩阵 …
 */

public class MatrixView extends CustomView {
    public MatrixView(Context context) {
        super(context);
    }

    public MatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MatrixView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//         Matrix matrix=new Matrix();
        mDeafultPaint.setStrokeWidth(10);
        canvas.drawRoundRect(0,0,300,300,50,50,mDeafultPaint);
        BitmapFactory.Options options = new  BitmapFactory.Options();
        options.inSampleSize = 2 ; //图片宽高都为原来的二分之一，即图片为原来的四分之一
        Matrix matrix = new Matrix();
        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.timg,options);
        canvas.drawBitmap(bitmap, matrix, mDeafultPaint);
        matrix.setTranslate(100, 1000);
        canvas.drawBitmap(bitmap, matrix, mDeafultPaint);

        matrix.setSinCos(1, 0, 300, 300);
        canvas.drawBitmap(bitmap, matrix, mDeafultPaint);



    }
}
