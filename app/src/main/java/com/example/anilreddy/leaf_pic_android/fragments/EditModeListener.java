package com.example.anilreddy.leaf_pic_android.fragments;

import android.support.annotation.Nullable;
import android.view.View;

public interface EditModeListener {

    void changedEditMode(boolean editMode, int selected, int total, @Nullable View.OnClickListener listener, @Nullable String title);

    void onItemSelected(int count, int total);
}
