
# AndDialog
## 基于DialogFragment的简单封装
### 由于项目里面经常有用到一些弹框的提示,但是UI又不太喜欢MD的风格,就自己封装了这个库,采用链式的结构,使用起来也比较方便,可自定义布局,按钮,文件,动画,这个只是基础功能,后面还会继续修改,暂时就提供了3种简单的风格


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
![check](https://github.com/wenbinAndroid/AndDialog/blob/master/photo/check.png "check")  

#### 底部弹框
```Java
AndDialog.with(this).bottom().listener(this).layout(R.layout.dialog_share).show();
实现这个方法,自己加入需要显示的视图
@Override
    public void onDialogAction(View view, Bundle bundle, int code, final DialogFragment
            dialogFragment) {

    }
```
![bottom](https://github.com/wenbinAndroid/AndDialog/blob/master/photo/bottom.png "bottom") 
 
#### 错误提示框
AndDialog.with(this).tips().listener(this).message("这个是错误的提示").btnText("好的").show();
实现onTipsDialogClick方法执行回调操作
@Override
    public void onTipsDialogClick(int code) {

    }
   
```
![tips](https://github.com/wenbinAndroid/AndDialog/blob/master/photo/tips.png "tips")

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

