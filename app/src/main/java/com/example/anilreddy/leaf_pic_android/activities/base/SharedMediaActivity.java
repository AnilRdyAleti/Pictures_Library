package com.example.anilreddy.leaf_pic_android.activities.base;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.anilreddy.leaf_pic_android.R;
import com.example.anilreddy.leaf_pic_android.data.StorageHelper;
import com.example.anilreddy.leaf_pic_android.utils.AlertDialogsHelper;

public abstract class SharedMediaActivity extends BaseActivity {

    private int REQUEST_CODE_SD_CARD_PERMISSIONS = 42;

    public void requestSdCardPermissions() {
        AlertDialog textDialog = AlertDialogsHelper
                .getTextDialog(this, R.string.sd_card_write_permission_title, R.string.sd_card_permissions_message);
        textDialog.setButton(DialogInterface.BUTTON_POSITIVE,
                getString(R.string.ok_action).toUpperCase(), (dialogInterface, i) -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        startActivityForResult(new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE), REQUEST_CODE_SD_CARD_PERMISSIONS);
                    }
                });
        textDialog.show();
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent resultData) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_SD_CARD_PERMISSIONS) {
                Uri treeUri = resultData.getData();

                StorageHelper.saveSdCardInfo(getApplicationContext(), treeUri);
                getContentResolver().takePersistableUriPermission(treeUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                Toast.makeText(this, R.string.got_permission_wr_sdcard, Toast.LENGTH_SHORT).show();
            }
        }

        super.onActivityResult(requestCode, resultCode, resultData);
    }

}
