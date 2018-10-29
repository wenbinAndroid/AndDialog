package com.github.mrz.dialog.listener;

import android.support.v4.app.DialogFragment;
import android.view.View;

/**
 * @author Mrz
 * @date 2018/10/29 14:04
 */
public interface OnDialogListner {

    void onDialogAction(DialogFragment dialogFragment, View view, int code);
}
