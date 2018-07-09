package com.github.mrz.dialog.check;

import com.github.mrz.dialog.base.BaseDialog;
import com.github.mrz.dialog.base.Request;

/**
 * by mrz
 * date  2018/7/5 10:42
 */

public interface CheckRequest extends Request<CheckRequest> {

    CheckRequest listener(BaseDialog.OnCheckDialogListener listener);

    CheckRequest title(String title);

    CheckRequest message(String message);

    CheckRequest leftBtnText(String text);

    CheckRequest rightBtnText(String text);

    CheckRequest visibleTitle(boolean show);

    CheckRequest leftBtnTextColor(int color);

    CheckRequest rightBtnTextColor(int color);

    CheckRequest messageColor(int color);

    CheckRequest titleColor(int color);

    CheckRequest normal(BaseDialog.OnCheckDialogListener listener);

    CheckRequest normal(BaseDialog.OnCheckDialogListener listener, int layout);

}
