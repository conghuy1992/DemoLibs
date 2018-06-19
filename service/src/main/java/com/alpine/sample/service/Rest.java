/*
 * Copyright (C) 2018 A.I.Corporation, All Rights Reserved
 */
package com.alpine.sample.service;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.regex.Matcher;

import jp.co.aicp.sl.api.SlHttpReq;
import jp.co.aicp.sl.api.SlHttpRes;
import jp.co.aicp.sl.api.SlHttpUserCb;
import jp.co.aicp.sl.api.SlRet;

public final class Rest implements SlHttpUserCb {

  @NonNull
  private final Object object;
  @NonNull
  private final Context context;
  @NonNull
  private final RouteCache[] routes;

  private Rest(@NonNull Object object, @NonNull Context context) {
    this.object = object;
    this.context = context;
    this.routes = RouteCache.routing(object.getClass());
  }

  @NonNull
  public static Rest of(@NonNull Object object, @NonNull Context context) {
    return new Rest(object, context);
  }

  @NonNull
  @Override
  public SlRet httpCb(@NonNull SlHttpReq req, @NonNull SlHttpRes res, @NonNull String nextPath) {
    RouteCache route = null;
    Matcher matcher = null;
    int i;

    for (i = 0; i < routes.length; ++i) {
      route = routes[i];
      matcher = route.pattern.matcher(nextPath);
      if (matcher.matches())
        break;
    }

    if (i == routes.length) {
      res.setStatus(context.getString(R.string.http_code_404_not_found));
      res.setHeader(null);
      res.setContentType(null);
      res.setContent(null);
    } else if (!route.allows(req.getMethod())) {
      res.setStatus(context.getString(R.string.http_code_405_method_not_allowed));
      res.setHeader(context.getString(R.string.http_head_allow, route.joined + "\r\n"));
      res.setContentType(null);
      res.setContent(null);
    } else try {
      route.method.invoke(object, req, res, matcher);
    } catch (Throwable e) {
      res.setStatus(context.getString(R.string.http_code_500_internal_server_error));
      res.setHeader(null);
      res.setContentType(null);
      res.setContent(null);
    }

    return SlRet.SUCCESS;
  }
}
