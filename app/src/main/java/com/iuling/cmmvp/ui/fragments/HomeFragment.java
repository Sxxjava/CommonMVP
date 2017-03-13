/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.ui.fragments;
import android.support.v7.widget.LinearLayoutManager;

import com.iuling.cmmvp.model.GanHuo;
import com.iuling.cmmvp.ui.activities.WebActivity;
import com.iuling.cmmvp.ui.adapters.HomeAdapter;
import com.iuling.mvp.base.SimpleRecAdapter;

import cn.droidlover.xrecyclerview.RecyclerItemCallback;
import cn.droidlover.xrecyclerview.XRecyclerView;

/**
 * Created by Ewen on 2017/3/13.
 */

public class HomeFragment extends BaseFragment {
    /**
     * 适配器
     */
    private HomeAdapter adapter;

    @Override
    protected String getType() {
        return "all";
    }

    @Override
    protected SimpleRecAdapter getAdapter() {
        if (adapter == null){
            adapter = new HomeAdapter(context);
            adapter.setRecItemClick(new RecyclerItemCallback<GanHuo.Item, HomeAdapter.ViewHolder>() {
                @Override
                public void onItemClick(int position, GanHuo.Item model, int tag, HomeAdapter.ViewHolder holder) {
                    super.onItemClick(position, model, tag, holder);
                    WebActivity.start(context, model.getUrl(), model.getDesc());
                }
            });
        }
        return adapter;
    }

    @Override
    public void setLayoutManager(XRecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    /**
     * 创建新实例
     * @return
     */
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}
