package com.hc.studymotion;

import android.animation.Animator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;

public class CircularRevealActivity extends AppCompatActivity implements View.OnClickListener {
    private View secondView;
    private FloatingActionButton floatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_reveal);
        secondView = findViewById(R.id.second);
        floatBtn = (FloatingActionButton) findViewById(R.id.floatBtn);
        floatBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        secondView.setVisibility(View.VISIBLE);
        int centerX = (v.getLeft() + v.getRight()) / 2;
        int centerY = (v.getTop() + v.getBottom()) / 2;
        float finalRadius = (float) Math.hypot((double) centerX, (double) centerY);
        Animator mCircularReveal = ViewAnimationUtils.createCircularReveal(
                secondView, centerX, centerY, 0, finalRadius);

        mCircularReveal.setDuration(400).start();
    }


}
