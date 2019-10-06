# TabLayout2 


## 简介:  
基于 `Google Material` 中的 `TabLayout` 扩展   

   
#### 主要功能:  

## 集成方式   

使用 `jcenter`   
```groovy
 implementation 'com.gerenvip.ui.tabs:tablayout:xxx'
```
或者使用 `jitpack` 

在 工程目录下 `build.gradle` 中添加   

```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
`app module` 中 添加如下依赖   
```groovy
implementation 'com.github.gerenvip: tablayout:xxx'
```