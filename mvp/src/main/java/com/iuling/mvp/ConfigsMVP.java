/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp;

import com.iuling.mvp.imageloader.ILoader;
import com.iuling.mvp.router.Router;

/**
 * Created by Ewen on 2016/12/4.
 */

public class ConfigsMVP {
    // #log
    public static final boolean LOG = true;
    public static final String LOG_TAG = "CMMVP";

    // #cache
    public static final String CACHE_SP_NAME = "config";
    public static final String CACHE_DISK_DIR = "cache";

    // #router
    public static final int ROUTER_ANIM_ENTER = Router.RES_NONE;
    public static final int ROUTER_ANIM_EXIT = Router.RES_NONE;

    // #imageloader
    public static final int IL_LOADING_RES = ILoader.Options.RES_NONE;
    public static final int IL_ERROR_RES = ILoader.Options.RES_NONE;

    // #dev model
    public static final boolean DEV = false;
}
