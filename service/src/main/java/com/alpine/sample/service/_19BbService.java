/*
 * Copyright (C) 2018 A.I.Corporation, All Rights Reserved
 */
package com.alpine.sample.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public final class _19BbService extends Service {
  @Nullable
  private _19BbServiceStub stub;

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return stub;
  }

  @Override
  public void onCreate() {
    try {
      stub = new _19BbServiceStub(getApplicationContext());
    } catch (Throwable e) {
      Log.wtf(getClass().getSimpleName(), e);
    }
  }
}
