package com.example.myapplication;

import com.google.gson.GsonBuilder;

public class GsonUtil {
    private static final GsonUtil GSON_UTIL = new GsonUtil();

    public GsonUtil() {
    }

    public static GsonUtil getInstance() {
        return GSON_UTIL;
    }

    public GsonBuilder buildGson() {
        return (new GsonBuilder()).setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'");
    }
}
