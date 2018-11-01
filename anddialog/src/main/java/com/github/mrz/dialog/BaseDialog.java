package com.github.mrz.dialog;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.github.mrz.dialog.listener.OnDialogListner;
import com.github.mrz.dialog.request.Request;
import com.github.mrz.dialog.type.DialogType;

/**
 * @author Mrz
 * @date 2018/10/29 13:52
 */
@SuppressLint("ValidFragment")
public class BaseDialog extends DialogFragment {

    private Request.Builder mBuilder;
    private Context mContext;
    private View mView;
    private DialogType mDialogType;
    private int requestCode;

    public BaseDialog(Request.Builder builder) {
        this.mBuilder = builder;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context.getApplicationContext();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAnimation();
    }

    /**
     * 设置动画效果
     */
    private void setAnimation() {
        mDialogType = mBuilder.mDialogType;
        requestCode = mBuilder.requestCode;
        int animation = mBuilder.animation;
        if (animation == 0) {

            if (mDialogType == DialogType.BOTTOM) {
                //底部弹出
                setStyle(0, R.style.BottomDialog);
            } else if ((mDialogType == DialogType.TIPS || mDialogType == DialogType.CENTER ||
                    mDialogType == DialogType
                            .CHECK)) {
                //中间弹出
                setStyle(0, R.style.CenterDialog);
            }
        } else {
            //自定义动画
            setStyle(0, animation);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        setWindows();
        initData();
    }


    private void initData() {

        if (mDialogType == DialogType.BOTTOM || mDialogType == DialogType.CENTER) {
            bottomOrCenter();
        } else if (mDialogType == DialogType.TOP) {

        } else if (mDialogType == DialogType.TIPS) {
            tips();
        } else if (mDialogType == DialogType.CHECK) {
            check();
        }
    }


    private void bottomOrCenter() {
        OnDialogListner listner = mBuilder.mOnDialogListner;
        if (listner != null) {
            listner.onDialogAction(this, mView, requestCode);
        }
    }


    private void check() {
        if (mBuilder.rightBtnID != 0) {
            Button rightBtn = mView.findViewById(mBuilder.rightBtnID);
            rightBtn.setText(mBuilder.rightText);
            rightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mBuilder.mCheckRightListener != null) {
                        mBuilder.mCheckRightListener.rightClick(mBuilder.requestCode);
                        dismiss();
                    }
                }
            });
        }
        if (mBuilder.leftBtnID != 0) {
            Button leftBtn = mView.findViewById(mBuilder.leftBtnID);
            leftBtn.setText(mBuilder.leftText);
            leftBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mBuilder.mCheckLeftListener != null) {
                        mBuilder.mCheckLeftListener.leftClick(mBuilder.requestCode);
                        dismiss();
                    }
                }
            });
        }
        if (mBuilder.tvContentID != 0) {
            TextView tvContent = mView.findViewById(mBuilder.tvContentID);
            tvContent.setText(mBuilder.content);
        }
        if (mBuilder.tvTitleId != 0) {
            TextView tvTitle = mView.findViewById(mBuilder.tvTitleId);
            tvTitle.setVisibility(mBuilder.isTitleVisable ? View.VISIBLE : View.GONE);
            tvTitle.setText(mBuilder.title);
        }
    }


    private void tips() {
        if (mBuilder.tvTitleId != 0) {
            TextView tvTitle = mView.findViewById(mBuilder.tvTitleId);
            tvTitle.setVisibility(mBuilder.isTitleVisable ? View.VISIBLE : View.GONE);
            tvTitle.setText(mBuilder.title);
        }
        if (mBuilder.tipsBtnID != 0) {
            Button button = mView.findViewById(mBuilder.tipsBtnID);
            button.setText(mBuilder.tipsBtnText);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mBuilder.mTipsListener != null) {
                        mBuilder.mTipsListener.onTipsClick(mBuilder.requestCode);
                        dismiss();
                    }
                }
            });
        }
        if (mBuilder.tvContentID != 0) {
            TextView tvContent = mView.findViewById(mBuilder.tvContentID);
            tvContent.setText(mBuilder.content);
        }
    }

    private void setWindows() {
        mDialogType = mBuilder.mDialogType;
        if (mDialogType == DialogType.CHECK || mDialogType == DialogType.CENTER || mDialogType ==
                DialogType.TIPS) {
            setCenter();
        } else if (mDialogType == DialogType.BOTTOM) {
            setBottom();
        } else if (mDialogType == DialogType.TOP) {
            setTop();
        }
    }

    //底部显示
    protected void setBottom() {
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
    }

    protected void setTop() {
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.TOP;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
    }

    protected void setCenter() {
        Window window = this.getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        int displayWidth = getDisplayWidth(mContext);
        params.width = (int) (displayWidth * mBuilder.width);
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
        setCancelable(mBuilder.isCancelable);
        getDialog().setCanceledOnTouchOutside(mBuilder.isCancelabledOnTouchOutside);
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
        int resLayout = mBuilder.layout;
        if (resLayout == 0) {
            throw new IllegalStateException("layout must be not null");
        }
        mView = inflater.inflate(resLayout, null);
        return mView;
    }

    private void setBackgroundDimEnabled() {
        Window mWindow = getDialog().getWindow();
        WindowManager.LayoutParams lp = mWindow.getAttributes();
        lp.dimAmount = 0f;
        mWindow.setAttributes(lp);
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            super.show(manager, tag);
        } catch (Exception e) {

        }

    }

    @Override
    public void dismiss() {
        super.dismiss();
        mBuilder.mActivity.clear();
        mBuilder = null;
        mView = null;
        mContext = null;
    }
}
