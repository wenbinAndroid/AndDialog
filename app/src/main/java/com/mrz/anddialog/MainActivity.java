package com.mrz.anddialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.mrz.dialog.AndDialog;
import com.github.mrz.dialog.listener.CheckLeftListener;
import com.github.mrz.dialog.listener.CheckRightListener;
import com.github.mrz.dialog.listener.OnDialogListner;
import com.github.mrz.dialog.listener.TipsListener;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnDialogListner {
    //分享的平台文字
    public static final List<String> SHARE_TEXT = Arrays.asList("朋友圈", "微信好友", "QQ好友", "QQ空间");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheck(View view) {
        AndDialog.with(this).check().setTitle(R.id.tv_check_title, "这里是标题").setContent(R.id
                .tv_check_message, "不知道哦啊要谢什么内容").setLeftText(R.id
                .btn_check_cancel, "取消2", new CheckLeftListener() {
            @Override
            public void leftClick(int requestCode) {

            }
        }).setRightText(R.id.btn_check_enter, "确定2", new CheckRightListener() {
            @Override
            public void rightClick(int requestCode) {

            }
        }).setLayout(R.layout.dialog_common_check).setCancelable(false).setCanceledOnTouchOutside
                (true).show();
    }

    public void onBottom(View view) {
        AndDialog.with(this).bottom().setBottomListener(this).requestCode(1).setLayout(R.layout
                .dialog_share)
                .show();
    }

    public void onErr(View view) {
        AndDialog.with(this).tips().setTitle(R.id.tv_tips_title, "错误标题").setTipsContent(R.id
                .tv_tips_message, "这里是内容信息").setTipsBtnText(R.id
                .btn_tips_enter, "知道了3", new TipsListener() {
            @Override
            public void onTipsClick(int requestCode) {

            }
        }).setLayout(R.layout.dialog_common_tips).show();
    }


    @Override
    public void onDialogAction(DialogFragment dialogFragment, View view, int code) {
        RecyclerView rv = view.findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv.setAdapter(new ShareAdapter(SHARE_TEXT));
    }
}
