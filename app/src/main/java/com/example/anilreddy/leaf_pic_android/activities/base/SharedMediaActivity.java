package com.example.anilreddy.leaf_pic_android.activities.base;

import android.support.v7.app.AlertDialog;

import com.example.anilreddy.leaf_pic_android.R;
import com.example.anilreddy.leaf_pic_android.utils.AlertDialogsHelper;

public abstract class SharedMediaActivity extends BaseActivity {

    private int REQUEST_CODE_SD_CARD_PERMISSIONS = 42;

    public void requestSdCardPermissions() {
        AlertDialog textDialog = AlertDialogsHelper.getTextDialog(this, R.string.sd_card_write_permission_title, R.string.sd_card_permissions_message);
    }
}
