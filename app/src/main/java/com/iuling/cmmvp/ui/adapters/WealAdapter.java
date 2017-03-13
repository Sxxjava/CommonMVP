/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iuling.cmmvp.R;
import com.iuling.cmmvp.model.GanHuo;
import com.iuling.mvp.base.SimpleRecAdapter;
import com.iuling.mvp.imageloader.ILFactory;
import com.iuling.mvp.kit.KnifeKit;

import butterknife.BindView;

/**
 * Created by Ewen on 2017/3/13.
 */

public class WealAdapter extends SimpleRecAdapter<GanHuo.Item, WealAdapter.ViewHolder>{

    public WealAdapter(Context context) {
        super(context);
    }

    @Override
    public WealAdapter.ViewHolder newViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_common;
    }

    @Override
    public void onBindViewHolder(WealAdapter.ViewHolder holder, int position) {
        GanHuo.Item item = data.get(position);
        ILFactory.getLoader().loadNet(holder.image, item.getUrl(), null);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image)ImageView image;
        @BindView(R.id.text)TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            KnifeKit.bind(this,itemView);
            text.setVisibility(View.GONE);
            image.setVisibility(View.VISIBLE);
        }
    }
}
