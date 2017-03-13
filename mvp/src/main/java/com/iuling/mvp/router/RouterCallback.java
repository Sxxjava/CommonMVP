/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.router;

import android.app.Activity;

/**
 * Created by Ewen on 2016/11/29.
 */

public interface RouterCallback {

    void onBefore(Activity from, Class<?> to);

    void onNext(Activity from, Class<?> to);

    void onError(Activity from, Class<?> to, Throwable throwable);

}
