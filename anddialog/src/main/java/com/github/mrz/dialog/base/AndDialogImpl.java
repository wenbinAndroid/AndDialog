package com.github.mrz.dialog.base;

import com.github.mrz.dialog.bottom.BottomRequest;
import com.github.mrz.dialog.center.CenterRequest;
import com.github.mrz.dialog.check.CheckRequest;
import com.github.mrz.dialog.tips.TipsRequest;

/**
 * by mrz
 * date  2018/7/9 10:21
 */

public interface AndDialogImpl {
    BottomRequest bottom();

    CheckRequest check();

    TipsRequest tips();

    CenterRequest center();
}
