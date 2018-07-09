package com.github.mrz.dialog;

import android.app.Activity;
import android.app.Fragment;

import com.github.mrz.dialog.base.AndDialogImpl;
import com.github.mrz.dialog.bottom.BottomDialog;
import com.github.mrz.dialog.bottom.BottomRequest;
import com.github.mrz.dialog.center.CenterDialog;
import com.github.mrz.dialog.center.CenterRequest;
import com.github.mrz.dialog.check.CheckDialog;
import com.github.mrz.dialog.check.CheckRequest;
import com.github.mrz.dialog.data.DialogData;
import com.github.mrz.dialog.tips.TipsDialog;
import com.github.mrz.dialog.tips.TipsRequest;

import java.lang.ref.WeakReference;

/**
 * by mrz
 * date  2018/6/14 16:01
 */

public class AndDialog implements AndDialogImpl {

    private static WeakReference<Activity> mActivityWeakReference;
    private static AndDialog mInstant;

    public static AndDialog with(Activity activity) {
        if (mInstant == null) {
            synchronized (AndDialog.class) {
                if (mInstant == null) {
                    mInstant = new AndDialog();
                }
            }
        }
        mActivityWeakReference = new WeakReference<Activity>(activity);
        return mInstant;
    }


    public static AndDialog with(Fragment fragment) {
        return with(fragment.getActivity());
    }

    /**
     * 设置共用动画
     *
     * @param location  位置
     * @param animation 动画
     */
    protected static void common(int location, int animation) {


    }

    @Override
    public BottomRequest bottom() {
        return new BottomDialog(mActivityWeakReference.get(), DialogData.Type.bottom);
    }

    @Override
    public CheckRequest check() {
        return new CheckDialog(mActivityWeakReference.get(), DialogData.Type.center);
    }

    @Override
    public TipsRequest tips() {
        return new TipsDialog(mActivityWeakReference.get(), DialogData.Type.center);
    }

    @Override
    public CenterRequest center() {
        return new CenterDialog(mActivityWeakReference.get(), DialogData.Type.center);
    }


}
