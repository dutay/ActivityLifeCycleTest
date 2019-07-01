package com.example.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import timber.log.Timber;

public class MainApplication extends Application {

    private static Context applicationContext;
    private static Handler applicationHandler;



    public static Handler getHandler() {
        if (applicationHandler == null) {
            applicationHandler = new Handler(Looper.myLooper());
        }

        return applicationHandler;
    }

    public static Context getApplicationInstance() {
        return applicationContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        applicationHandler = new Handler(Looper.myLooper());
        initAppLog();
    }

    private void initAppLog() {
        boolean configDebug = true;//dubug模式暂设为true
        if(configDebug){
            Timber.plant(new Timber.DebugTree());
        }
    }
}
