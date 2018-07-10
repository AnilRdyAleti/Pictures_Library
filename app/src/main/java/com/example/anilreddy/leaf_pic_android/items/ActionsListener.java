package com.example.anilreddy.leaf_pic_android.items;

public interface ActionsListener {

    void onItemSelected(int position);

    void onSelectMode(boolean selectMode);

    void onSelectionCountChanged(int selectionCount, int totalCount);
}
