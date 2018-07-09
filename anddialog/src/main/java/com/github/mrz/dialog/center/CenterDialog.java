package com.github.mrz.dialog.center;

import android.annotation.SuppressLint;
import android.app.Activity;

import com.github.mrz.dialog.base.BaseDialog;
import com.github.mrz.dialog.data.DialogData;

/**
 * by mrz
 * date  2018/7/9 10:16
 */

@SuppressLint("ValidFragment")
public class CenterDialog extends BaseDialog<CenterRequest> implements CenterRequest {


    public CenterDialog(Activity activity, DialogData.Type type) {
        super(activity, type);
        request = this;
    }

    @Override
    public CenterRequest listener(OnCenterDialogListener listener) {
        this.mOnCenterDialogListener = listener;
        return this;
    }

    @Override
    public CenterRequest normal(OnCenterDialogListener listener, int res) {
        listener(listener).animation
                (DialogData.ANIMATION_FROM_CENTER_TO_CENTER)
                .layout(res);
        return this;
    }
}
