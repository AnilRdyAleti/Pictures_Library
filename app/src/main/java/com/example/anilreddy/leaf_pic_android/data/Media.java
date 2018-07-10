package com.example.anilreddy.leaf_pic_android.data;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.anilreddy.leaf_pic_android.timeline.data.TimelineItem;

public class Media implements TimelineItem, CursorHandler,Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    @Override
    public Object handle(Cursor cu) {
        return null;
    }
}
