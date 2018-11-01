package com.github.mrz.dialog.request;

import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.BaseDialog;

/**
 * @author Mrz
 * @date 2018/10/29 14:15
 */
public abstract class CommonRequest<T> extends Request<T> {

    protected T t;

    public CommonRequest(AppCompatActivity activity) {
        super(activity);
        t = createRqeust();

    }

    abstract T createRqeust();

    @Override
    public T setTheme(int theme) {
        mBuilder.theme = theme;
        return t;
    }

    @Override
    public T setCancelable(boolean cancelable) {
        mBuilder.isCancelable = cancelable;
        return t;
    }

    @Override
    public T setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        mBuilder.isCancelabledOnTouchOutside = canceledOnTouchOutside;
        return t;
    }

    @Override
    public T setWidth(float width) {
        mBuilder.width = width;
        return t;
    }

    @Override
    public T setLayout(int layout) {
        mBuilder.layout = layout;
        return t;
    }

    @Override
    public T requestCode(int code) {
        mBuilder.requestCode = code;
        return t;
    }

    @Override
    public void setAnimation(int animation) {
        mBuilder.animation = animation;
    }

    @Override
    public void show() {
        new BaseDialog(mBuilder).show(mBuilder.mActivity.get().getSupportFragmentManager(), "");
    }

}
