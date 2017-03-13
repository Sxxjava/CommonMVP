/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.ui.fragments;
import android.support.v7.widget.LinearLayoutManager;

import com.iuling.cmmvp.ui.adapters.WealAdapter;
import com.iuling.mvp.base.SimpleRecAdapter;

import cn.droidlover.xrecyclerview.XRecyclerView;

/**
 * Created by Ewen on 2017/3/13.
 */

public class WealFragment extends BaseFragment {
    /**
     * 适配器
     */
    private WealAdapter adapter;

    @Override
    protected String getType() {
        return "福利";
    }

    @Override
    protected SimpleRecAdapter getAdapter() {
        if (adapter == null){
            adapter = new WealAdapter(context);
        }
        return adapter;
    }

    @Override
    public void setLayoutManager(XRecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    /**
     * 获取新实例
     * @return
     */
    public static WealFragment newInstance() {
        return new WealFragment();
    }
}
