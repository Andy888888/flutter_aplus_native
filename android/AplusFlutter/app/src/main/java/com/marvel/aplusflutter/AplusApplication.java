package com.marvel.aplusflutter;

import android.app.Application;

import io.flutter.view.FlutterMain;

/**
 * 描述:待描述.
 * <p>
 *
 * @author yanwenqiang.
 * @date 2019/4/16
 */
public class AplusApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlutterMain.startInitialization(getApplicationContext());
    }
}
