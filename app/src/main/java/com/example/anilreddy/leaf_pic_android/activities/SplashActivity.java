package com.example.anilreddy.leaf_pic_android.activities;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.anilreddy.leaf_pic_android.R;
import com.example.anilreddy.leaf_pic_android.utils.PermissionUtils;
import com.example.anilreddy.leaf_pic_android.utils.StringUtils;

import java.io.File;

public class SplashActivity extends AppCompatActivity {
    private final String TAG = SplashActivity.class.getSimpleName();

    private final int EXTERNAL_STORAGE_PERMISSIONS = 12;
    private static final int PICK_MEDIA_REQUEST = 44;

    final static String CONTENT = "content";

    final static int ALBUMS_PREFETCHED = 2376;
    final static int PHOTOS_PREFETCHED = 2567;
    final static int ALBUMS_BACKUP = 1312;
    private boolean pickMode = false;
    public final static String ACTION_OPEN_ALBUM = "org.horaapps.leafpic.OPEN_ALBUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

//        setNavBarColor();
//        setStatusBarColor();

        String action = getIntent().getAction();

        if (action != null) {
            pickMode = action.equals(Intent.ACTION_GET_CONTENT) || action.equals(Intent.ACTION_PICK);
        }

        if (PermissionUtils.isStoragePermissionGranted(this)) {
            if (action != null && action.equals(ACTION_OPEN_ALBUM)) {
                Bundle data = getIntent().getExtras();
                if (data != null) {
                    String ab = data.getString("albumPath");
                    if (ab != null) {
                        File dir = new File(ab);
                        start();
                    }
                } else StringUtils.showToast(getApplicationContext(), "Album not found");
            } else {
                start();
            }
        } else {
            PermissionUtils.requestPermissions(this,
                    EXTERNAL_STORAGE_PERMISSIONS, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }

    private void start() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);

        if (pickMode) {
            intent.putExtra(MainActivity.ARGS_PICK_MODE, true);
            startActivityForResult(intent, PICK_MEDIA_REQUEST);
        } else {
            startActivity(intent);
            finish();
        }
    }
}
