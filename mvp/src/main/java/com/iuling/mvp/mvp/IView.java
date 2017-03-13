/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.mvp;

import android.os.Bundle;
import android.view.View;

/**
 * Created by Ewen on 2016/12/29.
 */

public interface IView<P> {
    void bindUI(View rootView);

    void bindEvent();

    void initData(Bundle savedInstanceState);

    int getOptionsMenuId();

    int getLayoutId();

    boolean useEventBus();

    P newP();
}
