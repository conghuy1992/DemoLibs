/*
 * Copyright (C) 2018 A.I.Corporation, All Rights Reserved
 */
package com.alpine.sample.app.httpServer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.alpine.sample.service.I19BbService;
import com.alpine.sample.service._19BbService;

public class Application extends android.app.Application implements ServiceConnection {
  @Nullable
  private I19BbService _19BbService;

  @Nullable
  public I19BbService getI19BbService() {
    return _19BbService;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    Intent intent = new Intent(_19BbService.class.getName());
    intent.setPackage(this.getPackageName());

    boolean binded = bindService(intent, this, Context.BIND_AUTO_CREATE);
  }

  @Override
  public void onServiceConnected(ComponentName name, IBinder service) {
    String className = name.getClassName();

    if (className.equals(_19BbService.class.getName())) {
      _19BbService = (I19BbService) service;
    }
  }

  @Override
  public void onServiceDisconnected(ComponentName name) {
    String className = name.getClassName();

    if (className.equals(I19BbService.class.getName())) {
      _19BbService = null;
    }
  }
}
