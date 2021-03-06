package com.example.temitest;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;


public class AppApplication extends Application {
    private static Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        initJpush();
    }

    private void initJpush() {
        JPushInterface.setDebugMode(true);//如果时正式版就改成false
        JPushInterface.init(this);
    }

    public static Application getContext() {
        return mApplication;
    }
}
