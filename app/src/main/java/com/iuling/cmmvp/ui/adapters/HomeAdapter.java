/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iuling.cmmvp.R;
import com.iuling.cmmvp.model.GanHuo;
import com.iuling.cmmvp.utils.DimenUtils;
import com.iuling.mvp.base.SimpleRecAdapter;
import com.iuling.mvp.imageloader.ILFactory;
import com.iuling.mvp.kit.KnifeKit;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;

import butterknife.BindView;

/**
 * Created by Ewen on 2017/3/13.
 */

public class HomeAdapter extends SimpleRecAdapter<GanHuo.Item,HomeAdapter.ViewHolder> {

    public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder newViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_common;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        GanHuo.Item item = data.get(position);
        if ("福利".equals(item.getType())) {
            holder.image.setVisibility(View.VISIBLE);
            holder.text.setVisibility(View.GONE);
            ILFactory.getLoader().loadNet(holder.image, item.getUrl(), null);
        } else {
            holder.image.setVisibility(View.GONE);
            holder.text.setVisibility(View.VISIBLE);
            holder.text.setText(data.get(position).getDesc()+"["+data.get(position).getWho()+"]");
            switch (item.getType()) {
                case "Android":
                    setIconDrawable(holder.text, MaterialDesignIconic.Icon.gmi_android);
                    break;
                case "iOS":
                    setIconDrawable(holder.text, MaterialDesignIconic.Icon.gmi_apple);
                    break;
                case "休息视频":
                    setIconDrawable(holder.text, MaterialDesignIconic.Icon.gmi_collection_video);
                    break;
                case "前端":
                    setIconDrawable(holder.text, MaterialDesignIconic.Icon.gmi_language_javascript);
                    break;
                case "拓展资源":
                    setIconDrawable(holder.text, FontAwesome.Icon.faw_location_arrow);
                    break;
                case "App":
                    setIconDrawable(holder.text, MaterialDesignIconic.Icon.gmi_apps);
                    break;
                case "瞎推荐":
                    setIconDrawable(holder.text, MaterialDesignIconic.Icon.gmi_more);
                    break;
            }
            if (getRecItemClick() != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getRecItemClick().onItemClick(position,data.get(position),position,holder);
                    }
                });
            }
        }
    }

    private void setIconDrawable(TextView view, IIcon icon) {
        view.setCompoundDrawablesWithIntrinsicBounds(new IconicsDrawable(context)
                        .icon(icon)
                        .color(view.getCurrentTextColor())
                        .sizeDp(14),
                null, null, null);
        view.setCompoundDrawablePadding(DimenUtils.dp2px(context, 5));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image)ImageView image;
        @BindView(R.id.text)TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            KnifeKit.bind(this,itemView);
        }
    }
}
