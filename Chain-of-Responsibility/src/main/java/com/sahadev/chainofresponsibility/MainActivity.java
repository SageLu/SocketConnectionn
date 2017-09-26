package com.sahadev.chainofresponsibility;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sahadev.chainofresponsibility.event.AnimationLeftEventStub;
import com.sahadev.chainofresponsibility.event.AnimationRightEventStub;
import com.sahadev.chainofresponsibility.event.EventStub;
import com.sahadev.chainofresponsibility.event.IEvent;
import com.sahadev.chainofresponsibility.event.ViewEventStub;

/**
 * 责任链应用示例
 */
public class MainActivity extends AppCompatActivity {
    //责任链中被处理的对象
    View view_1, view_2, view_3, view_4, view_5;
    /**
     * 责任链源
     */
    EventStub sourceStub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化责任链中的被处理对象
        view_1 = findViewById(R.id.text1);
        view_2 = findViewById(R.id.text2);
        view_3 = findViewById(R.id.text3);
        view_4 = findViewById(R.id.text4);
        view_5 = findViewById(R.id.view_5);

        //生成事件处理责任链,sourceStub为链源，处理顺序由外向内

        EventStub tempStub = new CloseEventStub(null, null);
        tempStub = new AnimationRightEventStub(tempStub, findViewById(R.id.view_7));
        tempStub = new AnimationLeftEventStub(tempStub, findViewById(R.id.view_6));
        tempStub = new ViewEventStub(tempStub, view_5);
        tempStub = new ViewEventStub(tempStub, view_4);
        tempStub = new ViewEventStub(tempStub, view_3);
        sourceStub = new ViewEventStub(tempStub, view_2);
    }

    /**
     * 外部触发回调
     *
     * @param view
     */
    public void dismiss(View view) {
        //将事件传给责任链头
        sourceStub.onEvent(view_1);
    }

    private class CloseEventStub extends EventStub<View> {

        /**
         * @param mEventStub 下一级的事件接受者
         * @param viewStub   下一级被处理的对象
         */
        public CloseEventStub(IEvent mEventStub, View viewStub) {
            super(mEventStub, viewStub);
        }

        @Override
        protected boolean onEventImpl(@NonNull View obj) {
            if (obj.getVisibility() == View.GONE) {
                obj.setVisibility(View.VISIBLE);
                return true;
            }

            if (!isDestroyed()) {
                finish();
                return true;
            }

            return false;
        }
    }

}
