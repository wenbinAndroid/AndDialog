package com.github.mrz.dialog.base;

import android.os.Bundle;

/**
 * by mrz
 * date  2018/6/14 09:03
 */

public interface Request<T> {

    T animation(int animation);

    T layout(int layout);

    T bundle(Bundle bundle);

    T cancelable(boolean state);

    T cancelOnTouchOutside(boolean state);

    T width(float attar);

    T code(int code);

    T common(boolean isCommonStyle);

    void show();

}
