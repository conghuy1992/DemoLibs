/*
 * Copyright (C) 2018 A.I.Corporation, All Rights Reserved
 */
package com.alpine.sample.service.api;

import android.content.Context;
import android.support.annotation.Keep;

import com.alpine.sample.service.R;
import com.alpine.sample.service.Route;

import java.util.regex.Matcher;

import jp.co.aicp.sl.api.SlHttpReq;
import jp.co.aicp.sl.api.SlHttpRes;

import static jp.co.aicp.sl.api.SlHttpMethod.POST;

/**
 * 4.5. Notification Endpoint
 */
@Keep
public final class Notification {
  private final Context context;

  public Notification(Context context) {
    this.context = context;
  }

  /**
   * 4.5.1 POST notification
   */
  @Route(pattern = "", allow = {POST})
  public void notification(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_notification_notificationresponse_sample).getBytes());
  }
}
