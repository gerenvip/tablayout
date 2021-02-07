package com.google.android.material.tablayout2;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * @author gerenvip.Wayne on 2019-09-29.
 */
public interface ITabCustomView {

  /**
   * 返回内容的宽度
   */
  int getContentWidth();

  /**
   * 返回内容的高度
   */
  int getContentHeight();

  @Nullable
  TextView getCustomTextView();

  @Nullable
  ImageView getCustomIconView();
}
