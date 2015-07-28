package com.codepath.testingdemo.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.codepath.testingdemo.R;
import com.codepath.testingdemo.data.GameLevel;

public class LevelCompleteActivity extends AppCompatActivity {

    public static final String EXTRA_LEVEL_NUMBER = "levelNumber";

    private static final int PAUSE_TIME_BETWEEN_LEVELS = 4000; // 4 seconds

    int levelNumber;
    TextView tvLevelComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_complete);
        tvLevelComplete = (TextView) findViewById(R.id.tvLevelComplete);
        levelNumber = getIntent().getIntExtra(EXTRA_LEVEL_NUMBER, 0);
        tvLevelComplete.setText(getResources().getString(R.string.level_complete_message, levelNumber));
        runAsyncTask();
    }

    public void runAsyncTask() {
        new AsyncTask<Void, Void, Void>() {
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(PAUSE_TIME_BETWEEN_LEVELS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            protected void onPostExecute(Void result) {
                // Launch next level
                launchNextLevel(levelNumber + 1);
            }
        }.execute();
    }


    private void launchNextLevel(int levelNumber) {
        if (levelNumber > GameLevel.getNumberOfLevels()) {
            return;
        }
        Class klass = GameLevel.getClassForLevel(levelNumber);
        Intent intent = new Intent(this, klass);
        intent.putExtra(GameLevelActivity.EXTRA_LEVEL, levelNumber);
        startActivity(intent);
        finish();
    }
}
