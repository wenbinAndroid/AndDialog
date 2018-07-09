package com.github.mrz.dialog.bottom;

import com.github.mrz.dialog.base.BaseDialog;
import com.github.mrz.dialog.base.Request;

/**
 * by mrz
 * date  2018/7/5 10:42
 */

public interface BottomRequest extends Request<BottomRequest> {

    BottomRequest listener(BaseDialog.OnBottomDialogLister lister);

    BottomRequest normal(BaseDialog.OnBottomDialogLister lister, int layout);



}
