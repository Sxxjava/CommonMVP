/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.iuling.cmmvp.R;
import com.iuling.cmmvp.model.GanHuo;
import com.iuling.cmmvp.present.BasePager;
import com.iuling.cmmvp.ui.widgets.ErrorView;
import com.iuling.mvp.base.SimpleRecAdapter;
import com.iuling.mvp.mvp.XLazyFragment;
import com.iuling.mvp.net.NetError;

import butterknife.BindView;
import cn.droidlover.xrecyclerview.XRecyclerContentLayout;
import cn.droidlover.xrecyclerview.XRecyclerView;

/**
 * Created by Ewen on 2017/3/13.
 */

public abstract class BaseFragment extends XLazyFragment<BasePager> {

    @BindView(R.id.contentLayout)
    XRecyclerContentLayout contentLayout;

    ErrorView errorView;

    @Override
    public void initData(Bundle savedInstanceState) {
        init();
        showLoading();
        getP().loadData(getType(),1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_base;
    }

    @Override
    public BasePager newP() {
        return new BasePager();
    }

    private void init() {
        setLayoutManager(contentLayout.getRecyclerView());
        contentLayout.getRecyclerView()
                .setAdapter(getAdapter());
        contentLayout.getRecyclerView()
                .setOnRefreshAndLoadMoreListener(new XRecyclerView.OnRefreshAndLoadMoreListener() {
                    @Override
                    public void onRefresh() {
                        getP().loadData(getType(), 1);
                    }

                    @Override
                    public void onLoadMore(int page) {
                        getP().loadData(getType(), page);
                    }
                });


        if (errorView == null) {
            errorView = new ErrorView(context);
        }
        contentLayout.errorView(errorView);
        contentLayout.loadingView(View.inflate(getContext(), R.layout.view_loading, null));

        contentLayout.getRecyclerView().useDefLoadMoreView();
    }

    /**
     * 显示错误信息
     * @param error
     */
    public void showError(NetError error) {
        if (error != null) {
            switch (error.getType()) {
                case NetError.ParseError:
                    errorView.setMsg(getString(R.string.text_error_data_parsing));
                    break;

                case NetError.AuthError:
                    errorView.setMsg(getString(R.string.text_error_auth));
                    break;

                case NetError.BusinessError:
                    errorView.setMsg(getString(R.string.text_business_error));
                    break;

                case NetError.NoConnectError:
                    errorView.setMsg(getString(R.string.text_not_internet));
                    break;

                case NetError.NoDataError:
                    errorView.setMsg(getString(R.string.text_empty_data));
                    break;

                case NetError.OtherError:
                    errorView.setMsg(getString(R.string.text_other_error));
                    break;
            }
            contentLayout.showError();
        }
    }

    /**
     * 显示内容
     * @param page
     * @param model
     */
    public void showData(int page, GanHuo model) {
        if (page > 1) {
            getAdapter().addData(model.getResults());
        } else {
            getAdapter().setData(model.getResults());
        }

        contentLayout.getRecyclerView().setPage(page, 10);

        if (getAdapter().getItemCount() < 1) {
            contentLayout.showEmpty();
            return;
        }
    }

    /**
     * 显示加载中动画
     */
    public void showLoading(){
        contentLayout.showLoading();
    }
    /**
     * 获取页面类型
     * @return
     */
    protected abstract String getType();

    /**
     * 获取页面类型
     * @return
     */
    protected abstract SimpleRecAdapter getAdapter();

    /**
     * 设置RecycleView布局管理器
     * @param recyclerView
     */
    public abstract void setLayoutManager(XRecyclerView recyclerView);
}
