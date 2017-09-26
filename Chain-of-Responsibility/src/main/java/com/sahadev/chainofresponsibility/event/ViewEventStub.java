package com.sahadev.chainofresponsibility.event;


import android.support.annotation.NonNull;
import android.view.View;

/**
 * View隐藏
 */
public class ViewEventStub extends EventStub<View> {
    /**
     * @param mEventStub 下一级的事件接受者
     * @param viewStub   下一级被处理的对象
     */
    public ViewEventStub(IEvent mEventStub, View viewStub) {
        super(mEventStub, viewStub);
    }

    @Override
    public boolean onEventImpl(@NonNull View obj) {
        View tempView = obj;
        if (tempView.getVisibility() == View.VISIBLE) {
            tempView.setVisibility(View.INVISIBLE);
            return true;
        }
        return false;
    }
}