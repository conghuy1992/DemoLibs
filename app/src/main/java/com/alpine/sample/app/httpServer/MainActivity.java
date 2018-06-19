/*
 * Copyright (C) 2018 A.I.Corporation, All Rights Reserved
 */
package com.alpine.sample.app.httpServer;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alpine.sample.app.R;
import com.alpine.sample.app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    Application application = (Application) getApplication();
    MainPresenter presenter = new MainPresenter(binding, application);
    binding.setPresenter(presenter);
  }
}
