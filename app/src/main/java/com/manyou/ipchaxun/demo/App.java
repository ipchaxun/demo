package com.manyou.ipchaxun.demo;

import android.app.Application;

import com.manyou.ipchaxun.IpChaxunHelper;

/**
 * Created by admin on 2020/3/14.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        IpChaxunHelper.init(this);
    }
}
