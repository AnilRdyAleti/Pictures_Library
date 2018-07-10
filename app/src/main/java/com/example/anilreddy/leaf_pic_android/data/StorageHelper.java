package com.example.anilreddy.leaf_pic_android.data;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.example.anilreddy.leaf_pic_android.R;
import com.orhanobut.hawk.Hawk;

import java.io.File;

public class StorageHelper {

    public static void saveSdCardInfo(Context context, final Uri uri) {
        Hawk.put(context.getString(R.string.preference_internal_uri_extsdcard_photos), uri == null ? null : uri.toString());
        Hawk.put("sd_card_path", StorageHelper.getSdCardPath(context));
    }

    private static Object getSdCardPath(Context context) {
        for (File file : context.getExternalFilesDirs("external")) {
            if (file != null && !file.equals(context.getExternalFilesDir("external"))) {
                int index = file.getAbsolutePath().lastIndexOf("/Android/data");
                if (index < 0)
                    Log.w("asd", "Unexpected external file dir: " + file.getAbsolutePath());
                else
                    return new File(file.getAbsolutePath().substring(0, index)).getPath();
            }
        }
        return null;
    }
}
