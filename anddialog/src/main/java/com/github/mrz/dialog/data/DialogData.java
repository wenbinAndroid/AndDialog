package com.github.mrz.dialog.data;

/**
 * by mrz
 * date  2018/7/5 16:53
 */

public class DialogData {
    public static final String DEFAULT_CHECK_TITLE = "操作提醒";
    public static final String DEFAULT_CHECK__LEFT = "取消";
    public static final String DEFAULT_CHECK_RIGHT = "确定";

    public static final String DEFAULT_TIPS_TITLE = "操作提醒";
    public static final String DEFAULT_TIPS_BUTTON = "知道了";

    public static final boolean DEFAULT_CANCEL = true;

    public static final boolean DEFAULT_CANCELONTOUCHOUTSIDE = true;

    public static final boolean DEFAULT_SHOW_TITLE = false;

    public static final float DEFAULT_ADDAR = 0.8f;

    public static enum Type {
        bottom, center
    }

    //底部弹出 底部消失
    public static final int LOCATION_FROM_BOTTOM_TO_BOTTOM = 1;
    //中心显示
    public static final int LOCATION_CENTER_CENTER = 2;
    //底部弹出  头部消失
    public static final int LOCATION_FROM_BOTTOM_TO_TOP = 3;
    //其他位置
    public static final int LOCATION_OTHER = 4;

    //显示动画 动画默认是对应上面位置显示
    //中心动画
    public static final int ANIMATION_FROM_CENTER_TO_CENTER = 1;
    //底部弹出 底部消失动画
    public static final int ANIMATION_FROM_BOTTOM_TO_BOTTOM = 2;
    //底部弹出 顶部显示动画
    public static final int ANIMATION_FROM_BOTTOM_TO_TOP = 3;
    //自定义动画
    public static final int ANITION_OTHER = 4;
}
