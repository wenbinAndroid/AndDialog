package com.github.mrz.dialog.tips;

import android.annotation.SuppressLint;
import android.app.Activity;

import com.github.mrz.dialog.R;
import com.github.mrz.dialog.base.BaseDialog;
import com.github.mrz.dialog.data.DialogData;


/**
 * 作者 mrz
 * 创建时间  2018/7/5 10:40
 */

@SuppressLint("ValidFragment")
public class TipsDialog extends BaseDialog<TipsRequest> implements TipsRequest {


    public TipsDialog(Activity activity, DialogData.Type type) {
        super(activity, type);
        request = this;
    }

    @Override
    public TipsRequest listener(OnTipsDialogListener listener) {
        this.mOnTipsDialogListener = listener;
        return this;
    }


    @Override
    public TipsRequest title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public TipsRequest btnColor(int color) {
        this.tipsButtonTextColor = color;
        return this;
    }

    @Override
    public TipsRequest btnText(String text) {
        this.rightBtnText = text;
        return this;
    }

    @Override
    public TipsRequest message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public TipsRequest messageColor(int color) {
        this.messageColor = color;
        return this;
    }

    @Override
    public TipsRequest titleColor(int color) {
        this.titleColor = color;
        return this;
    }

    @Override
    public TipsRequest normal(OnTipsDialogListener listener) {
        normal(listener, R.layout.dialog_common_tips);
        return this;
    }

    @Override
    public TipsRequest normal(OnTipsDialogListener listener, int layout) {
        listener(listener).layout(layout);
        return this;
    }
}
