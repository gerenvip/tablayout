# TabLayout2

[中文文档](https://github.com/gerenvip/tablayout/blob/master/README_CN.md)
## Introduction:
Based on the `TabLayout` extension in `Google material`

#### The main function:


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