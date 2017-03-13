/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.net;

import com.iuling.cmmvp.app.configs.Configs;
import com.iuling.mvp.net.XApi;

public class Api {
    private static GankService gankService;

    public static GankService getGankService() {
        if (gankService == null) {
            synchronized (Api.class) {
                if (gankService == null) {
                    gankService = XApi.getInstance().getRetrofit(Configs.BASEURL, true).create(GankService.class);
                }
            }
        }
        return gankService;
    }
}
