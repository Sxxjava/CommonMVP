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
import com.iuling.mvp.kit.KnifeKit;

import butterknife.BindView;

/**
 * Created by Ewen on 2017/3/13.
 */

public class CommonAdapter extends SimpleRecAdapter<GanHuo.Item, CommonAdapter.ViewHolder> {

    public CommonAdapter(Context context) {
        super(context);
    }

    @Override
    public CommonAdapter.ViewHolder newViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_common;
    }

    @Override
    public void onBindViewHolder(final CommonAdapter.ViewHolder holder, final int position) {
        holder.text.setText(data.get(position).getDesc()+"["+data.get(position).getWho()+"]");
        if (getRecItemClick() != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getRecItemClick().onItemClick(position,data.get(position),position,holder);
                }
            });
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.image)ImageView image;
        @BindView(R.id.text)TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            KnifeKit.bind(this, itemView);
            image.setVisibility(View.GONE);
            text.setVisibility(View.VISIBLE);
        }
    }
}
