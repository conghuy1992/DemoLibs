/*
 * Copyright (C) 2018 A.I.Corporation, All Rights Reserved
 */
package com.alpine.sample.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jp.co.aicp.sl.api.SlHttpMethod;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Route {
  String pattern();
  SlHttpMethod[] allow();
}
