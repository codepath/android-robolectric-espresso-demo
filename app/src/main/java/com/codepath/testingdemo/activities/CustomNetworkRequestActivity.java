package com.codepath.testingdemo.activities;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.widget.Button;

import com.codepath.testingdemo.R;

public class CustomNetworkRequestActivity extends GameLevelActivity {

    public interface CustomHttpClient {
        void makeRequest();
    }

    private CustomHttpClient customHttpClient;
    private Button btnCompleteLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_network_request);

        btnCompleteLevel = (Button)findViewById(R.id.btnCompleteLevel);

        setCustomHttpClient(new CustomHttpClient() {
            @Override
            public void makeRequest() {
                SystemClock.sleep(5000); // 5 seconds
            }
        });
    }

    public void onMakeRequestClick(View view) {
        Thread t = new Thread() {
            @Override
            public void run() {
                customHttpClient.makeRequest();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        btnCompleteLevel.setEnabled(true);
                    }
                });
            }
        };
        t.start();
    }

    public void onCompleteLevelClicked(View view) {
        launchLevelPassedActivity();
    }

    @VisibleForTesting
    public CustomHttpClient getCustomHttpClient() {
        return customHttpClient;
    }

    @VisibleForTesting
    public void setCustomHttpClient(CustomHttpClient customHttpClient) {
        this.customHttpClient = customHttpClient;
    }
}
