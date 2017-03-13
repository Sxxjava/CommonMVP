/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.utils;

import android.content.Context;

public class DimenUtils {

    public static int dp2px(Context context, float dpValue) {
        return (int)(dpValue * context.getResources().getDisplayMetrics().density + 0.5F);
    }

    public static int px2dp(Context context, float pxValue) {
        return (int)(pxValue / context.getResources().getDisplayMetrics().density + 0.5F);
    }
}