package com.example.titaijiaozhengapp;

import android.app.Application;
import android.content.Context;

import com.xuexiang.xui.XUI;

public class MyApplication extends Application {
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getBaseContext();
        XUI.init(this); //初始化UI框架
        XUI.debug(true);  //开启UI框架调试日志

    }

    public static Context getAppContext() {
        return appContext;
    }
}
