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
 * @description 蜘蛛网控件
 */

public class RadarView extends CustomView {

    private int count = 6;
    private float angle = (float) (Math.PI * 2 / count);  //2pai

    private float radius;
    private int centerX;
    private int centerY;

    private String[] title = {"a", "b", "c", "d", "e", "f"};

    private double[] date = {50, 60, 20, 60, 30, 70, 50, 30};

    private float maxValue = 100;
    private Paint mainPaint;

    private Paint valuePaint;

    private Paint textPaint;


    public RadarView(Context context) {
        super(context);
    }

    public RadarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RadarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void initView() {
        super.initView();
        String[] title = {"a", "b", "c", "d", "e", "f"};

        double[] date = {100, 60, 50, 60, 50, 10, 20, 30};

        count = Math.min(date.length, title.length);

        mainPaint = new Paint();
        mainPaint.setAntiAlias(true);
        mainPaint.setColor(Color.GRAY);
        mainPaint.setStyle(Paint.Style.STROKE);


        valuePaint = new Paint();

        valuePaint.setAntiAlias(true);
        valuePaint.setColor(Color.BLUE); //中间绿色的
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);


        textPaint = new Paint();
        textPaint.setTextSize(20);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPolygon(canvas);
        drawLines(canvas);
        drawText(canvas);
        drawRegion(canvas);
    }

    private void drawRegion(Canvas canvas) {
        Path path = new Path();
        valuePaint.setAlpha(255);
        for (int i = 0; i < count; i++) {
            double percent = date[i] / maxValue;
            float x = (float) (centerX + radius * Math.cos(angle * i) * percent);
            float y = (float) (centerY + radius * Math.sin(angle * i) * percent);
            if (i == 0) {
                path.moveTo(x, centerY);   //6变形path 确定
            } else {
                path.lineTo(x, y);
            }
            //绘制小圆点
            canvas.drawCircle(x, y, 10, valuePaint);

        }

        valuePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, valuePaint);

        valuePaint.setAlpha(127);
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, valuePaint);
    }

    private void drawText(Canvas canvas) {
        String[] titles = {"王晓清", "王小明", "大头儿子", "巴巴爸爸", "阿打发蒂芬e", "f方的"};
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        for (int i = 0; i < count; i++) {
            float x = (float) (centerX + (radius + fontHeight / 2) * Math.cos(angle * i));
            float y = (float) (centerY + (radius + fontHeight / 2) * Math.sin(angle * i));
            if (angle * i >= 0 && angle * i <= Math.PI / 2) {//第4象限
                canvas.drawText(titles[i], x, y, textPaint);
            } else if (angle * i >= 3 * Math.PI / 2 && angle * i <= Math.PI * 2) {//第3象限
                canvas.drawText(titles[i], x, y, textPaint);
            } else if (angle * i > Math.PI / 2 && angle * i <= Math.PI) {//第2象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x - dis, y, textPaint);
            } else if (angle * i >= Math.PI && angle * i < 3 * Math.PI / 2) {//第1象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x - dis, y, textPaint);
            }

        }


    }

    private void drawLines(Canvas canvas) {
        // 画直线
        Path path = new Path();
        for (int i = 0; i < count; i++) {
            path.reset();
            path.moveTo(centerX, centerY);
            float x = (float) (centerX + radius * Math.cos(angle * i));
            float y = (float) (centerX + radius * Math.sin(angle * i));
            path.lineTo(x, y);
            canvas.drawPath(path, mainPaint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        radius = Math.min(h, w) / 2 * 0.9f;
        centerX = w / 2;
        centerY = h / 2;
        postInvalidate();
    }


    // 化六边形
    private void drawPolygon(Canvas canvas) {
        Path path = new Path();
        float r = radius / (count - 1);
        for (int i = 0; i < count; i++) {
            //冲内到外画六边形
            float curR = r * i;
            path.reset();
            for (int j = 0; j < count; j++) {
                if (j == 0) {
                    //颞部第一个点用moveto定点
                    path.moveTo(centerX + curR, centerY); //中点坐标
                } else {
                    float x = (float) (centerX + curR * Math.cos(angle * j));
                    float y = (float) (centerY + curR * Math.sin(angle * j));
                    path.lineTo(x, y);
                }
            }
            path.close();
            canvas.drawPath(path, mainPaint);
        }
    }

}
