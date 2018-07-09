
# AndDialog
## 基于DialogFragment的简单封装
### 由于项目里面经常有用到一些弹框的提示,但是UI又不太喜欢MD的风格,就自己封装了这个库,采用链式的结构,使用起来也比较方便,可自定义布局,按钮,文件,动画,这个只是基础功能,后面还会继续修改,暂时就提供了3种简单的风格


#### 使用方法
``` Java
选择对话框
AndDialog.with(this).check().listener(this).layout(R.layout.dialog_common_check).message
                ("这个是选择框").show();
![check](https://github.com/wenbinAndroid/AndDialog/blob/master/photo/check.png)
底部弹框
AndDialog.with(this).bottom().listener(this).layout(R.layout.dialog_share).show();

 
错误提示框
AndDialog.with(this).tips().listener(this).message("这个是错误的提示").btnText("好的").show();
```
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

