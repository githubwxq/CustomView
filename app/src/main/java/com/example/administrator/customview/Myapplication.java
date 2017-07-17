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
        Utils.init(this);
    }
}
