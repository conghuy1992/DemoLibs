/*
 * Copyright (C) 2018 A.I.Corporation, All Rights Reserved
 */
package com.alpine.sample.service;

import android.support.annotation.NonNull;
import android.util.Log;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.co.aicp.sl.api.SlHttpMethod;
import jp.co.aicp.sl.api.SlHttpReq;
import jp.co.aicp.sl.api.SlHttpRes;

public final class RouteCache {
  @NonNull
  public final Method method;
  @NonNull
  public final Route route;
  @NonNull
  public final Pattern pattern;
  @NonNull
  public final String joined;
  @NonNull
  private final SlHttpMethod[] allow;

  private RouteCache(@NonNull Method method, @NonNull Route route) {
    this.method = method;
    this.route = route;
    this.pattern = Pattern.compile(route.pattern());
    this.joined = Utils.join(route.allow());
    this.allow = route.allow();
    Arrays.sort(this.allow);
  }

  @NonNull
  public static RouteCache[] routing(@NonNull Class<?> clazz) {
    ArrayList<RouteCache> caches = new ArrayList<>();

    for (Method method : clazz.getDeclaredMethods()) {
      Route route = method.getAnnotation(Route.class);
      if (route == null)
        continue;

      Method typed;
      try {
        typed = clazz.getDeclaredMethod(method.getName(), SlHttpReq.class, SlHttpRes.class, Matcher.class);
      } catch (NoSuchMethodException e) {
        typed = null;
      }

      if (!method.equals(typed)) {
        Log.w(RouteCache.class.getSimpleName(), "not routable: " + method.getName());
        continue;
      }

      RouteCache cache = new RouteCache(method, route);
      caches.add(cache);
    }

    if (caches.isEmpty())
      Log.w(RouteCache.class.getSimpleName(), "not RESTful: " + clazz.getName());

    return caches.toArray(new RouteCache[caches.size()]);
  }

  public boolean allows(@NonNull SlHttpMethod method) {
    return 0 <= Arrays.binarySearch(allow, method);
  }
}
