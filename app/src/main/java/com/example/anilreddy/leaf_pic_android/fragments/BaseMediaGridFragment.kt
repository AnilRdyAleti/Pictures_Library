package com.example.anilreddy.leaf_pic_android.fragments

import android.content.Context
import android.view.View
import com.example.anilreddy.leaf_pic_android.items.ActionsListener

abstract class BaseMediaGridFragment : BaseFragment(), IFragment, ActionsListener {

    lateinit var editModeListener: EditModeListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is EditModeListener) editModeListener = context
        else throw  RuntimeException("Parent must implement Edit Mode Listener!")
    }

    fun onBackPressed() = when (editMode()) {
        true -> {
            exitContextMenu()
            true
        }
        false -> false
    }

    protected fun exitContextMenu() {
        clearSelected()
        updateToolbar()
    }

    protected fun updateToolbar() {
        editModeListener.changedEditMode(
                editMode(),
                getSelectedCount(),
                getTotalCount(),
                getToolbarButtonListener(editMode()),
                getToolbarTitle())

        activity?.invalidateOptionsMenu()
    }

    abstract fun getToolbarTitle(): String?

    abstract fun getToolbarButtonListener(editMode: Boolean): View.OnClickListener?

    abstract fun getTotalCount(): Int

    abstract fun getSelectedCount(): Int


}