/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.net;

/**
 * Created by Ewen on 2016/12/26.
 */

public interface IModel {
    boolean isNull();       //空数据

    boolean isAuthError();  //验证错误

    boolean isBizError();   //业务错误

    String getErrorMsg();   //后台返回的错误信息
}
