package com.sahadev.chainofresponsibility.event;

import android.support.annotation.NonNull;

/**
 * 责任链抽象类，其中包含下一个实现者的应用
 */
public abstract class EventStub<T> implements IEvent<T> {
    protected IEvent mEventStub;
    protected T viewStub;

    /**
     * @param mEventStub 下一级的事件接受者
     * @param viewStub   下一级被处理的对象
     */
    public EventStub(IEvent mEventStub, T viewStub) {
        this.mEventStub = mEventStub;
        this.viewStub = viewStub;
    }

    @Override
    public boolean onEvent(@NonNull T obj) {
        boolean b = onEventImpl(obj);
        if (!b && mEventStub != null)
            return mEventStub.onEvent(viewStub);
        return b;
    }

    /**
     * @param obj
     * @return 代表是否有消费事件
     */
    protected abstract boolean onEventImpl(@NonNull T obj);
}