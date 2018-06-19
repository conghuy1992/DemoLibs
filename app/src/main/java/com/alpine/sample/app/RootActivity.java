package com.alpine.sample.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alpine.sample.app.httpServer.MainActivity;
import com.alpine.sample.app.wifiSetting.WifiSelectionListActivity;

public class RootActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnWifiSetting, btnHttpServer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_layout);
        btnWifiSetting = (Button) findViewById(R.id.btnWifiSetting);
        btnHttpServer = (Button) findViewById(R.id.btnHttpServer);

        btnWifiSetting.setOnClickListener(this);
        btnHttpServer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnWifiSetting) {
            launchActivity(WifiSelectionListActivity.class);
        } else if (v == btnHttpServer) {
            launchActivity(MainActivity.class);
        }
    }

    private void launchActivity(Class c) {
        startActivity(new Intent(this, c));
    }
}
