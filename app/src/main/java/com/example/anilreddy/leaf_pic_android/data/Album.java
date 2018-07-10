package com.example.anilreddy.leaf_pic_android.data;

import android.os.Parcelable;

public class Album implements CursorHandler, Parcelable {

    public static final long ALL_MEDIA_ALBUM_ID = 8000;
    private String name, path;
    private long id = -1, dateModified;
    private int count = -1;

    private boolean selected = false;
    public AlbumSettings settings = null;
    private Media lastMedia = null;


}
