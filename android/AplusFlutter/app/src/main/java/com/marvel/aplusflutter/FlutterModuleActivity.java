package com.marvel.aplusflutter;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

/**
 * 描述:FlutterModuleActivity.
 * <p>
 *
 * @author yanwenqiang.
 * @date 2019/4/15
 */
public class FlutterModuleActivity extends FlutterActivity implements ActivityParams {
    private static final String CHANNEL = "flutter.io/lifecycle";

    @Override
    public FlutterView createFlutterView(Context context) {
        String route = getIntent().getStringExtra(ROUTE);
        Log.e("路由：", route);

        WindowManager.LayoutParams matchParent = new WindowManager.LayoutParams(-1, -1);
        FlutterNativeView nativeView = this.createFlutterNativeView();
        FlutterView flutterView = new FlutterView(this, null, nativeView);
        flutterView.setInitialRoute(route);
        flutterView.setLayoutParams(matchParent);
        this.setContentView(flutterView);
        return flutterView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);

        new MethodChannel(getFlutterView(), CHANNEL).setMethodCallHandler(
                (call, result) -> {
                    if (call.method.equals("back")) {
                        finish();
                    }
                });
    }
}
