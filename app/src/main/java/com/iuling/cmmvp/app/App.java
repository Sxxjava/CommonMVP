/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.app;

import android.app.Application;
import com.iuling.mvp.net.NetError;
import com.iuling.mvp.net.NetProvider;
import com.iuling.mvp.net.RequestHandler;
import com.iuling.mvp.net.XApi;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created by Ewen on 2017/3/13.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        XApi.registerProvider(new NetProvider() {

            @Override
            public Interceptor[] configInterceptors() {
                return new Interceptor[0];
            }

            @Override
            public void configHttps(OkHttpClient.Builder builder) {

            }

            @Override
            public CookieJar configCookie() {
                return null;
            }

            @Override
            public RequestHandler configHandler() {
                return null;
            }

            @Override
            public long configConnectTimeoutMills() {
                return 0;
            }

            @Override
            public long configReadTimeoutMills() {
                return 0;
            }

            @Override
            public boolean configLogEnable() {
                return true;
            }

            @Override
            public boolean handleError(NetError error) {
                return false;
            }
        });
    }
}
