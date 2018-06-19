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
 * 4.4. 画面表示機能
 */
@Keep
public final class UiView {
  private final Context context;

  public UiView(Context context) {
    this.context = context;
  }

  /**
   * 4.4.1.1 POST uiview/poilist
   */
  @Route(pattern = "/poilist/0x([0-9A-F]+)", allow = {POST})
  public void poilist(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    if (matcher.group(1).equals("0123ABCD")) {
      res.setStatus(context.getString(R.string.http_code_200_ok));
      res.setHeader(null);
      res.setContentType(context.getString(R.string.http_type_application_json_utf8));
      res.setContent(context.getString(R.string.rest_uiview_json_sample).getBytes());
    } else {
      res.setStatus(context.getString(R.string.http_code_404_not_found));
      res.setHeader(null);
      res.setContentType(null);
      res.setContent(null);
    }
  }

  /**
   * 4.4.1.1 POST uiview/poidetails
   */
  @Route(pattern = "/poidetails/0x([0-9A-F]+)", allow = {POST})
  public void poidetails(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    if (matcher.group(1).equals("0123ABCD")) {
      res.setStatus(context.getString(R.string.http_code_200_ok));
      res.setHeader(null);
      res.setContentType(context.getString(R.string.http_type_application_json_utf8));
      res.setContent(context.getString(R.string.rest_uiview_json_sample).getBytes());
    } else {
      res.setStatus(context.getString(R.string.http_code_404_not_found));
      res.setHeader(null);
      res.setContentType(null);
      res.setContent(null);
    }
  }
}
