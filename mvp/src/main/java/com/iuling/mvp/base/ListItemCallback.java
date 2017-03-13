/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.base;

/**
 * Created by Ewen on 2016/12/1.
 */

public abstract class ListItemCallback<T> {

    public void onItemClick(int position, T model, int tag) {}

    public void onItemLongClick(int position, T model, int tag) {}
}
