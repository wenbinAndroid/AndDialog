package com.github.mrz.dialog.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.github.mrz.dialog.R;
import com.github.mrz.dialog.data.DialogData;

import java.lang.ref.WeakReference;


/**
 * 作者 Mrz
 * 创建时间  2018/6/1 下午5:29
 */
@SuppressLint("ValidFragment")
public class BaseDialog<T extends Request> extends DialogFragment implements Request<T>, View
        .OnClickListener {
    protected View mView;
    protected int animation;
    private boolean useCommonStyle;
    protected float mWidthAttr = DialogData.DEFAULT_ADDAR;
    protected int resLayout;
    protected boolean isCancelable = DialogData.DEFAULT_CANCEL;
    protected boolean isCanceledOnTouchOutside = DialogData.DEFAULT_CANCELONTOUCHOUTSIDE;
    protected String title = DialogData.DEFAULT_CHECK_TITLE;
    protected String leftBtnText = DialogData.DEFAULT_CHECK__LEFT;
    protected String rightBtnText = DialogData.DEFAULT_CHECK_RIGHT;
    protected boolean isBackgroundDimEnabled;
    protected String message;
    protected int leftTextColor;
    protected int rightTextColor;
    protected int messageColor;
    protected int titleColor;
    protected int tipsButtonTextColor;
    protected boolean isShowTitle = DialogData.DEFAULT_SHOW_TITLE;
    protected int background;
    protected int requestCode;
    protected OnBottomDialogLister mOnBottomDialogLister;
    protected OnCheckDialogListener mOnCheckDialogListener;
    protected OnTipsDialogListener mOnTipsDialogListener;
    protected OnCenterDialogListener mOnCenterDialogListener;
    protected Bundle mBundle;
    protected WeakReference<Activity> mActivityWeakReference;
    protected Activity mActivity;
    protected T request;
    protected DialogData.Type type;

    public BaseDialog(Activity activity) {
        mActivityWeakReference = new WeakReference<>(activity);
        this.mActivity = mActivityWeakReference.get();
    }

    public BaseDialog(Activity activity, DialogData.Type type) {
        mActivityWeakReference = new WeakReference<>(activity);
        this.mActivity = mActivityWeakReference.get();
        this.type = type;
    }


    @Override
    public View getView() {
        return mView;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAnimation();
    }

    @Override
    public void onStart() {
        super.onStart();
        setWindows();
        initData();
    }

    private void initData() {
        bottom();
        check();
        tips();
        center();
    }

    private void setWindows() {
        if (type == DialogData.Type.center) {
            setCenter();
        } else if (type == DialogData.Type.bottom) {
            setBottom();
        }
    }

    /**
     * 设置动画效果
     */
    private void setAnimation() {
        switch (animation) {
            /*中心显示*/
            case DialogData.ANIMATION_FROM_CENTER_TO_CENTER:
                setStyle(DialogFragment.STYLE_NORMAL, R.style.CenterDialog);
                break;
            /*底部显示，底部隐藏*/
            case DialogData.ANIMATION_FROM_BOTTOM_TO_BOTTOM:
                setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomDialog);
                break;
            /*底部显示，顶部隐藏*/
            case DialogData.ANIMATION_FROM_BOTTOM_TO_TOP:
                setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomToTopDialog);
                break;
            //其他动画
            case DialogData.ANITION_OTHER:
                setStyle(DialogFragment.STYLE_NORMAL, animation);
                break;
            default:
                setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomDialog_Normal);
                break;

        }
    }

    protected void setCenter() {
        Window window = this.getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        int displayWidth = getDisplayWidth(mActivity);
        params.width = (int) (displayWidth * mWidthAttr);
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(params);
    }

    public int getDisplayWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCancelable(isCancelable);
        getDialog().setCanceledOnTouchOutside(isCanceledOnTouchOutside);
        Dialog dialog = getDialog();
        if (dialog != null) {
            //在5.0以下的版本会出现白色背景边框，若在5.0以上设置则会造成文字部分的背景也变成透明
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
                //目前只有这两个dialog会出现边框
                if (dialog instanceof ProgressDialog || dialog instanceof DatePickerDialog) {
                    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color
                            .TRANSPARENT));
                }
            }
        }
        setBackgroundDimEnabled();
        if (resLayout == 0) throw new IllegalStateException("layout must be not null");
        mView = inflater.inflate(resLayout, null);
        return mView;
    }


    private void tips() {
        if (mOnTipsDialogListener != null) {
            TextView tvTitle = mView.findViewById(R.id.tv_tips_title);
            TextView tvMessage = mView.findViewById(R.id.tv_tips_message);
            Button btn = mView.findViewById(R.id.btn_tips_enter);
            if (btn != null) {
                btn.setOnClickListener(this);
                btn.setText(rightBtnText);
            }
            if (tvTitle != null) {
                tvTitle.setText(title);
                tvTitle.setVisibility(!TextUtils.isEmpty(title) ? View.VISIBLE : View.GONE);
                if (titleColor != 0) {

                    tvTitle.setTextColor(
                            getTextColor(titleColor));
                }
            }
            if (tvMessage != null) {
                tvMessage.setText(message);
                if (messageColor != 0) {
                    tvMessage.setTextColor(
                            getTextColor(messageColor));
                }

            }
        }
    }

    private void check() {
        if (mOnCheckDialogListener != null) {
            TextView tvTitle = mView.findViewById(R.id.tv_check_title);
            TextView tvMessage = mView.findViewById(R.id.tv_check_message);
            Button btnCancel = mView.findViewById(R.id.btn_check_cancel);
            Button btnEnter = mView.findViewById(R.id.btn_check_enter);
            if (tvTitle != null) {
                tvTitle.setVisibility(isShowTitle ? View.VISIBLE : View.GONE);
                tvTitle.setText(title);
                if (titleColor != 0) {
                    tvTitle.setTextColor(
                            getTextColor(titleColor));
                }

            }
            if (tvMessage != null) {
                tvMessage.setText(message);
            }
            if (btnCancel != null) {
                btnCancel.setText(leftBtnText);
                btnCancel.setOnClickListener(this);
                if (leftTextColor != 0) {
                    btnCancel.setTextColor(
                            getTextColor(leftTextColor));
                }

            }
            if (btnEnter != null) {
                btnEnter.setText(rightBtnText);
                if (rightTextColor != 0) {
                    btnEnter.setTextColor(
                            getTextColor(rightTextColor));
                }
                btnEnter.setOnClickListener(this);
            }
        }
    }

    private void center() {
        if (mOnCenterDialogListener != null) {
            mOnCenterDialogListener.onDialogAction(mView, mBundle, requestCode, this);
        }
    }

    private int getTextColor(int color) {
        return ContextCompat.getColor(mActivity, color);
    }


    private void bottom() {
        if (mOnBottomDialogLister != null) {
            mOnBottomDialogLister.onDialogAction(mView, mBundle, requestCode, this);
        }
    }

    private void setBackgroundDimEnabled() {
        Window mWindow = getDialog().getWindow();
        WindowManager.LayoutParams lp = mWindow.getAttributes();
        lp.dimAmount = isBackgroundDimEnabled ? 1f : 0f;
        mWindow.setAttributes(lp);
    }


    //底部显示
    protected void setBottom() {
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
    }

    @Override
    public T animation(int animation) {
        this.animation = animation;
        return request;
    }


    @Override
    public T layout(int layout) {
        this.resLayout = layout;
        return request;
    }

    @Override
    public T bundle(Bundle bundle) {
        this.mBundle = bundle;
        return request;
    }

    @Override
    public T cancelable(boolean state) {
        this.isCancelable = state;
        return request;
    }

    @Override
    public T cancelOnTouchOutside(boolean state) {
        this.isCanceledOnTouchOutside = state;
        return request;
    }

    @Override
    public T width(float attar) {
        this.mWidthAttr = attar;
        return request;
    }


    @Override
    public T code(int code) {
        this.requestCode = code;
        return request;
    }

    @Override
    public T common(boolean isCommonSytle) {
        this.useCommonStyle = isCommonSytle;
        return request;
    }

    @Override
    public void show() {
        show(mActivity.getFragmentManager(), "");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_check_cancel) {
            mOnCheckDialogListener.onDialogLeft(requestCode);
        } else if (view.getId() == R.id.btn_check_enter) {
            mOnCheckDialogListener.onDialogRight(requestCode);
        } else if (view.getId() == R.id.btn_tips_enter) {
            mOnTipsDialogListener.onTipsDialogClick(requestCode);
        }
        reset();
    }

    private void reset() {
        mOnCheckDialogListener = null;
        mOnBottomDialogLister = null;
        mOnTipsDialogListener = null;
        mOnCenterDialogListener = null;
        dismiss();
    }

    public interface OnBottomDialogLister {
        void onDialogAction(View view, Bundle bundle, int requestCode, DialogFragment
                dialogFragment);
    }

    public interface OnCheckDialogListener {
        void onDialogLeft(int code);

        void onDialogRight(int code);
    }

    public interface OnTipsDialogListener {
        void onTipsDialogClick(int code);
    }

    public interface OnCenterDialogListener {
        void onDialogAction(View view, Bundle bundle, int requestCode, DialogFragment
                dialogFragment);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        mActivity = null;
        mView = null;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        mView = null;

    }
}
