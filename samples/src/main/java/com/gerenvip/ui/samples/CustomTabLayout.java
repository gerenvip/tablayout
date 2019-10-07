package com.gerenvip.ui.samples;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.tablayout2.ITabCustomView;


/**
 * @author wangwei on 2019-09-29.
 * wangwei11@kuaishou.com
 */
public class CustomTabLayout extends FrameLayout implements ITabCustomView {

  private TextView textview;
  private ImageView iconView;

  public CustomTabLayout(@NonNull Context context) {
    super(context);
  }

  public CustomTabLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public CustomTabLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
    textview = findViewById(android.R.id.text1);
    iconView = findViewById(android.R.id.icon);
  }


  @Override
  public int getContentWidth() {
    return textview.getWidth();
  }

  @Override
  public int getContentHeight() {
    return textview.getHeight();
  }

  @Override
  public TextView getCustomTextView() {
    return textview;
  }

  @Override
  public ImageView getCustomIconView() {
    return iconView;
  }
}
