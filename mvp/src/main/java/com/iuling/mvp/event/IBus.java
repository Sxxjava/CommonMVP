/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.mvp.event;

/**
 * Created by Ewen on 2016/12/22.
 */

public interface IBus {

    void register(Object object);
    void unregister(Object object);
    void post(IEvent event);
    void postSticky(IEvent event);


    interface IEvent {
        int getTag();
    }

}
