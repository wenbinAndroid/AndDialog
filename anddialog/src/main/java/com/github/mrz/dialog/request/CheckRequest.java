package com.github.mrz.dialog.request;

import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.listener.CheckLeftListener;
import com.github.mrz.dialog.listener.CheckRightListener;
import com.github.mrz.dialog.type.DialogType;

/**
 * @author Mrz
 * @date 2018/10/29 13:57
 */
public class CheckRequest extends CommonRequest<CheckRequest> {


    public CheckRequest(AppCompatActivity activity) {
        super(activity);
        this.mBuilder.mDialogType = DialogType.CHECK;
    }

    @Override
    CheckRequest createRqeust() {
        return this;
    }


    public CheckRequest setContent(int id, String text) {
        mBuilder.tvContentID = id;
        mBuilder.content = text;
        return this;
    }


    public CheckRequest setTitle(int id, String text) {
        mBuilder.title = text;
        mBuilder.tvTitleId = id;
        mBuilder.isTitleVisable = true;
        return this;
    }


    public CheckRequest setLeftText(int id, String text, CheckLeftListener listener) {
        mBuilder.leftBtnID = id;
        mBuilder.leftText = text;
        mBuilder.mCheckLeftListener = listener;
        return this;
    }


    public CheckRequest setRightText(int id, String text, CheckRightListener listener) {
        mBuilder.rightBtnID = id;
        mBuilder.rightText = text;
        mBuilder.mCheckRightListener = listener;
        return this;
    }

}
