
# AndDialog
## 基于DialogFragment的封装
### 由于项目里面经常有用到一些弹框的提示,但是UI又不太喜欢MD的风格,就自己封装了这个库,采用链式的结构,使用起来也比较方便,可自定义布局,按钮,文件,动画,这个只是基础功能,后面还会继续修改,暂时就提供了3种简单的风格



#### 如何引用

``` 
Add it in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency
	dependencies {
	implementation 'com.github.wenbinAndroid:AndDialog:v2.0.2'
	}
```
![photo](https://github.com/wenbinAndroid/AndDialog/blob/master/photo/S80802-16210796.gif)
### 使用方法  
#### 选择对话框

``` Java
AndDialog.with(this).check().setTitle(R.id.tv_check_title, "标题").setContent(R.id
                .tv_check_message, "内容").setLeftText(R.id
                .btn_check_cancel, "取消", new CheckLeftListener() {
            @Override
            public void leftClick(int requestCode) {

            }
        }).setRightText(R.id.btn_check_enter, "确定", new CheckRightListener() {
            @Override
            public void rightClick(int requestCode) {

            }
        }).setLayout(R.layout.dialog_common_check).setCancelable(false).setCanceledOnTouchOutside
                (true).show();
```

#### 底部弹框
```Java
AndDialog.with(this).bottom().setBottomListener(this).requestCode(1).setLayout(R.layout
                .dialog_share)
                .show();

实现这个方法,自己加入需要显示的视图
    @Override
    public void onDialogAction(View view, Bundle bundle, int code, final DialogFragment
            dialogFragment) {

    }
```
 
#### 错误提示框
``` java
 AndDialog.with(this).tips().setTitle(R.id.tv_tips_title, "标题").setTipsContent(R.id
                .tv_tips_message, "内容信息").setTipsBtnText(R.id
                .btn_tips_enter, "知道了", new TipsListener() {
            @Override
            public void onTipsClick(int requestCode) {

            }
        }).setLayout(R.layout.dialog_common_tips).show();
   
```




