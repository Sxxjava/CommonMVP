/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.ui.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iuling.cmmvp.R;
import com.iuling.mvp.kit.KnifeKit;

import butterknife.BindView;

public class ErrorView extends LinearLayout {

    @BindView(R.id.tv_msg)
    TextView tvMsg;

    public ErrorView(Context context) {
        super(context);
        setupView(context);
    }

    public ErrorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupView(context);
    }

    public ErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupView(context);
    }

    private void setupView(Context context) {
        inflate(context, R.layout.view_error, this);
        KnifeKit.bind(this);
    }

    public void setMsg(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            tvMsg.setText(msg);
        }
    }
}
