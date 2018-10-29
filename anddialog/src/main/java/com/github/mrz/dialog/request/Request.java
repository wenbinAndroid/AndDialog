package com.github.mrz.dialog.request;

import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.listener.CheckLeftListener;
import com.github.mrz.dialog.listener.CheckRightListener;
import com.github.mrz.dialog.listener.OnDialogListner;
import com.github.mrz.dialog.listener.TipsListener;
import com.github.mrz.dialog.type.DialogType;

/**
 * @author Mrz
 * @date 2018/10/29 13:54
 */
public abstract class Request<T> {


    protected Builder mBuilder;

    public Request(AppCompatActivity activity) {
        mBuilder = new Builder();
        mBuilder.mActivity = activity;
    }

    public abstract T setTheme(int theme);

    public abstract T setCancelable(boolean cancelable);

    public abstract T setCanceledOnTouchOutside(boolean canceledOnTouchOutside);

    public abstract T setWidth(float width);

    public abstract T setLayout(int layout);

    public abstract void show();

    public abstract void setAnimation(int animation);

    public abstract T requestCode(int code);

    protected void dissmissCallback() {

    }

    public static class Builder {
        //common
        public int theme;
        public AppCompatActivity mActivity;
        public boolean isCancelable = true;
        public boolean isCancelabledOnTouchOutside;
        public float width = 0.8f;
        public int layout;
        public int requestCode;
        public int animation;
        public String title;
        public int tvTitleId;
        public boolean isTitleVisable;
        //check
        public String leftText;
        public int leftBtnID;
        public CheckLeftListener mCheckLeftListener;
        public String rightText;
        public int rightBtnID;
        public CheckRightListener mCheckRightListener;
        public DialogType mDialogType;
        public String content;
        public int tvContentID;

        //tips
        public String tipsBtnText;
        public int tipsBtnID;
        public TipsListener mTipsListener;

        //bottom  top center
        public OnDialogListner mOnDialogListner;
    }
}
