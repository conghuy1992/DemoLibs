/*
 * Copyright (C) 2018 A.I.Corporation, All Rights Reserved
 */
package com.alpine.sample.service;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alpine.sample.service.api.GenreSearch;
import com.alpine.sample.service.api.Notification;
import com.alpine.sample.service.api.SpeechRecSearch;
import com.alpine.sample.service.api.UiView;
import com.alpine.sample.service.api.UserInfo;

import jp.co.aicp.sl.api.SlFactory;
import jp.co.aicp.sl.api.SlHttp;
import jp.co.aicp.sl.api.SlRet;
import jp.co.aicp.sl.api.SlService;

import static jp.co.aicp.sl.api.SlRet.SUCCESS;

final class _19BbServiceStub extends I19BbService.Stub {
  @NonNull
  private final Context context;
  @NonNull
  private final SlService slService;

  _19BbServiceStub(@NonNull Context context) {
    this.context = context;

    SlFactory factory = new SlFactory() {
      @NonNull
      @Override
      protected Context getContext() {
        return context;
      }
    };
    this.slService = factory.getService();
  }

  @Override
  public boolean start() {
    return addUri() && slService.start() == SUCCESS;
  }

  @Override
  public boolean stop() {
    SlRet result = slService.stop();
    removeUri();
    return result == SUCCESS;
  }

  private boolean addUri() {
    SlHttp http = slService.getHttp();
    boolean result =
      SUCCESS == http.addUri("/userinfo", Rest.of(new UserInfo(context), context)) &&
      SUCCESS == http.addUri("/speechrecsearch", Rest.of(new SpeechRecSearch(context), context)) &&
      SUCCESS == http.addUri("/genresearch", Rest.of(new GenreSearch(context), context)) &&
      SUCCESS == http.addUri("/uiview", Rest.of(new UiView(context), context)) &&
      SUCCESS == http.addUri("/notification", Rest.of(new Notification(context), context));

    if (!result)
      removeUri();

    return result;
  }

  private void removeUri() {
    SlHttp http = slService.getHttp();
    http.removeUriAll();
  }
}
