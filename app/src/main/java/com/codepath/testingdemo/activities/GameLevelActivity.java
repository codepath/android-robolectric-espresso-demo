package com.codepath.testingdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class GameLevelActivity extends AppCompatActivity {
    public static final String EXTRA_LEVEL = "level";

    protected int currentLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.currentLevel = getIntent().getIntExtra(EXTRA_LEVEL, 1);
    }

    public void launchLevelPassedActivity() {
        Intent intent = new Intent(this, LevelCompleteActivity.class);
        intent.putExtra(LevelCompleteActivity.EXTRA_LEVEL_NUMBER, this.currentLevel);
        startActivity(intent);
        finish();
    }
}
