package com.example.anilreddy.leaf_pic_android.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.anilreddy.leaf_pic_android.BuildConfig;

public class ApplicationUtils {

    private static String PACKAGE_NAME;

    public static void init(@NonNull Context context) {
        PACKAGE_NAME = context.getPackageName();
    }

    @NonNull
    public static String getPackageName() {
        return PACKAGE_NAME;
    }

    @NonNull
    public static String getAppVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

}
