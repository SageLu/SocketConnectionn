package com.sahadev.chainofresponsibility.event;

import android.support.annotation.NonNull;

/**
 * Created by shangbin on 2016/6/15.
 * Email: sahadev@foxmail.com
 */
public interface IEvent<T> {
    public boolean onEvent(@NonNull T obj);
}
