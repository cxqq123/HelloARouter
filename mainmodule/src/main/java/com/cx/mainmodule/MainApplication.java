package com.cx.mainmodule;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by cx on 2018/6/22.
 */

public class MainApplication extends Application{

    @Override
    public void onCreate() {
        //完成各种初始化操作
        super.onCreate();
        //初始化ARouter
        ARouter.init(this);
        ARouter.openDebug();
        ARouter.openLog();
    }
}
