package com.example.administrator.customview;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * @author 王晓清
 * @version V_1.0.0
 * @date 2017/7/17
 * @description
 */

public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化常用工具类
        Utils.init(this);
        com.jingewenku.abrahamcaijin.commonutil.application.AppUtils.init(this);
    }
}
