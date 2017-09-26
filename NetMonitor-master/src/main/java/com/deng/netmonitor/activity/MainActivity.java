package com.deng.netmonitor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.deng.netmonitor.R;
import com.deng.netmonitor.base.BaseActivity;
import com.caption.netmonitorlibrary.netStateLib.NetUtils;

public class MainActivity extends BaseActivity {

    private TextView mTvState;
    private RelativeLayout mRlContent;
    private Button btn_popuwindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_popuwindow = (Button) findViewById(R.id.btn_popuwindow);
        btn_popuwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PopuActivity.class);
                startActivity(intent);
            }
        });
        mTvState = (TextView) findViewById(R.id.tv_state);
        mRlContent = (RelativeLayout) findViewById(R.id.rl_state_content);
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {
        mTvState.setText("网络连接正常\n" + type.name());
        mRlContent.setVisibility(View.GONE);
    }

    @Override
    protected void onNetworkDisConnected() {
        mTvState.setText("网络连接断开");
        mRlContent.setVisibility(View.VISIBLE);
    }
}
