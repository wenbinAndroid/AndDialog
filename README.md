
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
	        implementation 'com.github.wenbinAndroid:AndDialog:1.0.1'
	}
```
![photo](https://github.com/wenbinAndroid/AndDialog/blob/master/photo/S80802-16210796.gif)
### 使用方法  
#### 选择对话框

``` Java
AndDialog.with(this).check().listener(this).layout(R.layout.dialog_common_check).message
                ("这里是内容界面").show();
		
实现onDialogLeft,onDialogRight 分别为左右两边的点击回调
    @Override
    public void onDialogLeft(int code) {

    }

    @Override
    public void onDialogRight(int code) {

    }
```

#### 底部弹框
```Java
AndDialog.with(this).bottom().listener(this).layout(R.layout.dialog_share).show();

实现这个方法,自己加入需要显示的视图
    @Override
    public void onDialogAction(View view, Bundle bundle, int code, final DialogFragment
            dialogFragment) {

    }
```
 
#### 错误提示框
``` java
AndDialog.with(this).tips().listener(this).message("这个是错误的提示").btnText("好的").show();

实现onTipsDialogClick方法执行回调操作
    @Override
    public void onTipsDialogClick(int code) {

    }
   
```

### 结构部分
#### 公共接口部分
``` Java
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
```
#### 选择对话框
```java
public interface CheckRequest extends Request<CheckRequest> {

    CheckRequest listener(BaseDialog.OnCheckDialogListener listener);

    CheckRequest title(String title);

    CheckRequest message(String message);

    CheckRequest leftBtnText(String text);

    CheckRequest rightBtnText(String text);

    CheckRequest visibleTitle(boolean show);

    CheckRequest leftBtnTextColor(int color);

    CheckRequest rightBtnTextColor(int color);

    CheckRequest messageColor(int color);

    CheckRequest titleColor(int color);

    CheckRequest normal(BaseDialog.OnCheckDialogListener listener);

    CheckRequest normal(BaseDialog.OnCheckDialogListener listener, int layout);

}
```
#### 底部弹框
```java
public interface BottomRequest extends Request<BottomRequest> {

    BottomRequest listener(BaseDialog.OnBottomDialogLister lister);

    BottomRequest normal(BaseDialog.OnBottomDialogLister lister, int layout);


}
````
#### 提示框
```java
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
```



