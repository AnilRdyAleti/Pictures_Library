package com.example.anilreddy.leaf_pic_android.utils.peferences;

import android.support.annotation.NonNull;

public class Prefs {

    private static SharedPrefs sharedPrefs;

    public static boolean timelineEnabled() {
        return !getPrefs().get(Keys.ANIMATIONS_DISABLED, Defaults.ANIMATIONS_DISABLED);
    }

    @NonNull
    private static SharedPrefs getPrefs() {
        if (sharedPrefs == null) {
            throw new RuntimeException("Prefs has not been instantiated. Call init() with context");
        }
        return sharedPrefs;
    }
}
