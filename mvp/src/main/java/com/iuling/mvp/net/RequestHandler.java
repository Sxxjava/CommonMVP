/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.net;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ewen on 2016/12/24.
 */

public interface RequestHandler {
    Request onBeforeRequest(Request request, Interceptor.Chain chain);

    Response onAfterRequest(Response response, String result, Interceptor.Chain chain);
}
