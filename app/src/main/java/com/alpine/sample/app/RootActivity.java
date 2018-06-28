package com.alpine.sample.app;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alpine.sample.app.httpServer.MainActivity;
import com.alpine.sample.app.wifiSetting.WifiSelectionListActivity;

import jp.co.alpine.wificonfiglibs.Utils;

public class RootActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnWifiSetting, btnHttpServer;
    private TextView tvIp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_layout);
        btnWifiSetting = (Button) findViewById(R.id.btnWifiSetting);
        btnHttpServer = (Button) findViewById(R.id.btnHttpServer);
        tvIp = (TextView) findViewById(R.id.tvIp);

        btnWifiSetting.setOnClickListener(this);
        btnHttpServer.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvIp.setText("HOST IP: " + Utils.getMyIp(this)
                + "\n"
                + "WIFI:" + Utils.getWifiName(this));
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
