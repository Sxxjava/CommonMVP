/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.router;

import android.app.Activity;

/**
 * Created by Ewen on 2016/11/29.
 */

public class SimpleRouterCallback implements RouterCallback {

    @Override
    public void onBefore(Activity from, Class<?> to) {

    }

    @Override
    public void onNext(Activity from, Class<?> to) {

    }

    @Override
    public void onError(Activity from, Class<?> to, Throwable throwable) {

    }
}
