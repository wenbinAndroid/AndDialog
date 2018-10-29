package com.github.mrz.dialog.request;

import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.listener.OnDialogListner;
import com.github.mrz.dialog.type.DialogType;

/**
 * @author Mrz
 * @date 2018/10/29 13:57
 */
public class TopRequest extends CommonRequest<TopRequest> {
    public TopRequest(AppCompatActivity activity) {
        super(activity);
        this.mBuilder.mDialogType = DialogType.TOP;
    }

    @Override
    TopRequest createRqeust() {
        return this;
    }

    TopRequest setTopListener(OnDialogListner listener) {
        mBuilder.mOnDialogListner = listener;
        return this;
    }

}
