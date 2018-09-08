package com.github.mrz.dialog.check;

import android.annotation.SuppressLint;
import android.app.Activity;

import com.github.mrz.dialog.R;
import com.github.mrz.dialog.base.BaseDialog;
import com.github.mrz.dialog.data.DialogData;


/**
 * by mrz
 * date  2018/7/5 10:39
 */

@SuppressLint("ValidFragment")
public class CheckDialog extends BaseDialog<CheckRequest> implements CheckRequest {


    public CheckDialog(Activity activity, DialogData.Type type) {
        super(activity, type);
        request = this;
    }

    @Override
    public CheckRequest listener(OnCheckDialogListener listener) {
        this.mOnCheckDialogListener = listener;
        return this;
    }


    @Override
    public CheckRequest title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public CheckRequest message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public CheckRequest leftBtnText(String text) {
        this.leftBtnText = text;
        return this;
    }

    @Override
    public CheckRequest rightBtnText(String text) {
        this.rightBtnText = text;
        return this;
    }

    @Override
    public CheckRequest visibleTitle(boolean show) {
        this.isShowTitle = show;
        return this;
    }

    @Override
    public CheckRequest leftBtnTextColor(int color) {
        this.leftTextColor = color;
        return this;
    }

    @Override
    public CheckRequest rightBtnTextColor(int color) {
        this.rightTextColor = color;
        return this;
    }

    @Override
    public CheckRequest messageColor(int color) {
        this.messageColor = color;
        return this;
    }

    @Override
    public CheckRequest titleColor(int color) {
        this.titleColor = color;
        return this;
    }

    @Override
    public CheckRequest normal(OnCheckDialogListener listener) {
        return normal(listener, R.layout.dialog_common_check);
    }

    @Override
    public CheckRequest normal(OnCheckDialogListener listener, int layout) {
        listener(listener)
                .layout(layout);
        return this;
    }

}
