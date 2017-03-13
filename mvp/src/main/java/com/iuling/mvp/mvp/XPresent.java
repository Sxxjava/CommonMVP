/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.mvp;

/**
 * Created by Ewen on 2016/12/29.
 */

public class XPresent<V extends IView> implements IPresent<V> {
    private V v;

    @Override
    public void attachV(V view) {
        v = view;
    }

    @Override
    public void detachV() {
        v = null;
    }

    protected V getV() {
        if (v == null) {
            throw new IllegalStateException("v can not be null");
        }
        return v;
    }
}
