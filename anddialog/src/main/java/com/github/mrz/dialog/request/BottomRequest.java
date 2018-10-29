package com.github.mrz.dialog.request;

import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.listener.OnDialogListner;
import com.github.mrz.dialog.type.DialogType;

/**
 * @author Mrz
 * @date 2018/10/29 13:56
 */
public class BottomRequest extends CommonRequest<BottomRequest> {


    public BottomRequest(AppCompatActivity activity) {
        super(activity);
        this.mBuilder.mDialogType = DialogType.BOTTOM;
    }

    @Override
    BottomRequest createRqeust() {
        return this;
    }

    public BottomRequest setBottomListener(OnDialogListner listener) {
        mBuilder.mOnDialogListner = listener;
        return this;
    }


}
