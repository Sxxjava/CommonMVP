/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.mvp;

/**
 * Created by Ewen on 2016/12/29.
 */

public interface IPresent<V> {
    void attachV(V view);

    void detachV();
}
