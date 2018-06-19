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
import static jp.co.aicp.sl.api.SlHttpMethod.PUT;

/**
 * 4.2. 音声認識施設検索
 */
@Keep
public final class SpeechRecSearch {
  private final Context context;

  public SpeechRecSearch(Context context) {
    this.context = context;
  }

  /**
   * 4.2.1.1 POST speechrecsearch/start
   */
  @Route(pattern = "/start", allow = {POST})
  public void start(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_speechrecsearch_startinfo_sample).getBytes());
  }

  /**
   * 4.2.2.1 POST speechrecsearch/startnarrow
   */
  @Route(pattern = "/startnarrow", allow = {POST})
  public void startnarrow(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_speechrecsearch_sessioninfo_sample).getBytes());
  }

  /**
   * 4.2.3.1 POST speechrecsearch/voices
   */
  @Route(pattern = "/voices", allow = {PUT})
  public void voices(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_speechrecsearch_recognitioninfo_sample).getBytes());
  }

  /**
   * 4.2.4.1 POST speechrecsearch/voicesstop
   */
  @Route(pattern = "/voicesstop", allow = {POST})
  public void voicesstop(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_speechrecsearch_sessioninfo_sample).getBytes());
  }

  /**
   * 4.2.5.1 POST speechrecsearch/end
   */
  @Route(pattern = "/end", allow = {POST})
  public void end(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(null);
    res.setContent(null);
  }

  /**
   * 4.2.6.1 POST speechrecsearch/result
   */
  @Route(pattern = "/result", allow = {POST})
  public void result(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_speechrecsearch_responseresult_sample).getBytes());
  }

  /**
   * 4.2.9.1 POST speechrecsearch/listsort
   */
  @Route(pattern = "/listsort", allow = {POST})
  public void listsort(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_speechrecsearch_sessioninfo_sample).getBytes());
  }

  /**
   * 4.2.10.1 POST speechrecsearch/back
   */
  @Route(pattern = "/back", allow = {POST})
  public void back(SlHttpReq req, SlHttpRes res, Matcher matcher) {
    res.setStatus(context.getString(R.string.http_code_200_ok));
    res.setHeader(null);
    res.setContentType(context.getString(R.string.http_type_application_json_utf8));
    res.setContent(context.getString(R.string.rest_speechrecsearch_sessioninfo_sample).getBytes());
  }
}
