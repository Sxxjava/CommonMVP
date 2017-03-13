/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.iuling.cmmvp.model.GanHuo;
import com.iuling.cmmvp.ui.activities.WebActivity;
import com.iuling.cmmvp.ui.adapters.CommonAdapter;
import com.iuling.mvp.base.SimpleRecAdapter;

import cn.droidlover.xrecyclerview.RecyclerItemCallback;
import cn.droidlover.xrecyclerview.XRecyclerView;

/**
 * Created by Ewen on 2017/3/13.
 */

public class CommonFragment extends BaseFragment {
    /**
     * 页面类型参数的key
     */
    public static final String ARG_TYPE = "type";
    /**
     * 页面类型
     */
    private String type;
    /**
     * 适配器
     */
    private CommonAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //拿出传进来的type
        if (getArguments() != null)
            type = getArguments().getString(ARG_TYPE);

    }

    @Override
    protected String getType() {
        return type;
    }

    @Override
    protected SimpleRecAdapter getAdapter() {
        if (adapter == null){
            adapter = new CommonAdapter(context);
            adapter.setRecItemClick(new RecyclerItemCallback<GanHuo.Item, CommonAdapter.ViewHolder>() {
                @Override
                public void onItemClick(int position, GanHuo.Item model, int tag, CommonAdapter.ViewHolder holder) {
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
     * 获取新实例
     * @param type 页面类型
     * @return
     */
    public static CommonFragment newInstance(String type){
        Bundle args = new Bundle();
        CommonFragment fragment = new CommonFragment();
        args.putString(ARG_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }
}
