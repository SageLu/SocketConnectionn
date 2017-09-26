package com.deng.netmonitor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deng.netmonitor.R;

import java.util.ArrayList;

public class PopuActivity extends Activity implements OnClickListener {

    public static int screenW, screenH;

    private ImageButton backBtn, createBtn;
    private Button confirmBtn;
    private TextView topTv;
    private LinearLayout topll;
    private ImageView topIv;
    private TextView topLineTv;

    private TopMiddlePopup middlePopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popu);
        getScreenPixels();
        initWidget();
    }

    /**
     * 初始化控件
     */
    private void initWidget() {
        backBtn = (ImageButton) findViewById(R.id.urm_back_btn);
        createBtn = (ImageButton) findViewById(R.id.urm_create_btn);
        confirmBtn = (Button) findViewById(R.id.urm_confirm_btn);

        topll = (LinearLayout) findViewById(R.id.urm_top_ll);
        topIv = (ImageView) findViewById(R.id.urm_top_iv);

        topLineTv = (TextView) findViewById(R.id.rule_line_tv);

        topTv = (TextView) findViewById(R.id.urm_top_tv);
        topTv.setText("企业客户");

        backBtn.setOnClickListener(this);
        createBtn.setOnClickListener(this);
        confirmBtn.setOnClickListener(this);
        topll.setOnClickListener(this);

    }

    /**
     * 设置弹窗
     *
     * @param type
     */
    private void setPopup(int type) {
        middlePopup = new TopMiddlePopup(this, screenW, screenH,
                onItemClickListener, getItemsName(), type);
    }

    /**
     * 设置弹窗内容
     *
     * @return
     */
    private ArrayList<String> getItemsName() {
        ArrayList<String> items = new ArrayList<String>();
        items.add("企业客户");
        items.add("集团客户");
        items.add("公海客户");
        return items;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.urm_back_btn:
                setPopup(1);
                middlePopup.show(topLineTv);
                break;
            case R.id.urm_create_btn:
                setPopup(2);
                middlePopup.show(topLineTv);
                break;
            case R.id.urm_confirm_btn:

                break;
            case R.id.urm_top_ll:
                setPopup(0);
                middlePopup.show(topLineTv);
                break;
        }
    }

    /**
     * 弹窗点击事件
     */
    private OnItemClickListener onItemClickListener = new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            System.out.println("--onItemClickListener--:");
            middlePopup.dismiss();
        }
    };

    /**
     * 获取屏幕的宽和高
     */
    public void getScreenPixels() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenW = metrics.widthPixels;
        screenH = metrics.heightPixels;
    }

}
