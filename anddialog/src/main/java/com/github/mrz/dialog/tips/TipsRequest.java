package com.github.mrz.dialog.tips;

import com.github.mrz.dialog.base.BaseDialog;
import com.github.mrz.dialog.base.Request;

/**
 * 作者 mrz
 * 创建时间  2018/7/5 10:42
 */

public interface TipsRequest extends Request<TipsRequest> {
    TipsRequest listener(BaseDialog.OnTipsDialogListener listener);

    TipsRequest title(String title);

    TipsRequest btnColor(int color);

    TipsRequest btnText(String text);

    TipsRequest message(String message);

    TipsRequest messageColor(int color);

    TipsRequest titleColor(int color);


    TipsRequest normal(BaseDialog.OnTipsDialogListener listener);

    TipsRequest normal(BaseDialog.OnTipsDialogListener listener, int layout);
}
