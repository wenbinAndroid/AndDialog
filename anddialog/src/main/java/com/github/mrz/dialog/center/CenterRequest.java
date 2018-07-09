package com.github.mrz.dialog.center;

import com.github.mrz.dialog.base.BaseDialog;
import com.github.mrz.dialog.base.Request;

/**
 * by mrz
 * date  2018/7/9 10:12
 */

public interface CenterRequest extends Request<CenterRequest> {

    CenterRequest listener(BaseDialog.OnCenterDialogListener listener);

    CenterRequest normal(BaseDialog.OnCenterDialogListener listener, int res);
}
