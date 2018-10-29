package com.github.mrz.dialog;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.request.AndDialogRequest;
import com.github.mrz.dialog.request.BottomRequest;
import com.github.mrz.dialog.request.CenterRequest;
import com.github.mrz.dialog.request.CheckRequest;
import com.github.mrz.dialog.request.TipsRequest;

/**
 * @author Mrz
 * @date 2018/10/29 13:54
 */
public class AndDialog implements AndDialogRequest {

    private AppCompatActivity mActivity;

    private AndDialog(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    public static AndDialog with(Fragment fragment) {
        return new AndDialog((AppCompatActivity) fragment.getActivity());
    }

    public static AndDialog with(AppCompatActivity activity) {
        return new AndDialog(activity);
    }

    @Override
    public BottomRequest bottom() {
        return new BottomRequest(mActivity);
    }

    @Override
    public CheckRequest check() {
        return new CheckRequest(mActivity);
    }

    @Override
    public TipsRequest tips() {
        return new TipsRequest(mActivity);
    }

    @Override
    public CenterRequest center() {
        return new CenterRequest(mActivity);
    }
}
