package com.example.lenovo.ljq_text_529.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2018/5/28.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
