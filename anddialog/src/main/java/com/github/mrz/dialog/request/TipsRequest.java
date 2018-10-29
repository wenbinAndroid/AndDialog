package com.github.mrz.dialog.request;

import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.listener.TipsListener;
import com.github.mrz.dialog.type.DialogType;

/**
 * @author Mrz
 * @date 2018/10/29 15:13
 */
public class TipsRequest extends CommonRequest<TipsRequest> {

    public TipsRequest(AppCompatActivity activity) {
        super(activity);
        this.mBuilder.mDialogType = DialogType.TIPS;
    }

    @Override
    TipsRequest createRqeust() {
        return this;
    }

    public TipsRequest setTitle(int id, String text) {
        mBuilder.title = text;
        mBuilder.tvTitleId = id;
        mBuilder.isTitleVisable = true;
        return this;
    }

    public TipsRequest setTipsContent(int id, String content) {
        mBuilder.tvContentID = id;
        mBuilder.content = content;
        return this;
    }


    public TipsRequest setTipsBtnText(int id, String content, TipsListener listener) {
        mBuilder.tipsBtnText = content;
        mBuilder.tipsBtnID = id;
        mBuilder.mTipsListener = listener;
        return this;
    }
}
