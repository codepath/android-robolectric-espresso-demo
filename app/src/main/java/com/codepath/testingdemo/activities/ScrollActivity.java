package com.codepath.testingdemo.activities;

import android.os.Bundle;
import android.view.View;

import com.codepath.testingdemo.R;

public class ScrollActivity extends GameLevelActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
    }

    public void onCompleteLevelClicked(View view) {
        // Launch next level
        launchLevelPassedActivity();
    }
}
