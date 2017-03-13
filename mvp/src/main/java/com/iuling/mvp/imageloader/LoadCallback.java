/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.imageloader;

import android.graphics.Bitmap;

/**
 * Created by Ewen on 2016/12/21.
 */

public abstract class LoadCallback {
    void onLoadFailed(Throwable e) {}

    public abstract void onLoadReady(Bitmap bitmap);

    void onLoadCanceled() {}
}
