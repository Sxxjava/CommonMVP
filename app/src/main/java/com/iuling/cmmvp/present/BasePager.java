/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.present;

import com.iuling.cmmvp.model.GanHuo;
import com.iuling.cmmvp.net.Api;
import com.iuling.cmmvp.ui.fragments.BaseFragment;
import com.iuling.mvp.mvp.XPresent;
import com.iuling.mvp.net.ApiSubcriber;
import com.iuling.mvp.net.NetError;
import com.iuling.mvp.net.XApi;

/**
 * Created by Ewen on 2017/3/13.
 */

public class BasePager extends XPresent<BaseFragment> {
    protected static final int PAGE_SIZE = 30;

    public void loadData(String type,final int pageIndex){
        Api.getGankService().getGankData(type, PAGE_SIZE, pageIndex)
                .compose(XApi.<GanHuo>getApiTransformer())
                .compose(XApi.<GanHuo>getScheduler())
                .compose(getV().<GanHuo>bindToLifecycle())
                .subscribe(new ApiSubcriber<GanHuo>() {
                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error);
                    }

                    @Override
                    public void onNext(GanHuo gankResults) {
                        getV().showData(pageIndex, gankResults);
                    }
                });
    }
}
