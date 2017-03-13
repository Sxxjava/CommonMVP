/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.model;

import com.iuling.mvp.net.IModel;

public class BaseModel implements IModel {
    protected boolean error;


    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean isAuthError() {
        return false;
    }

    @Override
    public boolean isBizError() {
        return error;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }
}