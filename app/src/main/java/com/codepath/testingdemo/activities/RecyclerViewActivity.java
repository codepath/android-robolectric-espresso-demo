package com.codepath.testingdemo.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.codepath.testingdemo.R;
import com.codepath.testingdemo.adapters.PostsRecyclerViewAdapter;
import com.codepath.testingdemo.data.Data;
import com.codepath.testingdemo.models.Post;

import java.util.List;

/*
 * Simple RecyclerView that shows a userName / caption in each item
 */
public class RecyclerViewActivity extends GameLevelActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView rvPosts = (RecyclerView) findViewById(R.id.rvPosts);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvPosts.setLayoutManager(layoutManager);
        rvPosts.setHasFixedSize(true);

        List<Post> posts = Data.POSTS;

        PostsRecyclerViewAdapter adapter = new PostsRecyclerViewAdapter(posts);

        adapter.setOnItemClickListener(new PostsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if (position == 2) {
                    launchLevelPassedActivity();
                }
            }
        });
        rvPosts.setAdapter(adapter);

    }
}
