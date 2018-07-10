package com.example.anilreddy.leaf_pic_android.adapters;

import android.graphics.drawable.Drawable;

import com.example.anilreddy.leaf_pic_android.data.Album;
import com.example.anilreddy.leaf_pic_android.data.sort.SortingMode;
import com.example.anilreddy.leaf_pic_android.data.sort.SortingOrder;
import com.example.anilreddy.leaf_pic_android.items.ActionsListener;
import com.example.anilreddy.leaf_pic_android.view.CardViewStyle;

import org.horaapps.liz.ThemedAdapter;

import java.util.List;

public class AlbumsAdapter extends ThemedAdapter<AlbumsAdapter.ViewHolder> {

    private List<Album> albums;

    private int selectedCount = 0;

    private SortingOrder sortingOrder;
    private SortingMode sortingMode;

    private Drawable placeholder;
    private CardViewStyle cardViewStyle;

    private ActionsListener actionsListener;
    private boolean isSelecting;


}
