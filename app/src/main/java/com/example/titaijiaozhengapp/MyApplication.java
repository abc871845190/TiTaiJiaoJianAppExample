package com.example.titaijiaozhengapp;

import android.app.Application;
import android.content.Context;

import com.dueeeke.videoplayer.BuildConfig;
import com.dueeeke.videoplayer.player.AndroidMediaPlayerFactory;
import com.dueeeke.videoplayer.player.VideoViewConfig;
import com.dueeeke.videoplayer.player.VideoViewManager;
import com.xuexiang.xui.XUI;

public class MyApplication extends Application {
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getBaseContext();
        XUI.init(this); //初始化UI框架
        XUI.debug(true);  //开启UI框架调试日志

        //播放器配置，注意：此为全局配置，按需开启
        VideoViewManager.setConfig(VideoViewConfig.newBuilder()
                .setLogEnabled(BuildConfig.DEBUG)
                .setPlayerFactory(AndroidMediaPlayerFactory.create())
                .build());
    }

    public static Context getAppContext() {
        return appContext;
    }
}
