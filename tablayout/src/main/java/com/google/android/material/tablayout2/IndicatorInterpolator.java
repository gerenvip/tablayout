package com.google.android.material.tablayout2;

import android.view.animation.Interpolator;

/**
 * @author gerenvip.Wayne on 2019-10-13.
 */
public class IndicatorInterpolator implements Interpolator {

    private final boolean accelerate;

    public IndicatorInterpolator(boolean accelerate) {
        this.accelerate = accelerate;
    }

    @Override
    public float getInterpolation(float input) {
        if (accelerate) {
            return getAccelerateInterpolation(input);

        }
        return getDecelerateInterpolation(input);
    }

    private float getAccelerateInterpolation(float input) {
        return getCos(input);
    }

    private float getDecelerateInterpolation(float input) {
        return getSin(input);
    }

    /**
     * 先快后慢 - 减速
     *
     * @param in
     */
    private static float getSin(float in) {
        return (float) Math.sin((1 / 2f) * Math.PI * in);
    }

    /**
     * 先慢后快 - 加速
     *
     * @param in
     */
    private static float getCos(float in) {
        return (float) Math.cos((1 / 2f) * Math.PI * in + Math.PI) + 1;
    }
}
