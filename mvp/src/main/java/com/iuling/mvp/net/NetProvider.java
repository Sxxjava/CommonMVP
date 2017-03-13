/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.net;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created by Ewen on 2016/12/24.
 */

public interface NetProvider {
    Interceptor[] configInterceptors();

    void configHttps(OkHttpClient.Builder builder);

    CookieJar configCookie();

    RequestHandler configHandler();

    long configConnectTimeoutMills();

    long configReadTimeoutMills();

    boolean configLogEnable();

    boolean handleError(NetError error);
}
