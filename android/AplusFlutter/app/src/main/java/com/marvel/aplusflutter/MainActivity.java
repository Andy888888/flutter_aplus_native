package com.marvel.aplusflutter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import io.flutter.facade.Flutter;

public class MainActivity extends AppCompatActivity {

    private String editPropertyRoute = "edit-property?{\"keyId\":\"123\",\"trustType\":2}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_edit_property)
                .setOnClickListener(view -> flutterActivity(editPropertyRoute));
        findViewById(R.id.btn_grid).setOnClickListener(view -> flutterActivity("grid"));
    }

    private void flutterModule() {
        View flutterView = Flutter.createView(MainActivity.this, getLifecycle(), editPropertyRoute);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(900, 1200);
        layoutParams.leftMargin = 80;
        layoutParams.topMargin = 80;
        addContentView(flutterView, layoutParams);
    }

    private void flutterActivity(String route) {
        Intent intent = new Intent(this, FlutterModuleActivity.class);
        intent.putExtra(FlutterModuleActivity.ROUTE, route);
        startActivity(intent);
    }
}
