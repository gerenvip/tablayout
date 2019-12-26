# TabLayout + VerticalTabLayout  
[ ![Download](https://api.bintray.com/packages/gerenvip/maven/TabLayout/images/download.svg) ](https://bintray.com/gerenvip/maven/TabLayout/_latestVersion)

[中文文档](https://github.com/gerenvip/tablayout/blob/master/README_CN.md)

[Demo Apk](https://github.com/gerenvip/tablayout/blob/master/samples-debug.apk?raw=true)

## Introduction:
Based on the `TabLayout` extension in `Google material`  

 ![](https://github.com/gerenvip/tablayout/blob/master/demo.gif?raw=true)

#### The main function:

##### 1. Add some attributes  

```xml
 <!--当 tabIndicatorFullWidth 为 false，即 指示器的宽度由内容的宽度来决定 时
       定义最小的指示器宽度，默认是 24dp -->
        <attr name="minIndicatorWidth" format="dimension" />
        <!--如果前一次选择的tab 和本次选中的tab 不相邻，是否 indicator 从最近的边缘开始-->
        <attr name="indicatorGrowNearestEdge" format="boolean" />
        <!--是否 允许 indicator运动的时候开启粘滞效果 -->
        <attr name="tabIndicatorSticky" format="boolean" />
        <!--指示器距所依赖的边间距, tabIndicatorGravity 对应如下:
         bottom -> 指示器距底部的间距
         center,top -> 指示器距顶部的间距
         stretch -> 指示器距顶部和底部的间距
         contentBottom -> 指示器距底部的间距
         contentTop -> 指示器距顶部的间距
         -->
        <attr name="tabIndicatorVerticalPadding" format="dimension" />
        <!--tab 的指示器 水平方向上的padding, 仅在 tabIndicatorFullWidth 为 false 的情况下生效 -->
        <attr name="tabIndicatorHorizontalPadding" format="dimension" />

        <!-- Gravity constant for tab selection indicator. -->
        <attr name="tabIndicatorGravity2" format="enum">
            <!-- Align indicator to the bottom of this tab layout. -->
            <enum name="bottom" value="0" />
            <!-- Align indicator along the center of this tab layout. -->
            <enum name="center" value="1" />
            <!-- Align indicator to the top of this tab layout. -->
            <enum name="top" value="2" />
            <!-- Stretch indicator to match the height and width of a tab item in this layout. -->
            <enum name="stretch" value="3" />
            <!--紧贴 tab 内容底部-->
            <enum name="contentBottom" value="4" />
            <!--紧贴 tab 内容顶部-->
            <enum name="contentTop" value="5" />
        </attr>

        <!--固定每一个tab指示器的宽度, 仅在 tabIndicatorFullWidth 为 false 的情况下生效,
         建议 通过 tabIndicator 设置 一个 位图 使用-->
        <attr name="tabIndicatorFixedWidth" format="dimension" />
```

##### 2. Add ITabCustomView interface  

```java
public interface ITabCustomView {
 
  int getContentWidth();
  
  int getContentHeight();

  @Nullable
  TextView getCustomTextView();

  @Nullable
  ImageView getCustomIconView();
}
``` 

## How to integrate  

Use `jcenter`
```groovy
 implementation 'com.gerenvip.ui.tabs:tablayout:xxx'
```  


Use `jitpack`
Add in the build directory `build.gradle`

```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
In `app module` Add the following dependency
```groovy
implementation 'com.github.gerenvip:tabLayout:xxx'
```