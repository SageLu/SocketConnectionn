package com.sahadev.chainofresponsibility.event;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by shangbin on 2016/6/15.
 * Email: sahadev@foxmail.com
 */
public class AnimationLeftEventStub extends EventStub<View> {
    private boolean result = true;

    /**
     * @param mEventStub 下一级的事件接受者
     * @param viewStub   下一级被处理的对象
     */
    public AnimationLeftEventStub(IEvent mEventStub, View viewStub) {
        super(mEventStub, viewStub);
    }

    @Override
    protected boolean onEventImpl(@NonNull View obj) {
        if (result) {
            ObjectAnimator anim = ObjectAnimator.ofFloat(obj, "x", -400);
            anim.setDuration(1000);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    result = false;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            anim.start();
        }
        return result;
    }
}
