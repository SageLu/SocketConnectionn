package com.hc.studymotion;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

public class WindowTransitionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_window_transitions);

//        Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
//        getWindow().setExitTransition(explode);
//        getWindow().setReenterTransition(explode);
//        getWindow().setEnterTransition(explode);
    }

    public void onCellClick(View v) {
        Intent intent = new Intent(this, SecondWindowTransActivity.class);

        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
