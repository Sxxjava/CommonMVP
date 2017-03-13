/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.mvp;

import android.view.View;

/**
 * Created by Ewen on 2016/12/29.
 */

public interface VDelegate {
    void resume();

    void pause();

    void destory();

    void visible(boolean flag, View view);
    void gone(boolean flag, View view);
    void inVisible(View view);

    void toastShort(String msg);
    void toastLong(String msg);
}
