/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.cache;

/**
 * Created by Ewen on 2016/11/27.
 */

public interface ICache {
    void put(String key, Object value);

    Object get(String key);

    void remove(String key);

    boolean contains(String key);

    void clear();

}
