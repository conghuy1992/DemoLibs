/*
 * Copyright (C) 2018 A.I.Corporation, All Rights Reserved
 */
package com.alpine.sample.service.api;

import android.content.Context;
import android.support.annotation.Keep;

import com.alpine.sample.service.R;
import com.alpine.sample.service.Route;
import com.alpine.sample.service.Utils;

import java.io.IOException;
import java.util.regex.Matcher;

import jp.co.aicp.sl.api.SlHttpReq;
import jp.co.aicp.sl.api.SlHttpRes;

import static jp.co.aicp.sl.api.SlHttpMethod.DELETE;
import static jp.co.aicp.sl.api.SlHttpMethod.GET;
import static jp.co.aicp.sl.api.SlHttpMethod.HEAD;
import static jp.co.aicp.sl.api.SlHttpMethod.POST;

/**
 * 4.1. サーバ/車載データ交換
 */
@Keep
public final class UserInfo {
  private final Context context;

  public UserInfo(Context context) {
    this.context = context;
  }

  /**
   * 4.1.1.1. POST userinfo/accountinfo
   */
  @Route(pattern = "/accountinfo", allow = {POST})
  public void accountinfo(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_userinfo_accountinfo_sample).getBytes());
  }

  /**
   * 4.1.2.1. POST userinfo/headunitinfo
   */
  @Route(pattern = "/headunitinfo", allow = {POST})
  public void headunitinfo(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(null);
    res.setContent(null);
  }

  /**
   * 4.1.3.1 POST userinfo/favoritelist
   */
  @Route(pattern = "/favoritelist", allow = {POST})
  public void favoritelist(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_userinfo_responsefavoritelist_sample).getBytes());
  }

  /**
   * 4.1.3.2 GET userinfo/favoritelist/image
   */
  @Route(pattern = "/favoritelist/image/(\\w+\\.png)", allow = {GET, POST})
  public void favoritelist_image(SlHttpReq req, SlHttpRes res, Matcher matcher) throws IOException {
    if (matcher.group(1).equals("sample.png")) {
      res.setStatus(context.getString(R.string.http_code_200_ok));
      res.setHeader(null);
      res.setContentType(context.getString(R.string.http_type_image_png));
      res.setContent(Utils.getRawResource(context, R.drawable.rest_userinfo_png_sample));
    } else {
      res.setStatus(context.getString(R.string.http_code_404_not_found));
      res.setHeader(null);
      res.setContentType(null);
      res.setContent(null);
    }
  }

  /**
   * 4.1.4.1 POST userinfo/destinationinfo
   * 4.1.4.2 DELETE userinfo/destinationinfo
   */
  @Route(pattern = "/destinationinfo", allow = {POST, DELETE})
  public void destinationinfo(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    switch (req.getMethod()) {
      case POST:
        res.setStatus(context.getString(R.string.http_code_200_ok));
        res.setHeader(null);
        res.setContentType(context.getString(R.string.http_type_application_json_utf8));
        res.setContent(context.getString(R.string.rest_userinfo_destinationinfo_sample).getBytes());
        break;
      case DELETE:
        res.setStatus(context.getString(R.string.http_code_200_ok));
        res.setHeader(null);
        res.setContentType(null);
        res.setContent(null);
        break;
    }
  }

  /**
   * 4.1.5.1 POST userinfo/routeinfo
   * 4.1.5.2 DELETE userinfo/routeinfo
   */
  @Route(pattern = "/routeinfo", allow = {POST, DELETE})
  public void routeinfo(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    switch (req.getMethod()) {
      case POST:
        res.setStatus(context.getString(R.string.http_code_200_ok));
        res.setHeader(null);
        res.setContentType(null);
        res.setContent(null);
        break;
      case DELETE:
        res.setStatus(context.getString(R.string.http_code_200_ok));
        res.setHeader(null);
        res.setContentType(null);
        res.setContent(null);
        break;
    }
  }

  /**
   * 4.1.6.1 POST userinfo/routeparam
   */
  @Route(pattern = "/routeparam", allow = {POST})
  public void routeparam(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(null);
    res.setContent(null);
  }

  /**
   * 4.1.7.1 POST userinfo/homeinfo
   * 4.1.7.2 DELETE userinfo/homeinfo
   */
  @Route(pattern = "/homeinfo", allow = {POST, DELETE})
  public void homeinfo(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    switch (req.getMethod()) {
      case POST:
        res.setStatus(context.getString(R.string.http_code_200_ok));
        res.setHeader(null);
        res.setContentType(null);
        res.setContent(null);
        break;
      case DELETE:
        res.setStatus(context.getString(R.string.http_code_200_ok));
        res.setHeader(null);
        res.setContentType(null);
        res.setContent(null);
        break;
    }
  }

  /**
   * 4.1.8.1 POST userinfo/poiiconrevision
   */
  @Route(pattern = "/poiiconrevision", allow = {POST})
  public void poiiconrevision(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_userinfo_latestpoiiconrevision_sample).getBytes());
  }

  /**
   * 4.1.8.2 POST userinfo/speechiconrevision
   */
  @Route(pattern = "/speechiconrevision", allow = {POST})
  public void speechiconrevision(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_userinfo_latestspeechiconrevision_sample).getBytes());
  }

  /**
   * 4.1.8.3 GET userinfo/poiicon/{poiIconRev}/{iconname}
   */
  @Route(pattern = "/poiicon/(\\d+/\\w+\\.png)", allow = {GET, HEAD})
  public void poiicon(SlHttpReq req, SlHttpRes res, Matcher matcher) throws IOException {
    if (matcher.group(1).equals("1/sample.png")||matcher.group(1).equals("2/sample.png")) {
      res.setStatus(context.getString(R.string.http_code_200_ok));
      res.setHeader(null);
      res.setContentType(context.getString(R.string.http_type_image_png));
      res.setContent(Utils.getRawResource(context, R.drawable.rest_userinfo_png_sample));
    } else {
      res.setStatus(context.getString(R.string.http_code_404_not_found));
      res.setHeader(null);
      res.setContentType(null);
      res.setContent(null);
    }
  }

  /**
   * 4.1.8.4 GET userinfo/speechicon/{speechIconRev}/{iconname}
   */
  @Route(pattern = "/speechicon/(\\d+/\\w+\\.png)", allow = {GET, HEAD})
  public void speechicon(SlHttpReq req, SlHttpRes res, Matcher matcher) throws IOException {
    if (matcher.group(1).equals("1/sample.png")) {
      res.setStatus(context.getString(R.string.http_code_200_ok));
      res.setHeader(null);
      res.setContentType(context.getString(R.string.http_type_image_png));
      res.setContent(Utils.getRawResource(context, R.drawable.rest_userinfo_png_sample));
    } else {
      res.setStatus(context.getString(R.string.http_code_404_not_found));
      res.setHeader(null);
      res.setContentType(null);
      res.setContent(null);
    }
  }
}
