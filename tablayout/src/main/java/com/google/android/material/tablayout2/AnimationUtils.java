package com.google.android.material.tablayout2;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/**
 * copy from {@link com.google.android.material.animation.AnimationUtils}
 * @author gerenvip.Wayne on 2020/8/22.
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
class AnimationUtils {
  public static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
  public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR =
          new FastOutSlowInInterpolator();
  public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR =
          new FastOutLinearInInterpolator();
  public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR =
          new LinearOutSlowInInterpolator();
  public static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();

  /**
   * Linear interpolation between {@code startValue} and {@code endValue} by {@code fraction}.
   */
  public static float lerp(float startValue, float endValue, float fraction) {
    return startValue + (fraction * (endValue - startValue));
  }

  /**
   * Linear interpolation between {@code startValue} and {@code endValue} by {@code fraction}.
   */
  public static int lerp(int startValue, int endValue, float fraction) {
    return startValue + Math.round(fraction * (endValue - startValue));
  }
}
