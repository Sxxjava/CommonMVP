/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.event;

/**
 * Created by Ewen on 2016/12/22.
 */

public class BusProvider {

    private static RxBusImpl bus;

    public static RxBusImpl getBus() {
        if (bus == null) {
            synchronized (BusProvider.class) {
                if (bus == null) {
                    bus = new RxBusImpl();
                }
            }
        }
        return bus;
    }

}
