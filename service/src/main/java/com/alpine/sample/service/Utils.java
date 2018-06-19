/*
 * Copyright (C) 2018 A.I.Corporation, All Rights Reserved
 */
package com.alpine.sample.service;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.RawRes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class Utils {
    private Utils() {
    }

    @NonNull
    public static String join(@NonNull Object objects[]) {
        StringBuilder builder = new StringBuilder();
        String delimiter = "";
        for (Object object : objects) {
            builder.append(delimiter).append(object);
            delimiter = ", ";
        }
        return builder.toString();
    }

    public static void forwardStream(@NonNull InputStream is, @NonNull OutputStream os) throws IOException {
        byte[] buffer = new byte[1024];
        int length;
        while (0 < (length = is.read(buffer, 0, buffer.length))) {
            os.write(buffer, 0, length);
        }
    }

    @NonNull
    public static byte[] getRawResource(@NonNull Context context, @RawRes @DrawableRes int id) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = context.getResources().openRawResource(id);
        try {
            forwardStream(is, baos);
        } finally {
            is.close();
        }
        return baos.toByteArray();
    }
}
