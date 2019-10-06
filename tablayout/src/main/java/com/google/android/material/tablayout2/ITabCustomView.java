package com.google.android.material.tablayout2;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * @author wangwei on 2019-09-29.
 * wangwei11@kuaishou.com
 */
public interface ITabCustomView {

  /**
   * 返回内容的宽度
   */
  int getContentWidth();

  @Nullable
  TextView getCustomTextView();

  @Nullable
  ImageView getCustomIconView();
}
