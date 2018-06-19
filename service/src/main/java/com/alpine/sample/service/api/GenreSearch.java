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
 * 4.3. ユーザ操作ジャンル検索
 */
@Keep
public final class GenreSearch {
  private final Context context;

  public GenreSearch(Context context) {
    this.context = context;
  }

  /**
   * 4.3.1.1 POST genresearch/genrelist
   */
  @Route(pattern = "/genrelist", allow = {POST})
  public void genrelist(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_genresearch_genresearchlist_sample).getBytes());
  }

  /**
   * 4.3.2.1 POST genresearch/start
   */
  @Route(pattern = "/start", allow = {POST})
  public void start(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_genresearch_sessioninfo_sample).getBytes());
  }

  /**
   * 4.3.3.1 POST genresearch/result
   */
  @Route(pattern = "/result", allow = {POST})
  public void result(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_genresearch_responsesearchresult_sample).getBytes());
  }

  /**
   * 4.3.6.1 POST genresearch/listsort
   */
  @Route(pattern = "/listsort", allow = {POST})
  public void listsort(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_genresearch_sessioninfo_sample).getBytes());
  }

  /**
   * 4.3.7.1 POST genresearch/end
   */
  @Route(pattern = "/end", allow = {POST})
  public void end(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(null);
    res.setContent(null);
  }
}
