package com.example.anilreddy.leaf_pic_android.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.anilreddy.leaf_pic_android.R;
import com.example.anilreddy.leaf_pic_android.fragments.AlbumsFragment;
import com.example.anilreddy.leaf_pic_android.view.navigation_drawer.NavigationDrawer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    public static final String ARGS_PICK_MODE = "pick_mode";

    private static final String SAVE_FRAGMENT_MODE = "fragment_mode";

    public @interface FragmentMode {
        int MODE_ALBUMS = 1001;
        int MODE_MEDIA = 1002;
        int MODE_TIMELINE = 1003;
    }

    @BindView(R.id.fab_camera)
    FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    DrawerLayout navigationDrawer;
    @BindView(R.id.home_navigation_drawer)
    NavigationDrawer navigationDrawerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.coordinator_main_layout)
    CoordinatorLayout mainLayout;

    private AlbumsFragment albumsFragment;
//    private RvMediaFragment rvMediaFragment;
//    private TimelineFragment timelineFragment;

    private boolean pickMode = false;
    private Unbinder unbinder;

    @FragmentMode
    private int fragmentMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        initUi();
    }

    public void initUi() {
        setSupportActionBar(toolbar);
//        setupNavigationDrawer();
//        setupFAB();
    }
}
