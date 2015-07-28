package com.codepath.testingdemo.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.codepath.testingdemo.R;
import com.codepath.testingdemo.data.Data;
import com.codepath.testingdemo.models.Post;
import com.codepath.testingdemo.networking.DemoHttpClient;

import java.util.List;

public class NetworkRequestActivity extends GameLevelActivity {

    public DemoHttpClient demoHttpClient;
    private Button btnCompleteLevel;

    public void setDemoHttpClient(DemoHttpClient demoHttpClient) {
        this.demoHttpClient = demoHttpClient;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_request);
        btnCompleteLevel = (Button)findViewById(R.id.btnCompleteLevel);
    }

    public void onSendNetworkRequestClicked(View view) {

        if (demoHttpClient == null) {
            demoHttpClient = new DemoHttpClient();
        }

        demoHttpClient.getAsynchronously("http://www.yahoo.com", new DemoHttpClient.HttpResponseCallback() {
            @Override
            public void onSuccess(List<Post> posts) {
                Toast.makeText(NetworkRequestActivity.this, "Network request success!", Toast.LENGTH_SHORT).show();
                btnCompleteLevel.setEnabled(posts != null && posts.size() == Data.POSTS.size());
            }

            @Override
            public void onFailure(int httpStatusCode) {
                Toast.makeText(NetworkRequestActivity.this, "Network request failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onCompleteLevelClicked(View view) {
        launchLevelPassedActivity();
    }
}
