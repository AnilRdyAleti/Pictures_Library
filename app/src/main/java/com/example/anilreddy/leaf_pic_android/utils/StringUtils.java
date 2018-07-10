package com.example.anilreddy.leaf_pic_android.utils;

import android.content.Context;
import android.widget.Toast;

public class StringUtils {
    public static void showToast(Context x, String s) {
        Toast toast = Toast.makeText(x, s, Toast.LENGTH_SHORT);
        toast.show();
    }
}
