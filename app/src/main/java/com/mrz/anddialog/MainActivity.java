package com.mrz.anddialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.mrz.dialog.AndDialog;
import com.github.mrz.dialog.base.BaseDialog;
import com.github.mrz.dialog.data.DialogData;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseDialog.OnCheckDialogListener,
        BaseDialog.OnTipsDialogListener, BaseDialog.OnBottomDialogLister, BaseDialog
                .OnCenterDialogListener {
    //分享的平台文字
    public static final List<String> SHARE_TEXT = Arrays.asList("朋友圈", "微信好友", "QQ好友", "QQ空间");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheck(View view) {
        AndDialog.with(this).check().listener(this).layout(R.layout.dialog_common_check).message
                ("这个是选择框").show();
    }

    public void onBottom(View view) {
        AndDialog.with(this).bottom().listener(this).layout(R.layout.dialog_share).show();
    }

    public void onErr(View view) {
        AndDialog.with(this).tips().listener(this).message("这个是错误的提示").btnText("好的").show();
    }

    public void onCenter(View view) {
        AndDialog.with(this).center().animation(DialogData.ANIMATION_FROM_CENTER_TO_CENTER)
                .layout(R.layout.dialog_common_check).show();
    }

    @Override
    public void onDialogAction(View view, Bundle bundle, int code, final DialogFragment
            dialogFragment) {
        RecyclerView rv = view.findViewById(R.id.recycler);
        ShareAdapter adapter = new ShareAdapter(SHARE_TEXT);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager
                .HORIZONTAL, false));
        rv.setAdapter(adapter);
        view.findViewById(R.id.tv_cancel).setOnClickListener(new View
                .OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogFragment.dismiss();
            }
        });
    }

    @Override
    public void onTipsDialogClick(int code) {

    }

    @Override
    public void onDialogLeft(int code) {

    }

    @Override
    public void onDialogRight(int code) {

    }

}
