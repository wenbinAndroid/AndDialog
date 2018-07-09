package com.github.mrz.dialog.bottom;

import android.annotation.SuppressLint;
import android.app.Activity;

import com.github.mrz.dialog.base.BaseDialog;
import com.github.mrz.dialog.data.DialogData;

/**
 * by mrz
 * date  2018/7/5 10:40
 */

@SuppressLint("ValidFragment")
public class BottomDialog extends BaseDialog<BottomRequest> implements BottomRequest {


    public BottomDialog(Activity activity, DialogData.Type type) {
        super(activity, type);
        request = this;
    }

    @Override
    public BottomRequest listener(OnBottomDialogLister lister) {
        this.mOnBottomDialogLister = lister;
        return this;
    }


    @Override
    public BottomRequest normal(OnBottomDialogLister lister, int layout) {
        listener(lister).animation
                (DialogData.ANIMATION_FROM_BOTTOM_TO_BOTTOM)
                .layout(layout);
        return this;
    }

}
