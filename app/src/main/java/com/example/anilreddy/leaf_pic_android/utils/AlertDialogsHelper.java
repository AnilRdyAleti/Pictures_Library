package com.example.anilreddy.leaf_pic_android.utils;

import android.graphics.PorterDuff;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.anilreddy.leaf_pic_android.R;

import org.horaapps.liz.ThemeHelper;
import org.horaapps.liz.ThemedActivity;

import java.lang.reflect.Field;

public class AlertDialogsHelper {

    public static AlertDialog getInsertTextDialog(ThemedActivity activity, EditText editText, @StringRes int title) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity, activity.getDialogStyle());
        View dialogLayout = activity.getLayoutInflater().inflate(R.layout.dialog_insert_text, null);
        TextView textViewTitle = dialogLayout.findViewById(R.id.rename_title);

        ((CardView) dialogLayout.findViewById(R.id.dialog_chose_provider_title)).setCardBackgroundColor(activity.getCardBackgroundColor());
        textViewTitle.setBackgroundColor(activity.getPrimaryColor());
        textViewTitle.setText(title);
        ThemeHelper.setCursorColor(editText, activity.getTextColor());

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        editText.setLayoutParams(layoutParams);
        editText.setSingleLine(true);
        editText.getBackground().mutate().setColorFilter(activity.getTextColor(), PorterDuff.Mode.SRC_IN);
        editText.setTextColor(activity.getTextColor());

        try {
            Field f = TextView.class.getDeclaredField("mCursorDrawableRes");
            f.setAccessible(true);
            f.set(editText, null);
        } catch (Exception ignored) {
        }

        ((RelativeLayout) dialogLayout.findViewById(R.id.container_edit_text)).addView(editText);

        dialogBuilder.setView(dialogLayout);
        return dialogBuilder.create();
    }

    public static AlertDialog getTextDialog(ThemedActivity activity, @StringRes int title, @StringRes int Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, activity.getDialogStyle());
        View dialogLayout = activity.getLayoutInflater().inflate(R.layout.dialog_text, null);

        TextView dialogTitle = dialogLayout.findViewById(R.id.text_dialog_title);
        TextView dialogMessage = dialogLayout.findViewById(R.id.text_dialog_message);

        ((CardView) dialogLayout.findViewById(R.id.message_card)).setCardBackgroundColor(activity.getCardBackgroundColor());
        dialogTitle.setBackgroundColor(activity.getPrimaryColor());
        dialogTitle.setText(title);
        dialogMessage.setText(Message);
        dialogMessage.setTextColor(activity.getTextColor());
        builder.setView(dialogLayout);
        return builder.create();
    }

}
