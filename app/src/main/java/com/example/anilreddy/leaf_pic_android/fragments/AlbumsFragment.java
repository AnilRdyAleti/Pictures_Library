package com.example.anilreddy.leaf_pic_android.fragments;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.anilreddy.leaf_pic_android.R;
import com.example.anilreddy.leaf_pic_android.adapters.AlbumsAdapter;

import java.util.ArrayList;

import butterknife.BindView;

public abstract class AlbumsFragment extends BaseMediaGridFragment {
    public static final String TAG = "AlbumsFragment";

    @BindView(R.id.albums)
    RecyclerView rv;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout refresh;

    private AlbumsAdapter adapter;
//    private GridSpacingItemDecoration spacingDecoration;
//    private AlbumClickListener listener;

    private boolean hidden = false;
    ArrayList<String> excuded = new ArrayList<>();
}
