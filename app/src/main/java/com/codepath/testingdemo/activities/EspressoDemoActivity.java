package com.codepath.testingdemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codepath.testingdemo.R;
import com.codepath.testingdemo.data.Data;
import com.codepath.testingdemo.models.Post;

public class EspressoDemoActivity extends AppCompatActivity {

    TextView tvSearchText;
    EditText etSearch;
    Button btnSubmit;

    TextView tvFormattedLikers;

    Button btnDisplayFormattedLikers;

    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_demo);

        etSearch = (EditText)findViewById(R.id.etSearch);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        tvSearchText = (TextView)findViewById(R.id.tvSearchText);

        tvFormattedLikers = (TextView)findViewById(R.id.tvFormattedLikers);
        btnDisplayFormattedLikers = (Button)findViewById(R.id.btnDisplayFormattedLikers);

    }

    public void onSubmitClicked(View view) {
        tvSearchText.setText(etSearch.getText().toString());
        etSearch.setText("");
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void onDisplayFormattedLikersClicked(View view) {
        if (post == null) {
            post = Data.POSTS.get(0);
        }
        tvFormattedLikers.setText(post.formatLikersForDisplay("likes"));
    }
}
