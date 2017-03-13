/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.net;

import com.iuling.cmmvp.model.GanHuo;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GankService {

    @GET("{type}/{number}/{page}")
    Observable<GanHuo> getGankData(@Path("type") String type,
                                   @Path("number") int pageSize,
                                   @Path("page") int pageNum);
}
